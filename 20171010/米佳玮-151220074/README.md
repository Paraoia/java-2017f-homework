# 代码说明

## 用到的面向对象的概念、机制、设计理念

### interface

Creature、Sorter、Comparable定义为interface，是对抽象的行为协议定义，规定了统一的接口，是接口与实现的分离。Creature定义了生物的统一行为，Sorter定义了排序器的统一行为，Comparable定义了比较操作的统一行为，并且这种统一的接口便于在排序中对不同生物使用统一的行为。并且Java的类不能多继承，interface可以使一个类“继承”多种行为，这是它相对于抽象类的一个好处。

### 访问控制

对数据成员大多使用private的访问控制，对外提供setIdname()和getIdname()接口函数，实现了数据的封装，更安全。

### 多态

```

Creature[] brothers = new Creature[7];

for (int i = 0; i < brothers.length; i++) {

            brothers[i] = new Huluwa(COLOR.values()[i], RANK.values()[i]);

        }

```

brothers是Creature的引用，但实际指向Huluwa类对象，并且Huluwa类对象中有对Creature中行为的重写。在继承、重写、父类引用指向子类对象这三个条件下，出现了多态。屏蔽不同子类对象之间的差异，写出通用的代码，做出通用的编程，以适应需求的不断变化。

### 组合(Composition)

Flat(二维平面)和Position是组合关系，而不是继承关系。组合通常是希望新类内部具有已存在类的功能时使用，而不是希望已存在的类作为他的接口。组合更符合该场景。
