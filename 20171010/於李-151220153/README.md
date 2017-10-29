使用的面向对象机制
==
抽象类
--
所有的Creature都有一些公共的操作，所以将其定义为抽象类，对这些方法提供了默认的实现，减少了子类中的重复代码。

接口
--
对于Sorter和Comparable类来说，它们的不同子类中方法具体实现的方式不一样，因此将它们定义为完全抽象的接口。

多态
--
在Space中定义了justPower和evilPower两个Creature数组，没有做具体划分，在具体实现时则分别用Huluwa,Grandpa等进行替换，提高了程序的可维护性与扩展性。

使用的设计理念
==
SRP单一职责原则
--
每个类能实现的功能都很单一，Creature描述生物体的属性，Position描述生物体的位置，Sorter,Comparable,StrategySelector分别完成排序、比较和阵法选择的功能，Space则负责运行与管理；减少了类之间的耦合，提高了可维护性。

LSP替换法则
--
对父类的操作可以用子类来代替，集中体现在Creature与Huluwa,Grandpa等的关系上。

DIP依赖倒置原则
--
高层模块仅依赖于抽象：如Huluwa依赖于抽象类Creature与Comparable接口。
