package com.need.demo;

enum NAME{大娃, 二娃, 三娃, 四娃, 五娃, 六娃, 七娃};
enum COLOR{红, 橙, 黄, 绿, 青, 蓝, 紫};

//单个葫芦娃类
public class Huluwa {
    private NAME name;
    private COLOR color;

    public Huluwa(){ name = NAME.大娃; color = COLOR.红; }
    public Huluwa(NAME n, COLOR c){ name = n; color=c;}

    public NAME getName() { return name; }
    public COLOR getColor() { return color; }
    public void SayName(){ System.out.print( name + "\t"); }
    public void SayColor(){ System.out.print( color + "\t"); }
}