# HW3
## 151220112 王尧
---

## 1.概念机制
---
## abstract class
#### 定义了Creature抽象类，在Huluwa,Shejing等类中继承Creature类。

## interface
#### 定义了Sorter接口，在BubbleSort和QuickSort中实现重载。
#### 定义了Formation接口，在具体阵型中实现重载。

## Composition
## 在Position类中定义了Coordinate类的变量，每个Position都有坐标属性。
### 在Queue类中定义了Position类的一个变量。
### 在Space类中定义了Position类的变量，表示空间由这些位置组成。

## 2.设计原则
---
## SRP (Single-Responsibility Principle)
### Space类只负责定义每一个左边上的位置，不负责在判断阵型排列是否合法，而是在具体实现Formation接口的类中完成。

## OCP (Open-Closed Principle)
### 通过定义接口规定其实现类必须实现的方法，而实现该接口的类可进行扩展。

## LSP (Liskov Substitution Principle）
### Creature类对象可在其在运行时识别其子类对象。提高代码的重用性和扩展性。