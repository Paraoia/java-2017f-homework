# 第二次Java作业说明



## 格式说明

源代码字符编码格式为ANSI。如果要在IDEA中编译运行，请先转为UTF8格式



## 源文件说明

### GourdDoll.java

- 定义了一个葫芦娃的属性，包括name（“红娃”、“橙娃”等）和value（从0~6，用于标识排行）；
- getRank()获取葫芦娃的排行；
- getName()获取葫芦娃的名字；
- speakRank()报出葫芦娃的排行；
- speakName()报出葫芦娃的名字；
- 静态函数swap()实现了葫芦娃数组中两个葫芦娃位置的交换。





### Grandpa.java

- 模拟爷爷指挥葫芦娃们进行两种排序（bubbleSort和quickSort）并报告交换动作(report)





### MyQueue.java

- 模拟老爷爷和七个葫芦娃的排序队列
- 定义了showName()和showRank()函数，来让葫芦娃数组报出自己的名字和排行；
- 定义了getRandomArray()函数，打乱葫芦娃顺序；
- 提供程序的main()函数，运行程序的主体。