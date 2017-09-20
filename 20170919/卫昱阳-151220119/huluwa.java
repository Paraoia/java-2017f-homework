/**
 * Created by Yuyang Wei on 2017/9/20.
 */
import java.util.Scanner;
import java.util.Vector;
//import java.io.*;
public class huluwa
{
    public static void main(String[] args)
    {
        Outputer Wei=new Outputer();
        System.out.print("Please input the 7 babies randomly (from 0-6, end with 'q'): ");
        Wei.getDigit();
        Wei.BubbleSort();
        Wei.output();
        System.out.print("Please input the 7 babies randomly again (from 0-6, end with 'q'): ");
        Wei.getDigit();
        Wei.DividedSort();
        Wei.output();
    }
}
class Hulubaby
{
    int color;
    void show_color(int color)
    {
        switch (color)
        {
            case 0:System.out.print(" 红色 ");break;
            case 1:System.out.print(" 橙色 ");break;
            case 2:System.out.print(" 黄色 ");break;
            case 3:System.out.print(" 绿色 ");break;
            case 4:System.out.print(" 青色 ");break;
            case 5:System.out.print(" 蓝色 ");break;
            case 6:System.out.print(" 紫色 ");break;

        }
    }
    void show_range(int color)
    {
        switch (color)
        {
            case 0:System.out.print("老大:");break;
            case 1:System.out.print("老二:");break;
            case 2:System.out.print("老三:");break;
            case 3:System.out.print("老四:");break;
            case 4:System.out.print("老五:");break;
            case 5:System.out.print("老六:");break;
            case 6:System.out.print("老七:");break;
        }
    }
}
class Inputer extends Hulubaby
{
    Vector<Hulubaby>brothers;
    Scanner input=new Scanner(System.in);
    //BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
    void getDigit()
    {

        brothers=new Vector<Hulubaby>();
        //System.out.print("Please input the numbers: ");
        while(input.hasNextInt())
        {
            Hulubaby temp=new Hulubaby();
            temp.color = input.nextInt();
            brothers.add(temp);
        }
        String mmp=input.next();
    }
}
class Two_arranger extends Inputer
{
    void BubbleSort()
    {
        /*for (int i = 0;i<brothers.size() ; i++)
        {

            int temp=brothers.get(i).color;
            System.out.print(" "+temp+" ");
            show_color(temp);
        }*/
        for(int i=0;i<brothers.size()-1;i++)
        {
            for(int j=0;j<brothers.size()-1-i;j++)
            {
                if(brothers.get(j).color>brothers.get(j+1).color)
                {
                    int j_plus=j+1;
                    show_range(brothers.get(j).color);
                    System.out.println(j+"->"+j_plus);
                    show_range(brothers.get(j_plus).color);
                    System.out.println(j_plus+"->"+j);
                    int temp=brothers.get(j).color;
                    brothers.get(j).color=brothers.get(j+1).color;
                    brothers.get(j+1).color=temp;

                }

            }
        }
    }
    void DividedSort(){
        int high,low,temp;
        int mid;
        int i,j;
        for(i=1;i<brothers.size();i++)
        {
            low=0;
            high=i-1;
            temp=brothers.get(i).color;
            while(low<=high)
            {
                mid= (low+high)/2;
                if(temp<brothers.get(mid).color)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            for(j=i-1;j>=low;j--)
            {
                int j_plus=j+1;
                show_range(brothers.get(j).color);
                System.out.println(j+"->"+j_plus);
                brothers.get(j_plus).color=brothers.get(j).color;
            }
            if(i!=low) {
                //System.out.println(temp);
                show_range(temp);
                System.out.println(i + "->" + low);
                brothers.get(low).color = temp;
            }
        }
    }
}
class Outputer extends Two_arranger
{
    void output()
    {
            for (int i = 0;i<brothers.size() ; i++)
            {

                int temp=brothers.get(i).color;
                System.out.print(" "+temp+" ");
                show_color(temp);
            }
            System.out.println("");
    }
}