## 代码说明

####  main函数说明
从前有一块大陆（map），大陆上住着葫芦娃兄弟和他们的爷爷，还有一些会魔法妖怪。有一天葫芦娃兄弟和妖怪们有了冲突，于是由大娃带领的葫芦娃兄弟与由蝎子精带领的妖怪们在大陆上摆开阵型准备交战。闻讯而来的爷爷和蛇精来到战场为各自的队伍加油，一场旷世大战千钧一发......
####  面向对象机制

*  继承</br>
使用extends关键字来实现派生类对基类的继承，以实现代码的复用。同时通过方法的重写，动态绑定，实现了多态性。例如二维坐标继承一维坐标：</br>

>public class Position {</br>
>
>private int x;</br>
>. . . . .</br>
>}
>
>public class Position extends >Position{</br>
>
>private int y;</br>
>. . . . .</br>
>}

* 接口</br>
利用implements关键字，制定类的接口，从而规范对象的行为，并且完成了接口与实现的分离，提高了编译的效率:</br>

>public interface Arrange {</br>
>
>public void setFormation(Map map, int left, int down);</br>
>}</br>
通过定义Arrange这个接口，使得坐标集合（例如阵型）可以放置在大陆（map）上。

#### 设计理念
* SRP 单一职责原则</br>
对于每个类，简化它的功能。譬如阵型独立成类，与空间分开。

* LOD 迪米特法则</br>
弱化类与类之间的耦合性，尽量通过接口来建立类与类之间的联系。

