# JMeter压测
## 为什么要做压测？
对于我个人而言，我的工作是算法工程师，经常需要上线新的算法或策略，从而改动线上代码。在改动线上代码后，自测、预测回归、压测都是必不可少的步骤。只有经过这些步骤的检测，才能保证所上线算法或策略能够吐出符合预期的预测值、保证线上服务的稳定性。</br>
当然，如果是做后端研发的同学，可能更加需要做压测的工作。

## 安装JMeter
1.配置JDK1.8，https://www.jianshu.com/p/a85658902f26</br>
2.下载二进制版本的JMeter，http://jmeter.apache.org/download_jmeter.cgi</br>
![下载JMeter](https://github.com/yaoleiliu/Great-Development-Tools/blob/master/JMeter%E5%8E%8B%E6%B5%8B/image/1.png)
3.解压后，进入bin目录，sh jmeter启动

## 开始压测
### 1.新建一个线程组并设置参数
![新建线程组](https://github.com/yaoleiliu/Great-Development-Tools/blob/master/JMeter%E5%8E%8B%E6%B5%8B/image/2.png)
~</br>
![设置线程组参数](https://github.com/yaoleiliu/Great-Development-Tools/blob/master/JMeter%E5%8E%8B%E6%B5%8B/image/3.png)

### 2.新建http请求默认值
![新建http请求默认值](https://github.com/yaoleiliu/Great-Development-Tools/blob/master/JMeter%E5%8E%8B%E6%B5%8B/image/4.png)
~</br>
![设置参数](https://github.com/yaoleiliu/Great-Development-Tools/blob/master/JMeter%E5%8E%8B%E6%B5%8B/image/5.png)

### 3.新建压测http请求
![新建http请求](https://github.com/yaoleiliu/Great-Development-Tools/blob/master/JMeter%E5%8E%8B%E6%B5%8B/image/6.png)
~</br>
![设置参数](https://github.com/yaoleiliu/Great-Development-Tools/blob/master/JMeter%E5%8E%8B%E6%B5%8B/image/7.png)

### 4.新建监听器
![新建监听器](https://github.com/yaoleiliu/Great-Development-Tools/blob/master/JMeter%E5%8E%8B%E6%B5%8B/image/8.png)
~</br>
![查看结果](https://github.com/yaoleiliu/Great-Development-Tools/blob/master/JMeter%E5%8E%8B%E6%B5%8B/image/9.png)

### 5.批量设置参数
https://www.cnblogs.com/puresoul/p/4742120.html

## 指标
对这方面还没有深入的研究，我一般只看响应时间有没有显著增加。
