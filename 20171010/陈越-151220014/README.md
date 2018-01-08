# 葫芦娃第三次作业简述
1.面向对象的概念：父类、子类、接口<br>
2.面向对象的机制：继承extends、接口implements、聚集<br>
3.设计理念：<br>
* interface Comparable :提供cmp接口，用于比较大小<br>
  implement:Huluwa
* interface Sort :提供sort接口，用于排序<br>
  implement:QuickSort、BubbleSort
* interface Creature :提供sit和print接口，用于生物在制定位置坐下以及打印自己<br>
  implement:HuLuWa、GrandFather（爷爷）、Scorpion（蝎子精）、Snake（蛇精）、XiaoLouLuo（小喽啰）、Nothing
* 父类 Formation：提供蝎子精带领小喽啰的阵型<br>
  extends:FangFormation、HeYiFormation（两个不同的阵型）<br>
  聚集：Position positions[];
* 类 Position:用于装载生物<br>
   聚集 :Creature holder;
* 类 Queue:用于对葫芦娃排序并形成长蛇阵型<br>
   聚集：Position positions[];
* 类 Space:创建Queue类对象，用于装载葫芦娃的长蛇阵型；创建Formation类对象，用于装载蝎子精带领的阵型；安置爷爷和蛇精<br>
   聚集：Position positions[];<br>
 <doc>
 4.好处:<br>
 (1) 便于代码复用<br>
 (2) 提高代码的可读性，使逻辑更加清晰<br>
 (3) 便于日后丰富代码内容<br>
 (4) 类封装使得成员变量的使用更加安全
