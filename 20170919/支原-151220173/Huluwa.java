enum Color{
    Red("红色","老大"),Orange("橙色","老二"),Yellow("黄色","老三"),Green("绿色","老四"),Cyan("青色","老五"),Blue("蓝色","老六"),Violent("紫色","老七");
    private String color;
    private String name;
    private Color(String C,String N)
    {
        this.color=C;
        this.name=N;
    }
    public String GetName()
    {
        return this.name;
    }
    public String GetColor()
    {
        return this.color;
    }
}

public class Huluwa {
    Color col;
    int range;
    Huluwa(int i)
    {
        switch(i)
        {
            case 1:range=1;col=Color.Red;break;
            case 2:range=2;col=Color.Orange;break;
            case 3:range=3;col=Color.Yellow;break;
            case 4:range=4;col=Color.Green;break;
            case 5:range=5;col=Color.Cyan;break;
            case 6:range=6;col=Color.Blue;break;
            case 7:range=7;col=Color.Violent;break;
        }
    }
    public void TellName()
    {
        System.out.print(col.GetName()+" ");
    }
    public void TellColor()
    {
        System.out.print(col.GetColor()+" ");
    }
    public void jump(String N,int i,int j)
    {
        System.out.print(N+":  "+i+"->");
        System.out.print(j);
        System.out.println();
    }


}
