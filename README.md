## 业务策略算法  
### 业务篇  
1. [[广告策略算法系列一]：前言](https://zhuanlan.zhihu.com/p/562709582)  
2. [[广告策略算法系列二]：预算分配](https://zhuanlan.zhihu.com/p/563703603)   
3. [[广告策略算法系列三]：广告创意优化](https://zhuanlan.zhihu.com/p/573934656)  
4. [[广告策略算法系列四]：新广告冷启动优化](https://zhuanlan.zhihu.com/p/576284128)   
5. [[广告策略算法系列五]：成本控制策略](https://zhuanlan.zhihu.com/p/576875433)  
6. [[广告策略算法系列六]：匀速投放](https://zhuanlan.zhihu.com/p/577251677)  
7. [[广告策略算法系列七]：预估校准机制](https://zhuanlan.zhihu.com/p/460061332)  
8. [[广告策略算法系列八]：多约束条件下的出价优化](https://zhuanlan.zhihu.com/p/578360412)  
9. [[广告策略算法系列九]：多约束条件下的排序公式优化](https://zhuanlan.zhihu.com/p/578419112)  
10. [[广告策略算法系列十]：混排策略和算法](https://zhuanlan.zhihu.com/p/578451879)    
11. [[广告策略算法系列十一]：联盟RTB策略](https://zhuanlan.zhihu.com/p/578534114)

### 数据和算法篇
1. [[广告策略算法系列十二]：浅谈博弈论与经济学的关系](https://zhuanlan.zhihu.com/p/350141414)  
2. [[广告策略算法系列十三]：优化问题中的对偶理论](https://zhuanlan.zhihu.com/p/370831294)  
3. [[广告策略算法系列十四]：常用预估模型及TF实现](https://zhuanlan.zhihu.com/p/578556542)  
4. [[广告策略算法系列十五]：LTR预估](https://zhuanlan.zhihu.com/p/451870920)  
5. [[广告策略算法系列十六]：基于上下文感知的重排序算法](https://zhuanlan.zhihu.com/p/476786210) 
6. [[广告策略算法系列十七]：强化学习基础](https://zhuanlan.zhihu.com/p/578639556)  
7. [[广告策略算法系列十八]：Spark编程](https://zhuanlan.zhihu.com/p/581332362)

## 论文分享  
### 智能出价
[KDD2019, Alibaba]. Bid Optimization by Multivariable Control in Display Advertising  
[AAMAS2020, ByteDance]. Optimized Cost per Mille in Feeds Advertising   
[KDD2021, Alibaba]. A Unified Solution to Constrained Bidding in Online Display Advertising      
 
### 排序策略
[ORSUM2019, Alibaba]. Optimal Delivery with Budget Constraint in E-Commerce Advertising    
[KDD2020, LinkedIn]. Ads Allocation in Feed via Constrained Optimization  
[2020, KuaiShou]. Cold Start on Online Advertising Platforms: Data-Driven Algorithms and Field Experiments    
 
### 竞价环境预估 
[KDD2014]. Optimal Real-Time Bidding for Display Advertising  
[KDD2015]. Bid Landscape Forecasting in Online Ad Exchange Marketplace   
[KDD2015]. Predicting Winning Price in Real Time Bidding with Censored Data  
[KDD2016]. User Response Learning for Directly Optimizing Campaign Performance in Display Advertising  
[KDD2016]. Functional Bid Landscape Forecasting for Display Advertising  
[KDD2017]. A Gamma-Based Regression for Winning Price Estimation in Real-Time Bidding Advertising  
[KDD2018]. Bidding Machine Learning to Bid for Directly Optimizing Profits in Display Advertising  
[KDD2019]. Deep Landscape Forecasting for Real-time Bidding Advertising

### 广告创意优化
[April2021, Alibaba]. A Hybrid Bandit Model with Visual Priors for Creative Ranking in Display Advertising  
[March2021, Alibaba]. Efficient Optimal Selection for Composited Advertising Creatives with Tree Structure  
[April2021, Alibaba]. Automated Creative Optimization for E-Commerce Advertising  
[SIGIR2022, Alibaba]. Joint Optimization of Ad Ranking and Creative Selection 
[NAACL2022, Alibaba]. CREATER: CTR-driven Advertising Text Generation with Controlled Pre-Training and Contrastive Fine-Tuning   
[SIGIR2022, Alibaba]. Towards Personalized Bundle Creative Generation with Contrastive Non-Autoregressive Decoding  
[WeChat2022, ByteDance]. [广告素材优选算法在内容营销中的应用实践](https://mp.weixin.qq.com/s/gVuG4mCqGxWBmS8GD6JZfw)

### 重排算法
[IJCAJ2018, Alibaba]. Globally Optimized Mutual Influence Aware Ranking in E-Commerce Search  
[SIGIR2018, Qingyao Ai]. Learning a Deep Listwise Context Model for Ranking Refinement  
[RecSys2019, Alibaba]. Personalized Re-ranking for Recommendation  
[CIKM2020, Alibaba]. EdgeRec-Recommender System on Edge in Mobile Taobao  
[Artix2021, Alibaba]. Revisit Recommender System in the Permutation Prospective    
 
### 校准算法
[KDD2020, Alibaba]. Calibrating User Response Predictions in Online Advertising  
[WWW2020, Tencent]. A Simple and Empirically Strong Method for Reliable Probabilistic Predictions  
[WWW2022, Alibaba]. MBCT Tree-Based Feature-Aware Binning for Individual Uncertainty Calibration  
 
### CTR预估
[ICDM2010, Steffen Rendle]. Factorization Machines   
[KDD2014, Facebook]. Practical Lessons from Predicting Clicks on Ads at Facebook  
[RecSys2016]. Field-aware Factorization Machines for CTR Prediction      
[DLRS2016, Geogle]. Wide & Deep Learning for Recommender Systems  
[TOIS2016]. Product-based Neural Networks for User Response Prediction  
[IJCAI2017, Huawei]. DeepFM: A Factorization-Machine based Neural Network for CTR Prediction  
[IJCAJ2017]. Attentional Factorization Machines-Learning the Weight of Feature Interactions via Attention Networks  
[KDD2017, Geogle]. Deep & Cross Network for Ad Click Predictions  
[KDD2018, Microsoft]. xDeepFM-Combining Explicit and Implicit Feature Interactions for Recommender Systems  
 
### CVR预估
[SIGIR2018, Alibaba]. Entire Space Multi-Task Model-An Effective Approach for Estimating Post-Click Conversion Rate
 
### LTR预估
[ICML2005, Microsoft]. Learning to Rank using Gradient Descent  
[Report2010, MSRA]. From RankNet to LambdaRank to LambdaMART-An overview   
 
 ### Other MLs 
[KDD2016, Tianqi Chen]. XGBoost: A Scalable Tree Boosting System
