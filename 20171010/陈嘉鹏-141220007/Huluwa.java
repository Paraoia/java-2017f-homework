

enum COLOR{
    红, 橙, 黄, 绿, 青, 蓝, 紫
};
enum SENIORITY{
    大, 二, 三, 四, 五, 六, 七
};



public class Huluwa extends Creature {
    COLOR color;
    SENIORITY seniority;

    Huluwa(SENIORITY seniority, COLOR color, Image img){
        super(img);
        this.seniority = seniority;
        this.color = color;
        setPriority(seniority.ordinal());
    }


}



