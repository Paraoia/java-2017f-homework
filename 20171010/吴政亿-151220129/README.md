# 151220129 计科 吴政亿

## 一、代码框架

Class Name | Class Information
-----------|-----------------------------------------
Main       | 包含了整个程序的main函数，执行操作的模块
Queue      | 定义了一个队列容器
Position   | 定义了一个二维空间，成员有Creature[ ][ ]
Creature   | 定义了生物类，是以下模块的基类
Calabash   | 定义了葫芦娃类，是Creature的派生类
Grandpa    | 定义了爷爷类，是Creature的派生类
Minion     | 定义了小喽啰类，是Creature的派生类
Scorpion   | 定义了蝎子精类，是Minion的派生类
Snake      | 定义了蛇精类，是Creature的派生类

## 二、类的关系

```

                               +-------------+
                               |             |    Interface
                          +--->+  Grandpa    +<---------------+
+-------------+           |    |             |                |
|             |           |    +-------------+                |
|  Main       |           |                                   |
|             |           |    +-------------+          +-----+-------+
+-------------+           |    |             |          |             |
                          +--->+  Calabash   |          |  Queue      |
+-------------+           |    |             |          |             |
|             |  extend   |    +-------------+          +-------------+
|  Creature   +----------->
|             |           |    +-------------+          +-------------+
+------+------+           |    |             |  extend  |             |
       ^                  +--->+  Minion     +--------->+  Scorpion   |
       | Interface        |    |             |          |             |
+------+------+           |    +-------------+          +-------------+
|             |           |
|  Position   |           |    +-------------+
|             |           |    |             |
+-------------+           +--->+  Snake      |
                               |             |
                               +-------------+


```

## 三、类详解

### Main

其中执行了老师所规定的操作

### Position

Define                                                | Information
------------------------------------------------------|----------------------------------------------------
int N                                                 | 定义了二维空间的大小
Creature Point[N][N]                                  | 定义了一个二维的Creature类
void SetN()                                           | 更改二维数组宽度和高度
void InitPoint()                                      | 用N初始化二维数组Creature
void Echo()                                           | 打印当前阵型
boolean AddCreature(int x, int y, Creature Creature)  | 再[x][y]处添加一个creature,如果已有生物则返回false
boolean SnakeArray(int x, int y, Queue creatures)     | 以[x][y]为头将Queue中creatures布长蛇阵
boolean CraneWingArray(int x, int y, Queue creatures) | 以[x][y]为头将Queue中creatures布鹤翼阵
boolean BluntYokeArray(int x, int y, Queue creatures) | 以[x][y]为头将Queue中creatures布冲轭阵

### Creature

Define                 | Information
-----------------------|---------------------------
CreatureType           | 定义了Creature的类型
CreatureType type      | 类型
String name            | 名字
void Echo()            | 生物报名字，如为null则为空
void SetType()         | 重置生物类型及名字
boolean HaveCreature() | 判断是否有生物

### Calabash

Define                                                | Information
------------------------------------------------------|--------------------------
COLOR                                                 | 定义了颜色枚举
int index                                             | 葫芦娃的排名
COLOR color                                           | 葫芦娃的颜色
void SetCalabash(String name, int index, COLOR color) | 重置葫芦娃名字，排序，颜色
String GetName()                                      | 获得葫芦娃的名字
String GetColor()                                     | 获得葫芦娃的颜色
int GetIndex()                                        | 获得葫芦娃的排名

### Grandpa

Define                             | Information
-----------------------------------|-------------------------
Queue calabash                     | 放置葫芦娃
void bubbleSort()                  | 葫芦娃冒泡排序
void quickSort(int start, int end) | 葫芦娃快速排序
void ShuffleCalabash()             | 爷爷弄乱他们
void SortCalabash()                | 葫芦娃冒泡排序/快速排序
void CalabashEcho()                | 葫芦娃报名字/颜色

### Scorpion

Define | Information
---|---
Queue Minions | 存储了蝎子精和他的喽啰

### Queue

Define                          | Information
--------------------------------|-----------------------------
ArrayList List                  | 作为队列的存储容器
int Size()                      | 返回队列大小
void EnQueue(Creature creature) | 一个creature入列
void DeQueue(int index)         | 下标index出队列
Creature GetCreature(int index) | 返回下标index的生物指针
void swap(int a, int b)         | 下标为a，b的两个生物互换位置
void shuffle()                  | 打乱队列
void Echo()                     | 输出队列信息

## 代码思路

套用了第二次作业的内容并将一维扩展为二维，将Queue所面向的类由Calabash抽象为Creature，将本次作业划分为三个模块，main函数，Queue队列的实现，二维生物空间Position的实现。   
在本试验中，依旧是爷爷负责为葫芦娃们排序和打乱，所以爷爷的类中含有内部类Queue来存储葫芦娃们。

## 心得体会

在定义二维空间Position的DeleteCreature函数时，一开始报错没反应过来，错误为

``` java
Point[i][j].type = CreatureType.Null;
Point[x][y] = creature;
```

而我此时Point[i][j]指针所指向的便是我定义的生物，如果之后我再让他们再其他位置，实际上只是将这个目标位置Point[x][y]指向我定义为空的生物。

``` java
Point[i][j] = new Creature();
```

经过修改后，如果我想让Point[i][j]的生物离开，只需要给他分配一个新的空间即可，这样也保证了场上只有一个蝎子精等等，维持了一致性原则。