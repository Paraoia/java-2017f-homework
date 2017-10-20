# 葫芦娃第三次作业面向对象方法说明

1. 主要抽象出四个类(**列出了重要成员**)
   Creature (**Abstract Class**)
	因为Creature 有很多共有属性(type, position, etc.)，所以不采用Interface
	Creature 派生出葫芦娃，爷爷，蛇精等生物
   Place
	Position[] Positions
   Position
 	x,y 坐标
       Creature[] Holders
   Zhenfa: 
	阵法由position数组和creature数组构成，初始化时并没有初始化position(可以想象此时是一个散乱的队列)
       调用**form** 方法 使得阵法成型并具有具体形状。
2.降低类之间的耦合性
  Space 只有一组position, 没有必要再有一组creature成员，因为Position 已经有Holder成员可以保存相关信息。

3.**LSP LISKOV替换法则**
  Zhenfa 中存放Creature的数组，因为不知道是具体哪个子类的对象，但是都可以替换成基类；增加了代码的真实性。

4.**SRP法则**
  Zhenfa 类的单一职责是根据creature形成一定形状的阵法。
  Space 类的职责是加入，删除阵法。
  Position 的职责是建立与holder及space间的抽象联系。



