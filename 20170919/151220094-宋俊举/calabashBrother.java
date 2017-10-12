package calabash;


public class calabashBrother {

    //葫芦娃的位置信息及获取接口
    //==================================================================
    private int order;
    public int getOrder()
    {
        return order;
    }
    //==================================================================
    //end


    //葫芦娃的位置信息及获取和设置
    //==================================================================
    private int position;
    public void setPosition(int p)
    {
        this.position = p;
    }
    public int getPosition()
    {
        return position;
    }
    //==================================================================
    //end


    //葫芦娃的名字信息及获取
    //==================================================================
    private String name;
    public String getName()
    {
        return name;
    }
    //==================================================================
    //end

    //葫芦娃的颜色信息及获取
    //==================================================================
    private foundation.Color color;
    public foundation.Color getColor()
    {
        return color;
    }
    //==================================================================
    //end

    //构造函数
    //==================================================================
    public calabashBrother(int order, int position, foundation.Color color)
    {
        this.order = order;
        this.position = position;
        this.color = color;
        switch(order)
        {
            case 0:this.name = "老大";break;
            case 1:this.name = "老二";break;
            case 2:this.name = "老三";break;
            case 3:this.name = "老四";break;
            case 4:this.name = "老五";break;
            case 5:this.name = "老六";break;
            case 6:this.name = "老七";break;
            default:break;
        }
    }
    //==================================================================
    //end



    //交换两个葫芦娃位的信息，交换位置时使用
    //==================================================================
    public static void equal(calabashBrother b1,calabashBrother b2)
    {
        String name;
        foundation.Color color;
        int order;
        //int position;

        name = b1.name;
        color = b1.color;
        order = b1.order;
        //position = b1.position;

        b1.name = b2.name;
        b1.color = b2.color;
        b1.order = b2.order;
        //b1.position = b2.position;

        b2.name = name;
        b2.color = color;
        b2.order = order;
        //b2.position = position;

    }
    //==================================================================
    //end



    //汇报位置变化情况
    public void TellChange(int from, int to)
    {
        System.out.println(name + ":" + from + "->" + to);
    }

}
