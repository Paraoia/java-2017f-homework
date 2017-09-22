# 第二次Java作业说明



## 格式说明

源代码字符编码格式为ANSI。如果要在IDEA中编译运行，请先转为UTF8格式



## 源文件说明

### GourdDoll.java

- 定义了一个葫芦娃的属性，包括name（“红娃”、“橙娃”等）和value（从0~6，用于标识排行）；
- 提供了葫芦娃对外报出自己名字和排行的接口speakRank()和speakColor()。





### MySort.java

- 定义了两种排序的算法——冒泡排序(bubbleSort())和快速排序(quickSort()和partition())；
- report()函数用于排序过程中在GourdDoll数组发生改变时报告葫芦娃的交换动作。





### Game.java

- 定义了showColor()和showRank()函数，来让葫芦娃数组报出自己的颜色和排行；
- 定义了getRandomArray()函数，打乱葫芦娃顺序；
- 提供程序的main()函数，运行程序的主体。