public class CalaBash {
    private String Color; //颜色
    private String Rank; //辈分
    private  int Num; //辈分编号 用于排序
    /*构造函数*/
    CalaBash(String color, String rank, int num)
    {
        Color = color;
        Rank = rank;
        Num = num;
    }

    public int getNum() {
        return Num;
    }

    public String getColor() {
        return Color;
    }

    public String getRank() {
        return Rank;
    }
}
