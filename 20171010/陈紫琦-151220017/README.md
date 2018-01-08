# 作业三说明
#### &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;151220017 陈紫琦
---
## 基本设计思路
##### &emsp;&emsp;首先按照老师给的第二次作业范例修改了我的程序，然后在此基础上，主要增加了如下改动：
 - Creature及其子类  
&emsp;&emsp;将Creature类由接口改为抽象类，因为多种生物皆具有共同的方法如setPosition()、getPosition()等，以及都含有相同的成员变量如species(物种分类),position(所处位置)等，需要抽象的方法目前只有报名字的方法report()。
&emsp;&emsp;增加了Creature的子类老爷爷类(Oldman)、蛇精类（Snake）、蝎子精类（Scorpion）、喽啰类（Minion）。
 - Queue及其子类  
&emsp;&emsp;因为发现葫芦娃队列和蝎子精带领的队列具有很多共同的特性，故将原来的Queue类改为一个抽象基类，令HuluwaQueue和ScorpionQueue类为其子类。其中，基类Queue中含有成员变量num（队列人数）、creatures[]（生物数组）、form（队列当前的阵型）、positions（阵型所占据的位置数组），以及方法FormationChange（变换阵型）等。
 - Formation及其子类  
 &emsp;&emsp;表示不同的阵型。其中基类Formation中含有成员变量positions[]数组（阵型占据的位置数组）以及阵型人数num。子类LongSnakeForm（长蛇形）、MoonForm（偃月形）、SwordForm（锋矢形）继承了基类的成员变量，并规定了不同阵型占有的不同位置。
 - Space类  
&emsp;&emsp; 二维坐标所表示的空间，主要成员变量是一个Position类型的二维数组，定义了N*N个位置。

## 用到的面向对象的概念、机制、设计理念及其优点
- 抽象  
&emsp;&emsp;将场景中不同的对象归类，最终抽象为生物体、生物体队列、阵型、排序器等几个基类或接口，再分别从基类派生出不同的子类，反映了对象所具备的重要性质，使程序模块和结构更清晰。
- 继承  
&emsp;&emsp;多次使用到继承机制，如将Queue由原本的类改为基类，派生出HuluwaQueue类和ScorpionQueue类，不仅对象所具备的特性（相同点与差异）显得更为清晰，更大大减少了代码重复量。
- 封装  
&emsp;&emsp;过程封装与数据封装，如把Position类中的坐标属性x,y值设为private类型，只能通过get、set方法获取和修改，更好地保护了数据。
- 多态  
&emsp;&emsp;多态指某一论域中的一个元素存在多种解释，比如葫芦娃队列和蝎子精带领的队列中每个个体类型都是父类Creature，但却可以指向子类的实体。再比如不同生物的派生类中报名字的report()方法，虽然用的时候都是creature[i].report()的形式，但所报的名字却不同。多态使得程序编写更为简单方便。


