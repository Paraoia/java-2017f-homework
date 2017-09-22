package hulvwa;

import java.util.Random;

public class hulvwa {

    public int no;

    public void myPrintln(int src,int dst)
    {
        switch (no)
        {
            case 1:System.out.print("老大：" );break;
            case 2:System.out.print("老二：" );break;
            case 3:System.out.print("老三：" );break;
            case 4:System.out.print("老四：" );break;
            case 5:System.out.print("老五：" );break;
            case 6:System.out.print("老六：" );break;
            case 7:System.out.print("老七：" );break;
        }
        System.out.println(src+"->"+dst);
    }
    public hulvwa(int no1){no = no1;}
    public hulvwa(){}
    public void printNum()
    {
         switch (no)
         {
             case 1:System.out.println("老大" );break;
             case 2:System.out.println("老二" );break;
             case 3:System.out.println("老三" );break;
             case 4:System.out.println("老四" );break;
             case 5:System.out.println("老五" );break;
             case 6:System.out.println("老六" );break;
             case 7:System.out.println("老七" );break;
         }

    }
    public void printColor()
    {
        switch (no)
        {
            case 1:System.out.println("红色" );break;
            case 2:System.out.println("橙色" );break;
            case 3:System.out.println("黄色" );break;
            case 4:System.out.println("绿色" );break;
            case 5:System.out.println("青色");break;
            case 6:System.out.println("蓝色" );break;
            case 7:System.out.println("紫色" );break;
        }

    }

}
