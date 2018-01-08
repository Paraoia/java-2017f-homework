public class CalaBash {
    private COLOR Color; //颜色
    private Rank Rank; //辈分
    private  int Num; //辈分编号 用于排序
    /*构造函数*/
    CalaBash(COLOR color, Rank rank, int num)
    {
        this.Color = color;
        this.Rank = rank;
        Num = num;
    }

    public int getNum() {
        return Num;
    }

    public COLOR getColor() {
        return Color;
    }

    public Rank getRank() {
        return Rank;
    }
}
