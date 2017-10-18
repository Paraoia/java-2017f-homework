对于第三次编程作业中面向对象的说明
===============================
## 关于二维空间
在老师提供的代码上，将`Position`扩展为包含`int x`和`int y`的对象，用来表示二维空间<br>
仿照提供代码的`Queue`，定义`Map`，包含`positions[][]`和`creatures[][]`两个二维数组的内部成员用以放置人物对象<br>
将`main()`放入`Map`中，创造一个“世界”，更好地管理整个程序的所有对象
## 关于人物
对于其中的人物类，每一个都落实了`Creature`的接口<br>
因此每一个人物都可以`report()`，`setPosition()`，`getPosition()`<br>
这样可以使得人物类之间“高内聚”

## 关于排序和布阵
排序部分仿照老师代码中的`Sorter`接口，在`BubbleSorter`和`InsertionSorter`中各自具体实现<br>
布阵部分定义了`Marshal`和`Cheer`的接口，分别用`HeYiZhen`，`FangZhen`和`SnakeCheer`，`GrandfatherCheer`具体实现<br>
使得布阵的函数之间“高内聚”，同时划分了“蝎子精”“小喽啰”的布阵和“蛇精”“爷爷”的加油，符合“低耦合”的要求
## 关于打印对峙局面
在`Map`中定义打印的成员函数`showMap()`来打印对峙局面<br>
将关于全局的函数掌握在`Map`的“上帝之手”中
