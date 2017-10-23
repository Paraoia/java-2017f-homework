# 第三次作业
## 代码说明
本次作业参考了曹老师所给的example,并在其代码框架上增加了本次作业所要求的内容；

1.葫芦娃，爷爷，蛇精，蝎子精等各自成类继承于接口Creature；
2.类Position有一变量Point,类Point记录二维空间的坐标；
3.布阵类Embattle设置多个生物的二维坐标，即设置Creature.Position；
4.二维空间类Space中有一个Position类型的二维数组，对应于源代码框架中的类Queue中有Position类型的一维数组；Space将Queue放进二维空间；
## 设计原则
### 单一责任原则
每个类都只完成一个功能，如新增的类Embattle只完成设置生物的二维坐标功能，Space只完成将Queue和单个生物放进二维空间的功能（即存储于Position类型的二维数组）；
### 里氏替换原则 
Huluwa,Grandfather等类继承于Creature，它们都能够替代creature的任何实例，因此对生物进行操作的函数都可以将Creature类型的变量作为形参；
