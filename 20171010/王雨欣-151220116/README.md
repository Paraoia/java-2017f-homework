---
#程序设计说明
---
##用到的面向对象的概念、机制：
###1. 抽象
将一些数据和过程抽象成一个类，集中于事物的本质特性，而非具体细节或具体实现，用抽象的观点来看待问题。
在此作业中，分析认为主要包括了三种事物：*二维空间*、*各种生物*、*操纵生物在空间排序的God*。

生物类：

`public class Creature {...}`

二维空间类：

`public class Space{...}`

操作实现类：

`public class EnterSpace{...}`

其中，对于Space二维空间，其实由N*N个位置组成。因为每个位置可能具有各种操作，所以将位置抽象出来构成了单独的类Position:

`public class Position{...}`          

此外，抽象不仅仅针对物体，也针对过程。在EnterSpace类包含的各种操作中，将步骤尽量分离与抽象出来，需要时直接调用即可。


###2.封装
所谓封装就是把某个事物包装起来，使外界不知道该事物的具体内容。其通过向外界提供接口的形式而存在。在该程序中也运用了该机制。

**例如对于生物类：**
```java
public class Creature {
    /* 生物的名字 */
    String name;
    /* 生物的长相 */
    char pattern;
    /* 构造函数 */
    Creature(String str, char pa){
        name = str;
        pattern = pa;
    }
}
```
每一个生物都有它的名字name和长相pattern(不同类型生物有不同长相)。

**对于位置类：**
```java
public class Position {
    boolean taken;
    Creature holder;
    /* 构造函数，实现成员定义时初始化 */
    Position(){
        taken = false;
        holder = null;
    }
    /* 该位置被生物a占用 */
    void Take(Creature a) {
        taken = true;
        holder = new Creature(a.name, a.pattern);
    }
    /* 释放该位置上的生物 */
    void Reset() {
        taken = false;
        holder = null;
    }
}
```

每一个位置可进行的操作有：初始化、位置上站一个生物、位置上的生物离开。

  
.


##优点：

1. 封装可以实现信息的隐蔽。将类包含的成员与具体操作过程隐藏起来，仅提供外界使用所需接口。这样便于调用和修改，也方便使用对象。

2. 抽象方便了对编程过程的理解，增强了自然性。将事物抽象后，尽量模拟现实世界，也增强了程序的可读性与可维护性。这也是OO编程设计中最重要的思想吧...

3. 抽象也增强了软件的复用性。例如在EnterSpace类中，因为排列时要进行多次将某一生物安排到特定位置的操作，所以将这一功能抽象分离出来，需要时只需要调用特定函数即可。
