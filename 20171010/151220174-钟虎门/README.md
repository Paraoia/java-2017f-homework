# Huluwa作业三——二维世界阵法演示
### 151220174

---

## 面向对象
这次作业主要有以下几个类：
`Creature` `Former` `World` `Position`

+ 整体思路是每个Position有一个Creature对象引用，World中存储N*N个Position和1个Former，运行过程中主要依靠Former内部的函数将各个阵营重新摆阵，每重新摆放一次就输出一次当前世界的示意图
+ 
+ Creature类主要描述各种生物及其行为，派生出HuluBoy、Grandpa、Monster、Scorpion、Snake、Bandit等类。
+ 
+ Former类主要描述阵型的生成。
+ 
+ Position类主要描述一个可以容纳Creature的位置。
+ 
+ World类主要对整个世界做一些初始化工作，其内包含所有位置的信息。






