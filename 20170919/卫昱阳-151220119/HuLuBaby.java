/**
 * Created by Yuyang Wei on 2017/9/27.
 */
import java.util.*;
import java.util.Scanner;
public class HuLuBaby {
    public static void main(String[] args){
        System.out.println("《葫芦兄弟：神峰奇遇》");
        System.out.println("新人物【爷爷】出现");
        Human Grandfather=new Human();//新人物“爷爷”出现
        System.out.println("【爷爷】解救了【穿山甲】并且了解到妖精跑出了葫芦");
        System.out.println("【爷爷】在【穿山甲】的指引下拿到了宝葫芦籽");

        System.out.println("《葫芦兄弟：七色葫芦》");
        System.out.println("【爷爷】种下了宝葫芦籽（随机输入0-6，按q退出）");
        Grandfather.Grow();
        System.out.println("【爷爷】用冒泡排序给【葫芦娃】排序");
        Grandfather.BubbleSort();
        System.out.print("【爷爷】秀了一下排好序的【葫芦娃】：");
        Grandfather.ShowAllBabies();
        System.out.println("【爷爷】觉得一个冒泡排序不过瘾，又打乱了【葫芦娃】的顺序（随机输入0-6，按q退出）");
        Grandfather.Grow();
        System.out.println("【爷爷】用快速排序给【葫芦娃】排序");
        Grandfather.QuickSort(0,6);
        System.out.print("【爷爷】又秀了一下排好序的【葫芦娃】：");
        Grandfather.ShowAllBabies();

    }
}
class HULUBrother{
    int num=-1;
    String color=new String();
    String range=new String();
    public void swap(final HULUBrother baby2)
    {
        int temp_num=baby2.num;
        String temp_color=baby2.color;
        String temp_range=baby2.range;

        baby2.num=this.num;
        baby2.color=this.color;
        baby2.range=this.range;

        this.num=temp_num;
        this.color=temp_color;
        this.range=temp_range;

    }

    public void honk(int start,int end)
    {
        System.out.println(this.range+": "+start+"->"+end);
    }
}

class Human{
    Vector<HULUBrother>Plant;
    Scanner input=new Scanner(System.in);
    public void Grow()
    {
        Plant=new Vector<HULUBrother>();
        while(input.hasNextInt())
        {
            HULUBrother Temp=new HULUBrother();
            Temp.num=input.nextInt();

            switch (Temp.num)
            {
                case 0:Temp.color="红色";Temp.range="老大";break;
                case 1:Temp.color="橙色";Temp.range="老二";break;
                case 2:Temp.color="黄色";Temp.range="老三";break;
                case 3:Temp.color="绿色";Temp.range="老四";break;
                case 4:Temp.color="青色";Temp.range="老五";break;
                case 5:Temp.color="蓝色";Temp.range="老六";break;
                case 6:Temp.color="紫色";Temp.range="老七";break;
            }
            Plant.add(Temp);
        }
        String mmp=input.next();
    }

    public void BubbleSort()
    {
        for(int i=0;i<Plant.size()-1;i++)
        {
            for(int j=0;j<Plant.size()-1;j++)
            {
                if(Plant.get(j).num>Plant.get(j+1).num)
                {
                    int j_plus=j+1;
                    Plant.get(j).honk(j,j_plus);
                    Plant.get(j_plus).honk(j_plus,j);
                    Plant.get(j).swap(Plant.get(j_plus));
                }
            }
        }
    }

    public void QuickSort(int low,int high)
    {
        int l=low;
        int h=high;
        int povit=Plant.get(low).num;
        while(l<h)
        {
            while(l<h&&Plant.get(h).num>=povit)
            {
                h--;
            }
            if(l<h)
            {
                Plant.get(h).honk(h,l);
                Plant.get(l).honk(l,h);
                Plant.get(h).swap(Plant.get(l));
                l++;
            }

            while(l<h&&Plant.get(l).num<=povit)
            {
                l++;
            }
            if(l<h)
            {
                Plant.get(h).honk(h,l);
                Plant.get(l).honk(l,h);
                Plant.get(h).swap(Plant.get(l));
                h--;
            }
        }

        if(l>low)QuickSort(low,l-1);
        if(h<high)QuickSort(l+1,high);
    }

    public void ShowAllBabies()
    {
        for(int i=0;i<Plant.size();i++)
        {
            System.out.print(Plant.get(i).range+" ");
        }
        System.out.println("");
    }
}