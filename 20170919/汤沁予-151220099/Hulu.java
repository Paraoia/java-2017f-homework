enum Color {
    RED(0), ORANGE(1), YELLOW(2), GREEN(3),
    CYAN(4), BLUE(5),PURPLE(6);
    public String Rank;//每个葫芦娃的排行
    public String Str;//颜色的汉字字符串
    public int value;//排行的int型表示，用于比较大小
    private Color(int n) {
        switch(n)
        {
            case 0:
                this.Rank = "老大";this.Str = "红色";this.value = 0;break;
            case 1:
                this.Rank = "老二";this.Str = "橙色";this.value = 1;break;
            case 2:
                this.Rank = "老三";this.Str = "黄色";this.value = 2;break;
            case 3:
                this.Rank = "老四";this.Str = "绿色";this.value = 3;break;
            case 4:
                this.Rank = "老五";this.Str = "青色";this.value = 4;break;
            case 5:
                this.Rank = "老六";this.Str = "蓝色";this.value = 5;break;
            case 6:
                this.Rank = "老七";this.Str = "紫色";this.value = 6;break;
            default:
                System.out.print("error");
                this.Rank ="";
                this.Str = "";
        }
    }
}

class Hulu
{
    Color color;//基本信息
    public void MoveTo(int from,int to)
    {
        System.out.print(color.Rank+":"+from+"->"+to+"\n");
    }
    public void HonkRank()
    {
        System.out.print(color.Rank + "\n");
    }
    public void HonkColor()
    {
        System.out.print(color.Str + "\n");
    }
    public boolean Compare(Hulu h)
    {
        if(this.color.value >= h.color.value)
            return true;
        else
            return false;
    }
    Hulu(int n)
    {
        color = Color.values()[n];
    }
}