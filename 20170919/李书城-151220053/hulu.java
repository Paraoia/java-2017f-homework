 enum COLOR{
    红色,橙色,黄色,绿色,青色,蓝色,紫色
}

public class hulu {
    //在葫芦兄弟中的序号
    int index ;
    COLOR cl;

    public int pos;
    public int last_pos;

    public hulu(int a)
    {
        index = a;
        switch (index)
        {
            case 1:
                cl = COLOR.红色;
                break;
            case 2:
                cl = COLOR.橙色;
                break;
            case 3:
                cl = COLOR.黄色;
                break;
            case 4:
                cl = COLOR.绿色;
                break;
            case 5:
                cl = COLOR.青色;
                break;
            case 6:
                cl = COLOR.蓝色;
                break;
            case 7:
                cl = COLOR.紫色;
                break;
        }
        last_pos = 0;
        pos  =0;
    }
    public void dis_col()
    {
        System.out.print(cl.toString() + " ");
    }
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
    public void dis_pos()
    {
        dis_name();
        System.out.print(":" + last_pos +"->" + pos);
        System.out.println();
    }
}
