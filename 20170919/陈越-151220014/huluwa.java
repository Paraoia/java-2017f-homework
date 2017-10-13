package huluwa;

import java.util.Random;

public class huluwa implements Comparable{

    private int no;                //编号
    private String color;           //颜色
    private String name;           //排行


    public huluwa(int no1){
        no = no1;
        switch (no)
        {
            case 1:color = "红色";name = "老大";break;
            case 2:color = "橙色";name = "老二";break;
            case 3:color = "黄色";name = "老三";break;
            case 4:color = "绿色";name = "老四";break;
            case 5:color = "青色";name = "老五";break;
            case 6:color = "蓝色";name = "老六";break;
            case 7:color = "紫色";name = "老七";break;
        }
    }
    public huluwa(){}

    //葫芦娃报告位置移动
    public void myPrintln(int src,int dst)
    {
        System.out.print(name + ':');
        System.out.println((src+1)+"->"+(dst+1));
    }

    //葫芦娃输出排名
    public void printNum()
    {
        System.out.println(name );

    }

    public void sitdown(Position position,int src,int dst)
    {
        position.setHolder(this);
        myPrintln(src,dst);
    }
    //葫芦娃输出自己的颜色
    public void printColor()
    {
        System.out.println(color );
    }

    //葫芦娃比较排行
    public int cmp(Comparable a)
    {
        if(a instanceof huluwa) {
            if (no > ((huluwa) a).no)
                return 1;
            else if (no == ((huluwa) a).no)
                return 0;
            else
                return -1;
        }
        else
            return -1;
    }

}
