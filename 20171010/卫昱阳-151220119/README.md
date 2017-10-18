对于第三次编程作业中面向对象的说明
===============================
## 关于二维空间
在老师提供的代码上，将`Position`扩展为包含`int x`和`int y`的对象，用来表示二维空间<br>
仿照提供代码的`Queue`，定义`Map`，包含`positions[][]`和`creatures[][]`两个二维数组的内部成员用以放置人物对象
## 关于人物
对于其中的人物对象，每一个都落实了`Creature`的接口<br>
因此每一个人物都可以`report()`，`setPosition()`，`getPosition()`
## 关于排序和布阵
排序部分仿照老师代码中的`Sorter`接口，在`BubbleSorter`和`InsertionSorter`中各自具体实现<br>
布阵部分定义了`Marshal`和`Cheer`的接口，分别用`HeYiZhen`，`FangZhen`和`SnakeCheer`，`GrandfatherCheer`具体实现
## 关于打印对峙局面
在`Map`中定义打印的成员函数`showMap()`来打印对峙局面
