1.其中creature作为基类，由于考虑到creature里面的几个函数是共同属性，由Huluwa,Yeye,Xiezijing,Shejing,Loulu继承，而这几个函数均可以在creature具体实现，派生类直接继承也并不需要修改，所以也就没有使用抽象类和interface  

2.comparable和Formation和sorter设置为interface，可以用来封装具体的功能集合，而具体实现将实现该接口的类提供，比如Heyi,Changse,Fangyuan均具体实现如何站队列，而Formation只需要给出一个函数即可，便于扩展到其他队形，满足开放封闭原则。  

3.整个二维空间由Space类实现，其中的函数比如有将creature放在坐标(x,y)上的函数void putCreature(Creature c,int x,int y),还有将某个坐标上的生物移开的函数void removeCreature(int x,int y)等等，实现将creature具体的移动等等都一一对应这个二维空间。其中需要注意的就是对于生物的移动，不仅要更新生物本身，还有更新二维空间那个位置点到点的变化。而Space只负责实际坐标，不涉及到排序的具体实现，也不需要实现具体的站队列（由sorter，queue，formation等等实现），所以满足SRP单一职责原则。  

4.对于huluwa的处理是，将7个乱序的葫芦娃在Sort排好序后封装在Queue类里，看成是一个整体的对象，最后在Space中需要将其排成Changse队伍，直接使用Queue类定义的queue整体对葫芦娃处理。  

5.整个对峙局面和整体处理是在Start类里。