# 10.10作业代码中关于面向对象的说明

## 问题分析
本次作业需要实现一个二维空间，其中有两方人员进行对峙并变换阵型。同时每一方各有一个人员需要在恰当的位置进行加油助威。

- 两方人员都是生物。
- 二维空间是两方人员进行对峙的场所。我将它想象为一片田地，田地上有许多小格，每个格子上可以站立一个生物。
- 进行阵型变换和对峙的是由复数人员构成的团体。
- 阵型变换是以团体为单位赋予其中每一个生物适当的田地位置的方法
## 设计实现

1. 主要使用的面向对象工具是接口（interface），由此实现继承和多态方法。如：

```
		Huluwa[] brothers = new Huluwa[7];
		for(int i = 0; i < brothers.length;i++){
			brothers[i] = new Huluwa(COLOR.values()[i],RANK.values()[i]);
		}
		
		Laoyeye laoyeye = new Laoyeye();
		
		Creature[] monsters = new Creature[7];
		monsters[0] = new Xiezijing();
		for(int i = 1; i < monsters.length;i++){
			monsters[i] = new Louluo();
		}
		
		Shejing shejing = new Shejing();
```
所有的生物子类都继承Creature接口并使用它进行初始化构成多态，直接响应相同的虚操作完成不同的行为，减少了冗余。

2. 主要注意的点是访问控制。所有的数据成员均设置为private，仅提供set和get接口用于外界访问其数据。减少了过多数据操作手段带来的风险。

## 具体实现

- Creature接口

构造Creature接口，用于后续继承并实例化为各类生物，如葫芦娃老爷爷蝎子精等。

Creature接口含有最终田地需要的对生物操作的所有接口，即获取生物名称用于打印，设置生物位置，获取生物位置用于生物位置调整，如下：

```
    public String getName();
	
    public void setFieldPos(FieldPos fieldpos);
	
    public FieldPos getFieldPos();
```
- Field类

Field类是一个二维空间容器，其基本单位是FieldPos，FieldPos类用于描述田地上的小格子，上面有个生物，同时拥有描述二维位置的位置信息。

FieldPos作为一个承载生物的单位空间，应具有设置承载物的接口setHolder，访问承载物的接口getHolder,访问位置信息的接口getX，getY

Field类作为一个FieldPos的集合，应该具有使得外界得以访问其中单个FieldPos的接口getFieldPOs。

- Formation接口

构造Formation接口，用于后续继承并实例化为各种阵型，如鹤翼阵长蛇阵等。

Formation接口仅用于实现方法函数，它只有setFormation一个接口函数。

- Group类

Group类是由一系列生物构成的集合，它包括一个加油者supportor和一串用于排阵型的creatures（Creature类型的数组）。

Group类具有的接口是返回supportor和creatures的接口getSupportor和getCreatures

## 设计原则
设计和修改过程主要注意维持的是SRP原则和依赖倒置原则，每一个类仅实现少量自己必须完成的功能，同时抽象类全部由interface书写使其对子类没有依赖关系，只有子类依赖父类的接口。

## 具体实现

几乎所有的容器类都只实现返回相关信息的功能（Field类另外实现了printStatus的打印功能，我认为这是它必备的）

所有的生物派生类都只重写Creature的三个接口。

## 好处
我认为这样的设计在本次作业中粒度适中，每个文件都不至于代码量过大。同时较少的功能实现强调了每个类的核心价值。并且单一职责使得各个类之间通过依赖关系相动作，而不是内含某个特定的类定义或是方法，更便于程序的扩展。

反例如 如下是我修改前在原本Group类中包含的接口：

```
/*	public void transFormationChangShe(Field field){
		FieldPos basement = field.getFieldPos(3, this.camp*7+3);
		for(int i = 0;i < creatures.length;i++){
			creatures[i].getFieldPos().setHolder(null);
		}
		
		boolean reverse = this.camp==0?false:true;
		
		new FormationChangShe().setFormation(creatures,basement,field,reverse);
	}*/
```

若在Group类中实现此方法，那么在最终调用时需写成（假定有个Group类的实例HuluFamily）HuluFamily.transFormationChangShe，虽然也符合逻辑，但这样写十分繁琐，需要在Group中为设置的4个阵型设置4个方法。且如果对Formation的实例进行扩展，则需要同时在Group类中扩展新的方法，代价很高。

Group类采用返回必要信息并发送给Formation进行排列的方法后，即使Formation接口本身发生改动，或仅是增加子类，都不需要因此改动Group类，耦合程度大大降低。
