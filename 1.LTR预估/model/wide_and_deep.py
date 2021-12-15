from tensorflow.keras.models import Model
from core import *

DICT_CATEGORICAL = {
    "category1_id": [str(i) for i in range(0, 228)],
    "pack_name": [str(i) for i in range(0, 248)]
}

feature_columns = [
    SparseFeat(name="app_id", voc_size=500, hash_size=500, share_embed=None, embed_dim=8, dtype=tf.string),
    SparseFeat(name="category1_id", voc_size=228, hash_size=None, share_embed=None, embed_dim=8, dtype=tf.string),
    DenseFeat(name="alive_time", pre_embed=None, dim=1, dtype=tf.float32),
    VarLenSparseFeat(name="active_pack_list", voc_size=248, hash_size=None, share_embed='pack_name', weight_name=None, combiner='mean', embed_dim=8, maxlen=5, dtype=tf.string),
    VarLenSparseFeat(name="uninstall_app_list", voc_size=500, hash_size=500, share_embed='app_id', weight_name='uninstall_app_weight', combiner='mean', embed_dim=8, maxlen=5, dtype=tf.string)
]

DEFAULT_VALUES = [
    ['0'], ['0'], [0.0], ['0'], ['0'], [0]
]

COL_NAME = [
    "app_id", "category1_id", "alive_time", "active_pack_list", "uninstall_app_list", "label"
]


def _parse_function(example_proto):
    item_feats = tf.io.decode_csv(example_proto, record_defaults=DEFAULT_VALUES)
    parsed = dict(zip(COL_NAME, item_feats))

    feature_dict = {}
    for feat_col in feature_columns:
        if isinstance(feat_col, VarLenSparseFeat):
            if feat_col.weight_name is not None:
                kvpairs = tf.strings.split([parsed[feat_col.name]], ',').values[:feat_col.maxlen]
                kvpairs = tf.strings.split(kvpairs, ':')
                kvpairs = kvpairs.to_tensor()
                feat_ids, feat_vals = tf.split(kvpairs, num_or_size_splits=2, axis=1)
                feat_ids = tf.reshape(feat_ids, shape=[-1])
                feat_vals = tf.reshape(feat_vals, shape=[-1])
                if feat_col.dtype != 'string':
                    feat_ids = tf.strings.to_number(feat_ids, out_type=tf.int32)
                feat_vals = tf.strings.to_number(feat_vals, out_type=tf.float32)
                feature_dict[feat_col.name] = feat_ids
                feature_dict[feat_col.weight_name] = feat_vals
            else:
                feat_ids = tf.strings.split([parsed[feat_col.name]], ',').values[:feat_col.maxlen]
                feat_ids = tf.reshape(feat_ids, shape=[-1])
                if feat_col.dtype != 'string':
                    feat_ids = tf.strings.to_number(feat_ids, out_type=tf.int32)
                feature_dict[feat_col.name] = feat_ids

        elif isinstance(feat_col, SparseFeat) or isinstance(feat_col, DenseFeat):
            feature_dict[feat_col.name] = parsed[feat_col.name]

        else:
            raise Exception("unknown feature_columns....")

    label = parsed['label']

    return feature_dict, label

pad_shapes = {}
pad_values = {}

for feat_col in feature_columns:
    if isinstance(feat_col, VarLenSparseFeat):
        max_tokens = feat_col.maxlen
        pad_shapes[feat_col.name] = tf.TensorShape([max_tokens])
        pad_values[feat_col.name] = '0' if feat_col.dtype == 'string' else 0
        if feat_col.weight_name is not None:
            pad_shapes[feat_col.weight_name] = tf.TensorShape([max_tokens])
            pad_values[feat_col.weight_name] = tf.constant(-1, dtype=tf.float32)

    elif isinstance(feat_col, SparseFeat):
        if feat_col.dtype == 'string':
            pad_shapes[feat_col.name] = tf.TensorShape([])
            pad_values[feat_col.name] = '0'
        else:
            pad_shapes[feat_col.name] = tf.TensorShape([])
            pad_values[feat_col.name] = 0
    elif isinstance(feat_col, DenseFeat):
        if not feat_col.pre_embed:
            pad_shapes[feat_col.name] = tf.TensorShape([])
            pad_values[feat_col.name] = 0.0
        else:
            pad_shapes[feat_col.name] = tf.TensorShape([feat_col.dim])
            pad_values[feat_col.name] = 0.0


pad_shapes = (pad_shapes, (tf.TensorShape([])))
pad_values = (pad_values, (tf.constant(0, dtype=tf.int32)))

batch_size = 1024
filenames     = tf.data.Dataset.list_files(['../data/train.csv'])
dataset_train = filenames.flat_map(lambda filepath: tf.data.TextLineDataset(filepath).skip(1))
dataset_train = dataset_train.map(_parse_function, num_parallel_calls=60)
dataset_train = dataset_train.padded_batch(batch_size = batch_size, padded_shapes = pad_shapes, padding_values = pad_values)

filenames     = tf.data.Dataset.list_files(['../data/valid.csv'])
dataset_valid = filenames.flat_map(lambda filepath: tf.data.TextLineDataset(filepath).skip(1))
dataset_valid = dataset_valid.map(_parse_function, num_parallel_calls=60)
dataset_valid = dataset_valid.padded_batch(batch_size = batch_size, padded_shapes = pad_shapes, padding_values = pad_values)

filenames     = tf.data.Dataset.list_files(['../data/test.csv'])
dataset_test  = filenames.flat_map(lambda filepath: tf.data.TextLineDataset(filepath).skip(1))
dataset_test  = dataset_test.map(_parse_function, num_parallel_calls=60)
dataset_test  = dataset_test.padded_batch(batch_size = batch_size, padded_shapes = pad_shapes, padding_values = pad_values)

def wide_and_deep_model(feature_columns, DICT_CATEGORICAL):
    features = build_input_features(feature_columns)
    inputs_list = list(features.values())

    linear_embedding_dict = build_linear_embedding_dict(feature_columns)
    linear_sparse_embedding_list, linear_dense_value_list = input_from_feature_columns(features, feature_columns, linear_embedding_dict, DICT_CATEGORICAL)
    nn_input_layer = concat_embedding_dense(linear_sparse_embedding_list, linear_dense_value_list)

    ## nn部分
    f0 = tf.keras.layers.Dense(1024, activation="relu", name="f0")(nn_input_layer)
    f1 = tf.keras.layers.Dense(512, activation="relu", name="f1")(f0)
    f2 = tf.keras.layers.Dense(256, activation="relu", name="f2")(f1)

    ## linear部分
    linear_input_layer = Concatenate(axis=1)(linear_dense_value_list)

    ## 连接nn和linear部分
    input_layer        = Concatenate(axis=1)([f2, linear_input_layer])

    output = tf.keras.layers.Dense(1, use_bias=True, activation="sigmoid", name="model_out")(input_layer)
    model = Model(inputs=inputs_list, outputs=output)
    model.compile(optimizer="adam", loss="binary_crossentropy", metrics=tf.keras.metrics.AUC(name='auc'))

    return model

model        = wide_and_deep_model(feature_columns, DICT_CATEGORICAL)
model.summary()
history_loss = model.fit(dataset_train, validation_data=dataset_valid, epochs=5)
model.evaluate(dataset_test)