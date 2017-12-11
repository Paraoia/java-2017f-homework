


> Written with [StackEdit](https://stackedit.io/).
> <doc>
> > **主要思路**：
> 1.对于题目中所有的形象，创建一个creature.java的大类，葫芦娃，蛇精，蝎子精等都是它的子类；

    public class creature
    public class xiezi extends creature
    public class new_huluwa extends creature
    .......

> 2.用一个formation.java类，代表这些人站的那片地，用二维数组表示；
> `public position[][] position;
> 
> 3.用一个position.java类，代表formation上每个位置,position中用creature表示；                                            `
> public class position {
    public creature holder;
    public new_huluwa newholder;
}
`
> 4.在formation中定义函数changeformation函数，里面有各种阵型，在函数中把creature放好；
> 
> 5.在formation中调用2.0中的排序，把葫芦娃排序，放到数组上去
> 
> 6.打印二维数组

>概念，机制，设计理念，好处
>用到了继承，好处是面向对象，把各个模块封装起来了，看起来舒服，便于调用。
