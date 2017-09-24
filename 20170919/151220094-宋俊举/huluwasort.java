package homework2;
import java.util.Random;
public class huluwasort {
    public huluwa[] h;
    //初始化七个葫芦娃顺序
    public void initial()
    {
        h=new huluwa[7];
        int[] flag = new int[7];
        int[] randomArray = new int[7];
        for(int i=0;i<7;i++)
        {
            flag[i] = -1;
        }
        Random r = new Random();
        for(int i=0;i<7;i++) {
            int s = Math.abs(r.nextInt()%7);
            while(flag[s]!=-1)
            {
                s = Math.abs(r.nextInt()%7);
            }
            flag[s] = 0;
            randomArray[i] = s;
        }
        huluwa red = new huluwa(1,"老大","红色", randomArray[0]+1 );
        h[1] = red;
        huluwa org = new huluwa (2,"老二","橙色",randomArray[1]+1);
        h[3] = org;
        huluwa yellow = new huluwa(3,"老三","黄色", randomArray[2]+1);
        h[0] = yellow;
        huluwa green = new huluwa(4,"老四","绿色", randomArray[3]+1);
        h[6] = green;
        huluwa qing = new huluwa(5,"老五","青色", randomArray[4]+1);
        h[2] = qing;
        huluwa blue = new huluwa (6, "老六","蓝色", randomArray[5]+1);
        h[4] = blue;
        huluwa purple = new huluwa (7, "老七","紫色", randomArray[6]+1);
        h[5] = purple;
    }
    //构造函数
    public huluwasort()
    {
        initial();
    }
    //冒泡排序
    void maopaosort()
    {
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<6-i;j++)
            {
                if(h[j].old>h[j+1].old)
                {
                    huluwa temp;
                    temp = h[j];
                    h[j] = h[j+1];
                    h[j + 1].changepos(j);
                    h[j+1]=temp;
                    temp.changepos(j+1);
                }
            }
        }
    }
    //快速排序
    //快速排序中向高位比较
    int externLargeRegion(int low,int high)
    {
        int p = low;
        int current = high;
        while(current > low)
        {
            if(h[current].old< h[p].old)
            {
                huluwa temp = h[current];
                h[current] = h[p];
                h[p].changepos(current);
                h[p]=temp;
                temp.changepos(p);
                p = current;
                break;
            }
            current--;
        }
        return p;
    }
    //快速排序中向低位比较
    int externSmallRegion(int low,int high)
    {
        int p = high;
        int current = low;
        while(current< high)
        {
            if(h[current].old > h[p].old)
            {
                huluwa temp = h[current];
                h[current] = h[p];
                h[p].changepos(current);
                h[p]=temp;
                temp.changepos(p);
                p = current;
                break;
            }
            current++;
        }
        return p;
    }



    //一次快速排序
    int partition(int first,int last)
    {
        int low;
        int high;
        low = first;
        high = last;
        while(low<high)
        {
            int highvac = externLargeRegion(low,high);
            int lowVac = externSmallRegion(low+1,highvac);
            low = lowVac;
            high = highvac - 1;
        }
        return low;
    }


    //二分快速排序
    void binarysort(int first, int last)
    {
        if(first<last)
        {
            int splitpoint = partition(first,last);
            binarysort(first,splitpoint - 1);
            binarysort(splitpoint+1,last);
        }
        return;
    }
    //依次打印数组中七个娃的名字
    void printname()
    {
        for(int i=0;i<7;i++)
        {
            System.out.print(h[i].name + " ");
        }
        System.out.println();
    }

    //依次打印数组中七个娃的颜色
    void printColor()
    {
        for(int i=0;i<7;i++)
        {
            System.out.print(h[i].color + " ");
        }
        System.out.println();
    }
    //主函数
    public static void main(String[] args)
    {
        huluwasort hs = new huluwasort();
        hs.maopaosort();
        hs.printname();
        hs.initial();
        hs.binarysort(0,6);
        hs.printColor();
    }


}
