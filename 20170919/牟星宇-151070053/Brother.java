
public class Brother {
    int rank;//排名
    String name;//名称
    int color_rank;//颜色值
    String color;//颜色

    Brother(int rank, String name, int color_rank, String color){
        this.rank = rank;
        this.name = name;
        this.color_rank = color_rank;
        this.color = color;
    }
    void tell_name(){
        System.out.print( name );
    } //报名称
    void tell_color(){
        System.out.print( color );
    } //报颜色
}
