# README

（项目编码格式为UTF-8）

## 程序package说明 & UML图

程序分为3个package：creature，game和actions。

- creature定义了抽象类Creature和接口Comparable；定义了葫芦娃（GourdDolls）、爷爷（Grandpa）、蝎子精（Scorpion）、蛇精（Snake）和小马仔（Accomplice）。其中，葫芦娃、爷爷、蝎子精和蛇精采用单例实现；葫芦娃implements了接口Comparable
- game定义了地图类Map和程序主控类Game
- actions定义了接口Action、长蛇阵（ChangShe）、鹤翼阵（HeYi）和雁行阵（YanXing）以及移动（Move）。**任何creature在map上的移动都通过actions中的类来进行**



### package creature的接口和类定义如下

![JavaReverse__creature__Overview_3.jpg](https://github.com/CbcWestwolf/java-2017f-homework/blob/master/20171010/%E9%99%88%E5%8D%9A%E9%92%8F-151220007/jpg/JavaReverse__creature__Overview_3.jpg)



### package game的类定义如下

![JavaReverse__game__Overview_2.jpg](https://github.com/CbcWestwolf/java-2017f-homework/blob/master/20171010/%E9%99%88%E5%8D%9A%E9%92%8F-151220007/jpg/JavaReverse__game__Overview_2.jpg)



### package actions的接口和类定义如下

![JavaReverse__actions__Overview_1.jpg](https://github.com/CbcWestwolf/java-2017f-homework/blob/master/20171010/%E9%99%88%E5%8D%9A%E9%92%8F-151220007/jpg/JavaReverse__actions__Overview_1.jpg)





## 面向对象的一些想法

### 用抽象类而不是接口来实现Creature

引用《Thinking in java》中interface一章的summary：

> An appropriate guideline is to prefer classes to interfaces. Start with classes, and if it
> becomes clear that interfaces are necessary, then refactor. Interfaces are a great tool, but they
> can easily be overused. 

由于Creature具有已经可具体实现的moveTo()，getX()，setX()等方法，所以直接实现为抽象类比实现为接口来的更简练。

### 将继承了Creature的GourdDoll封装为GourdDolls

- 将7个葫芦娃视为一个对象可以更好地在内部排序
- 封装有利于单例模式的实现（蝎子精、蛇精和葫芦娃、爷爷都被实现为单例模式）

### 人物在map上的所有移动只能通过actions来进行

一个人物移动时，需要严格按照如下步骤进行：

``` java
map.removeCreatureInXY(creature.getX(), creature.getY());//在地图上清除人物 
creature.moveTo(dest_x, dest_y);						   //给任务登记新值
map.putCreatureInXY(creature, dest_x, dest_y);			//在地图上重新放置任务
```

所以，把所有的移动直接封装为各种Action，可减少出错的可能