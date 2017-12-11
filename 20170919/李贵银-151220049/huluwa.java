public class huluwa {
    private int number;
    private int position1,position2;//number是排行，position1是现在的位置，position2是之前的位置
    private String color;
    huluwa(int n1,String c,int p1)
    {
        number=n1;
        color=c;
        position1=p1;
        position2=p1;
    }
    public int G_n()
    {
        return number;
    }//返回排行
    public void baoshu()
    {
        if(number==1)
            System.out.print("老大");
        else if(number==2)
            System.out.print("老二");
        else if(number==3)
            System.out.print("老三");
        else if(number==4)
            System.out.print("老四");
        else if(number==5)
            System.out.print("老五");
        else if(number==6)
            System.out.print("老六");
        else if(number==7)
            System.out.print("老七");
    }
    public void baoshu1()
    {
        baoshu();
        System.out.print(" ");
    }
    public void baoshu2()
    {
         System.out.print(color+" ");
    }
    public void baoshu3()
    {
        baoshu();
        System.out.println(":"+position2+"->"+position1);
    }
    public void xin(int pos)//刷新位置
    {
        position2=position1;
        position1=pos;
    }
    public int G_p()
    {
        return position1;
    }
}
