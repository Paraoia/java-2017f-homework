# 面向对象的葫芦娃程序设计
###### 151220136 许卓尔

### 面向对象机制

* 继承
    利用extends关键字，完成派生类对于基类的继承，实现了代码重用和多态；

    ```java
    public class PositionX{
        ...
        public int index(){ ... }
        ...
    };
    public class PositionXY extends PositionXY{
        ...
        public int index(){ ... }
        ...
    }
    ```
    继承一维坐标实现二维坐标，并通过方法的重写，动态绑定，实现了多态性；

* 接口
    利用implements关键字，制定类的接口，从而规范对象的行为，并且完成了接口与实现的分离，提高了编译的效率；
> 对于较大的工程，接口实现的改变只需要重新编译该接口，由于interface为抽象类，不需要重新编译其他部分



### 面向对象设计理念
#### SOLID设计原则
* The Single-Responsibility Principle
    即，根据类别通过interface分离对方法进行分类；
    每个类只需负责单一的职责，清晰了概念，增强代码的可读性；

* The Open-Closed Principle
    开放扩展，关闭修正；
    即，设计模块时，应当使这个模块可以在不被修改的前提下扩展；
    抽象化设计，使我们不必注重功能的实现，对问题领域进行分析、得到本质上的抽象的共性；
    

* The Liskov Substitution Principle
    子类可以完全替代父类；
    实现了多态性，通过继承、接口、抽象类，完成代码复用，减小开发难度；

* The Interface-SegregationPrinciple
    接口隔离原则定义了对象通信的限制，也使得类的实现高内聚、低耦合；
    通过接口的隔离，缩小了通信的粒度，使得程序功能扩展过程中，修改某一类的压力不会传递到其他对象；
> 不隔离接口可能导致类的内部实现修改影响与其他类的通信关系；


* The Dependency-Inversion Principle
    要依赖与抽象，不要依赖于实现；
    将高层需要的功能通过接口让底层完成，而不是高层自己调用，增加了灵活性；
```java
    // 葫芦娃长蛇阵
    new Formation().embattle("长蛇",calabashDolls,myCirrus);
    // 妖精锋矢阵
    new Formation().embattle("锋矢",demons,myCirrus);
```
    通过DIP可以达到OCP的目标；