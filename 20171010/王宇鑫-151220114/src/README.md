# 第三次作业
## 面向对象概念:
#### interface (implements)
作为没有多继承的java的措施，可以规定一系列的行为，使遵守该行为的class拥有同样的动作。

与c++中没有任何实现的纯虚类类似，与swift中protocol的行为相似。

1. sort包下的行为:

	**Sortable**: 规定可排序的队列共有的方法

	**Sorter**: 规定排序器所共有的方法

2. unit包下的行为:

	**CommunicateProtocol**: 规定可以向控制台输出消息的方法

	**CompareProtocol**: 规定可比较的方法(由Comparable<Unit>实现)

	**FormationProtocol**: 规定可以摆阵的方法

	**MoveProtocol**: 规定可移动的方法

#### abstract (extends)
抽象类，定义了一系列class共有行为共有属性的类，个别类需要被重载，根据具体类型变化。

1. unit包下抽象类:

	**Unit**: 所有单位的抽象类，因为任何单位都会拥有name(不可null)和position(可null)，并遵守CommunicateProtocol, CompareProtocol, MoveProtocol。

	**Manager**: 作为单位的管理者，拥有queue属性，本身也是单位，继承自Unit，又遵守FormationProtocol，可以访问queue的方法，向queue中添加单位等。

## 包:
#### field
包含关于队列的具体类:

1. Queue: 作为整个队伍的控制器

2. Position: 作为每个队伍的一个特定位置

3. Coordinate: 作为每个特定位置的抽象坐标

#### formation
包含关于摆阵的具体类：

1. FormationImage: 作为阵型的解析器，可从图片中获取可用位置

#### sort
包含关于排序的具体类:

1. QuickSort: 快排

2. BubbleSort: 冒泡排序

#### unit
包含关于单位的具体类:

1. Huluwa: 葫芦娃
2. GrandFather: 爷爷
3. Shejing: 蛇精
4. Xiezijing: 蝎子精
5. Xiaolouluo: 小喽啰
6. NullUnit: 空单位

#### material
包含阵法的所有图片

## 设计理念:
1. 单位共有的行动抽象为interface，单位共有的属性放入抽象类中
2. 排序的方法与排序的可作用对象抽象，而不是读取具体的位置或者比较具体的类型
3. 阵型的形状抽象出来，设计阵型时不需要过多考虑实际坐标
(ps:)N太大会挤在一块，就算N不大，形状也会不标准(毕竟手抖画的)，懒得优化。
4. 队伍与位置与逻辑坐标分割开
