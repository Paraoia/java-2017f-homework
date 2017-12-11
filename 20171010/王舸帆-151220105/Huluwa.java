/**
 * Created by macbook on 2017/9/20.
 */
public class Huluwa implements Renwu,Comparable{

    Hulu hulu;//每个葫芦娃都有一个自己的葫芦
    PAIHANG paihang;//"老大"
    COLOR color;//"红"
    public enum COLOR {
        红, 橙, 黄, 绿, 青, 蓝, 紫
    }
    enum PAIHANG {
        老一, 老二, 老三, 老四, 老五, 老六, 老七
    }


    public PAIHANG getPaihang() {
        return paihang;
    }

    public void setPaihang(PAIHANG paihang) {
        this.paihang = paihang;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public void setHulu(Hulu hulu){
        this.hulu=hulu;
        hulu.setHolder(this);
    }

    public Hulu getHulu(){
        return hulu;
    }
    Huluwa(PAIHANG paihang, COLOR color){
        this.paihang=paihang;
        this.color=color;
    }

    public void baogao(){

        System.out.print(paihang+" "+color);
    }//报告"老大+红"


    public boolean biggerThan(Comparable brother){

        if (brother instanceof  Huluwa)
            return this.getPaihang().ordinal()> ((Huluwa) brother).getPaihang().ordinal();
        else
            return false;
    }
}
