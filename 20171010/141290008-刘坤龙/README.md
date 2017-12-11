# 作业:面向葫芦娃编程

## 类的设计

1. Creature类

   Creature设计为基类, 而不是使用接口的原因是: 对于葫芦娃, 爷爷, 蛇精等 来说, 都拥有共同的属性和实现相同的方法, 也就是

   ```java
   String name;
   Position position;
   ```

    以及对应的一些方法

   从另一个角度来说,

   Creature -> 葫芦娃  和  人 -> 女人相同

2. Huluwa, Grandpa, Snake, Minions类

   这些都是继承Creature的子类.

   值得注意的是, 引入了接口Active

   ```java
   public interface Active {
       public void act();
   }
   ```

   尽管理论上此时爷爷和蛇精都只会喊"666", 但拥有玉如意的蛇精 和 主要配角之一的爷爷, 不可能只喊"666"

   为了拓展和与其他类的统一, 引入接口Active

   例如爷爷类:

   ```java
   public class Grandpa extends Creature implements Active {
       Grandpa(){
           super("爷");
       }
       @Override
       public void act(){
           System.out.println("葫芦娃,666!");
       }
   }
   ```

   另外, 由于蝎子精在剧中只是一个高级步兵, 故暂时将其归入了杂兵类

3. 阵法接口Formation

   考虑将阵法实现成一个接口而不是类的原因是, 阵法中个体的联系性,或者说整体性目前来看并不强. 

    抽象成一个聚合多个对象的类, 会让程序变得复杂(?)

    但如果阵法涉及到"增幅"或者其他效果时, 作为类实现应该会更好.

