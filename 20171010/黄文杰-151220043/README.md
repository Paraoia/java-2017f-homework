# 第三次作业说明
本次作业用到了接口、抽象类等面向对象概念。以下是用到的接口和抽象类的描述：
	
- Space：接口，用于描述空间
	- Space2D：具体类，用于描述二维空间的具体实现
		

- Position：接口，用于描述位置
	- Position：具体类，用于描述二维空间中的位置

- Creature：抽象类，用于描述生物
	- Huluwa：具体类，用于描述葫芦娃的行为和特征
	- Grandpa：具体类，用于描述爷爷的行为和特征
	- XieZiJing：具体类，用于描述蝎子精的行为和特征
	- LouLuo：具体类，用于描述喽啰的行为和特征
	- SheJing：具体类，用于描述蛇精的行为和特征

- Sorter：接口，用于描述排序器
	- BubbleColSorter：具体类，用于描述冒泡列排序器的方法

- ZhenArranger：接口，用于描述阵列安排器
	- HeYiZhen：具体类，用于描述鹤翼阵的安排方法
	- YanHangZhen：具体类，用于描述雁行阵的安排方法
	- HengEZhen：具体类，用于描述衡轭阵的安排方法
	- ChangSheZhen：具体类，用于描述长蛇阵的安排方法 
	- YuLinZhen：具体类，用于描述鱼鳞阵的安排方法	
	- FangYuanZhen：具体类，用于描述方円阵的安排方法	 
	- YanYueZhen：具体类，用于描述偃月阵的安排方法	 
	- FengShiZhen：具体类，用于描述锋矢阵的安排方法	
 
- Comparable：接口，用于描述可比较的对象
	-Huluwa：具体类，用于描述葫芦娃的行为和特征
	
各个接口和类的从属关系图如下（实线表示继承，虚线表示包含于）：


![](https://github.com/HuangWenJ/java-2017f-homework/20171010/黄文杰-151220043/pic/1.png)

![](https://github.com/HuangWenJ/java-2017f-homework/20171010/黄文杰-151220043/pic/1.png)

![](https://github.com/HuangWenJ/java-2017f-homework/20171010/黄文杰-151220043/pic/1.png)


好处：用Space来对空间进行抽象就可以不局限于二维空间，如果要实现三维空间，只要新建一个类继承Space，再具体实现，其余与Space相关联的类和方法都不需要改变。同理，Position也可以变为三维的。用Sorter和ZhenArranger来分别对排序和阵型排列进行抽象则可以更方便地扩充排序方法和阵型排列方法，不需要修改源代码，只要增加新的类型就好了。
