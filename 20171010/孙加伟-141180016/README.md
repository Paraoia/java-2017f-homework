#葫芦娃第三次作业
===================
1.Creature类是所有角色的父类，它定义了所有角色共有的属性，name(姓名)、property(属性)、activity(战斗中所处状态)以及对应的set和get方法，其中activity是枚举类型State,包含三种可能状态{旁观者(WATCHER),领导者(LEADER),战斗人员(BATTLER)};<br><br>
2.HuLuWa类是继承自Creature的父类，它在原来父类的基础上加上HuLuWa特有的属性rank(排行)和color(颜色)。同时为标志葫芦娃，将color转化为字符串表示葫芦娃的名字,color是枚举类型COLOR,包含7种可能情况{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE;}<br><br>
3.Goblins(小喽啰)类是继承自Creature的父类，它在原来父类的基础上加上Goblins特有的属性number(编号)。同时为标志小喽啰，将number转化为字符串表示小喽啰的名字,number是枚举类型NUMBER,包含6种可能情况{ONE,TWO,THREE,FOUR,FIVE,SIX;}<br><br>
4.Position类有唯一属性holder，即为放置生物体的容器，默认初始化为null;<br><br>
5.SecondDimension类是新建二维数组存放生物体的类<br><br>
* 其中新建了蝎子精、老爷爷、蛇精等Creature类对象，也新建了葫芦娃和小喽啰数组，且统一用Creature类型定义(父类引用指向子类对象)，编译时类型都是Creature;<br>
* 其中占座函数seizeHuLuWaSeat(Creature[] creature)、seizeGoblinSeat(Creature[] creature, Formation formation)中都是先判断实例是否是对应类型数组的函数(instanceof)，再执行占位操作，体现了运行时的多态性<br>
* seizeOthersSeat(Creature creature)函数根据对象的名字，用所有对象都有的getname方法，在相应的位置上放置相应的生物体<br>
* printPositions()函数调用每个位置处对象的getName方法，打印出相应位置处对象名字；当然也可以调用getProperty函数或getActivity，打印出对应位置处对象的属性或者活动。

