#面向葫芦娃编程的设计理念说明
Authored by 151220015 陈智麒
##Part 1 设计总览
`UML`类视图：

![](https://i.imgur.com/eMNx5MA.png)

实现了`Main`,`Map`,`Position`,`Queue`,`BubbleSorter`,`QuickSorter`,`HuluWa`,`Xiaolouluo`,`Grandpa`,`Xiezijing`,`Shejing`等类，以及`Sorter`,`Comparable`,`Creature`等接口，从而实现了整个`HuluwaGo`工程。其中`Main`是整个工程运行的入口，建议从`Main`类开始阅读。

##Part 2 封装性的体现

1. 尽量少的暴露内部实现细节，对上层屏蔽不必要的复杂性。
2. 所有类的内部数据全部使用`private`修饰，通过`getter`和`setter`函数来进行数据的获取和赋值。
3. 对象之间的通信通过`public`修饰过的方法的调用来实现。
4. 内部类的使用：以类`Queue`为例，其实现了一个名为`QueueType`的内部类，用来指定这个`queue`内部保存的队形，避免外界对`QueueType`不必要的访问，体现了封装性。
5. 多继承：将葫芦娃与老爷爷归为好人`GoodMan`一类，蛇精、蝎子精与小喽啰归为坏人`BadMan`一类，这是基于未来可能根据阵营的不同会有进一步不同的方法的考虑。

##Part 3 继承与多态
1. 实现了`Comparable`接口，任何类只要实现了这个接口，表明其都是可比较的，可以调用`biggerThan`方法来进行比较操作。
2. 实现了`Sorter`接口，一定程度上规范了`QuickSorter`和`BubbleSorter`类的书写，今后如果需要实现新的排序器，按照这个接口书写即可，拥有良好的扩展性。
3. `Grandpa`,`Xiezijing`,`Xiaolouluo`,`Shejing`以及`Huluwa`都实现了`Creature`接口，表明其拥有`Creature`的所有特征。这样`Position`在考虑时只要认为其拥有的是一个`Creature`即可，而不需要为每一种Creature分门别类实现好相应的[API](http://baike.baidu.com/link?url=mduBrN0S5o74mLDjr5N_XB_-vDQaovZVyCKeFCTgp_IyzifrRt_jV6P_g5MOcSm-K-6nV4VtkDGjCwd8iLma8q)。
4. 在类`Queue`中使用[代理模式](https://baike.baidu.com/item/%E4%BB%A3%E7%90%86%E6%A8%A1%E5%BC%8F)，来动态的指定`Sorter`的具体类型，有`BubbleSorter`和`QuickSorter`，其内部实现的排序算法不同，但是暴露给上层的接口是一致的。

##Part 4 关于队列队形
使用一个二维的int型数组来保存具体的队形，如
	
	case 长蛇:
        //creatures.length should be 7
        table = new int[][]{
                    {x, y},
                    {x-1, y},
                    {x-2, y},
                    {x-3, y},
                    {x-4, y},
                    {x-5, y},
                    {x-6, y}
        };
        break;

然后对这个二维数组循环取值，得到的长度为2的数组即为这个点的坐标，这样做的好处是避免了对每一个Position赋值的时候带来的大量冗余代码，显得简洁明了，而且数据位置集中，易于修改。

	for (int i = 0; i < positions.length; i++) {
        this.positions[i] = new Position(table[i][0], table[i][1]);
        positions[i].setHolder(creatures[i]);
    }