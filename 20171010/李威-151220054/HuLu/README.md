
 # 代码说明
 
 ## 涉及的面向对象的概念、机制、设计理念
 
 ### interface
 
 ZhenInterface:各种布阵如ZhenChangshe,ZhenHeyi,ZhenYanhang可以实现该接口  
 
 Creature:各种生物，如Huluwa，Grandpa,xiezijing可以实现该接口  
 
 Sorter:排序方法如BubbleSorter可以实现该接口  
 
 Comparable：比较对象可以实现该接口  
 
 接口的好处：“面向接口编程”是实现几大原则的关键，“高内聚，低耦合”  
 

 
 ### 多态
 
 ```
 
 Creature[] monster=new Creature[7];
 monster[0]=new Xiezijing();
 for(int i=1;i<7;i++){
        monster[i]=new Xiaolouluo();
}
        
 
 ```
 Creature是接口，Creature[] monster=new Creature[7];这个语句定义了一个实现接口的类的对象数组，
 下面monster[0]=new Xiezijing();实际上指向的对象时xiezijing对象，此处即多态，满足了继承+重写+
 父类引用指向子类对象的三大条件。  
 好处：可以提高代码的普适性，减少了因为子类对象的差异给代码带来的影响。
 
  ### 访问控制
 
 大部分的数据成员的访问控制为privat，基于数据封装的同时，对外提供了set和get函数