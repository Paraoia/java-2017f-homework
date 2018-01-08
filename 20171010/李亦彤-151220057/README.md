# 第三次作业
## 151220057 李亦彤
###### 1.   将Creature，Comparable作为接口，Huluwa，Snake，Scorpion，Grandpa，Buddy均遵循Creature中的方法，这样保证每个类都包含setPosition等功能，而且可以在不同类中修改各自实现的方法。而且一个类可以根据不同需求实现多个接口，进行不同属性的方法的管理。
###### 2.   将Queue作为基类，葫芦娃和小喽啰的队列均为Queue的子类。Queue中存储队列中每一个位置的Position以及Creature，Position包括当前位置的横纵坐标。相同的getPositions，rollCall等方法在Queue中实现，而排阵型的函数分别在Huluwa_queue，以及BudsAndScor_queue中实现。减少了代码量而且能够更清楚的体现类之间的关系。
###### 3.   将整个方阵使用Array类实现，对所有的Creature进行管理。SetQueue函数实现将Queue类放置在空间内的功能，set_creature函数实现将单个Creature放置在空间内的函数。因为使用了Creature接口和Queue基类,所以不需要再对其衍生的子类实现更多函数，所有类都可使用两个函数之一进行操作，实现了抽象和封装，减少的代码的重复。Show函数实现了将整个方阵进行打印输出的功能。
