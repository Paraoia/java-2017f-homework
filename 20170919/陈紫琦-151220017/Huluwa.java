enum Color
{
    RED("老大","红色",1), ORANGE("老二", "橙色",2), YELLOW("老三", "黄色",3), GREEN("老四","绿色",4),
    CYAN("老五","青色",5), BLUE("老六", "蓝色", 6), PURPLE("老七", "紫色", 7);
    private String NoName; //老X
    private String ColorName; //颜色
    private int index; //序号
    private Color(String NoName, String ColorName, int index) //构造函数
    {
        this.NoName = NoName;
        this.ColorName = ColorName;
        this.index = index;
    }
    public  String getNoName()
    {
        return NoName;
    }
    public String getColorName()
    {
        return  ColorName;
    }
    public int getColorIndex() {return index;}
}
public class Huluwa
{
    Color color;
    int index;
    Huluwa(int index)
    {
        this.index = index;
        switch (index)
        {
            case 1: color = Color.RED; break;
            case 2: color = Color.ORANGE; break;
            case 3: color = Color.YELLOW; break;
            case 4: color = Color.GREEN; break;
            case 5: color = Color.CYAN; break;
            case 6: color = Color.BLUE; break;
            case 7: color = Color.PURPLE; break;
        }
    }
    public void reportNumber() //报数
    {
        System.out.print(color.getNoName() + " ");
    }
    public void reportColor() //报名字
    {
        System.out.print(color.getColorName() + " ");
    }
    public void JumpandReport(HuluwaBrothers queue, int a, int b) //移动位置并报告
    {
        queue.positions[b].holder = this;
        a++; b++;
        System.out.println("\t" + color.getNoName() + ":" + a + "->"+ b);
    }
}