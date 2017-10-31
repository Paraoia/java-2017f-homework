 enum COLOR{
    红色,橙色,黄色,绿色,青色,蓝色,紫色
}

public class hulu {
    //本葫芦娃的序号
    private int index ;

    //颜色
    private COLOR cl;

    //构造函数
    public hulu(int rank)
    {
        this.index = rank;

        //根据序号得到本葫芦娃的颜色
        this.cl = COLOR.values()[index - 1];
    }


    public int ret_index()
    {
        return index;
    }

    boolean cmp(hulu a)
    {
        return index >= a.index;
    }

    //报自己的颜色
    public void dis_col()
    {
        System.out.print(cl.toString() + " ");
    }

    //报自己的名字
    public void dis_name()
    {
        switch (index)
        {
            case 1:
                System.out.print("老大 ");
                break;
            case 2:
                System.out.print("老二 ");
                break;
            case 3:
                System.out.print("老三 ");
                break;
            case 4:
                System.out.print("老四 ");
                break;
            case 5:
                System.out.print("老五 ");
                break;
            case 6:
                System.out.print("老六 ");
                break;
            case 7:
                System.out.print("老七 ");
                break;
        }
    }
}
