public class HuLuWa{
    private Color c;
    private Rank r;
    private int index;
    public HuLuWa (Color c1,Rank r2,int i3){
        c=c1;
        r=r2;
        index=i3;
    }
    public void showcolor(){
        System.out.print(this.c+" ");
    }
    public void showrank(){
        System.out.print(this.r+" ");
    }

    public boolean cmp1(HuLuWa tmp){
        if (this.index > tmp.index)
            return true;
        else
            return false;
    }
    public boolean cmp2(HuLuWa tmp){
        if (this.c.compareTo(tmp.c)>0 )
            return true;
        else
            return false;
    }

}
enum Color{
    RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE
}
enum Rank{
    老大,老二,老三,老四,老五,老六,老七
}
