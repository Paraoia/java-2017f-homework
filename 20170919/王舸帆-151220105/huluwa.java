/**
 * Created by macbook on 2017/9/20.
 */
public class huluwa {
    int rank;//在七兄弟中的排行
    String paihang;//"老大"
    String color;//"红"


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPaihang() {
        return paihang;
    }

    public void setPaihang(String paihang) {
        this.paihang = paihang;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public huluwa(int rank,String paihang,String color){
        this.rank=rank;
        this.paihang=paihang;
        this.color=color;
    }

    void baogao1(){

        System.out.println(paihang);
    }//报告"老大"

    void baogao2(){

        System.out.println(color);
    }//报告"红色"

}
