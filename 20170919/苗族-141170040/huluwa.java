import java.util.*;

class BottleBaby {
    int rank;
    int color;
    void tell_rank()
    {
        System.out.print("Brother"+rank);
    }
    void tell_Color()
    {
        switch(color) {
            case 1:
                System.out.print("RED"+" ");
                break;
            case 2:
                System.out.print("ORGANGE"+" ");
                break;
            case 3:
                System.out.print("YELLOW"+" ");
                break;
            case 4:
                System.out.print("GREEN"+" ");
                break;
            case 5:
                System.out.print("CYAN"+" ");
                break;
            case 6:
                System.out.print("BLUE"+" ");
                break;
            case 7:
                System.out.print("purple"+" ");


        }
    }
}



public class huluwa{
    public static  void main(String[] args)
    {
        BottleBaby[] sevenman;
        sevenman = new BottleBaby[7];
        for(int i =0;i<7;i++)
        {
            sevenman[i] = new BottleBaby();
            sevenman[i].rank=i+1;
            sevenman[i].color=i+1;

        }
        for(int i=0;i<3;i++)
        {
            int t1=rand7();
            int t2=rand7();
            BottleBaby temp = new BottleBaby();
            if(t1>=0 && t1<7 && t2>=0 && t2<7 && t1!=t2)
            {
                temp = sevenman[t1];
                sevenman[t1]=sevenman[t2];
                sevenman[t2]=temp;
            }
        }
        System.out.println("第一次随意站队后，葫芦娃的站位顺序如下：");
        freeman(sevenman);
        for(int i =0;i<7;i++)
        {
            sevenman[i].tell_rank();
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("下面开始按排行进行冒泡排序：");
        bubbleSort(sevenman);
        System.out.println("排序完成");
        for(int i =0;i<7;i++)
        {
            System.out.print(    "报告：");
            sevenman[i].tell_rank();
            System.out.println();
        }
        System.out.println("第二次随意站队后，葫芦娃的站位顺序如下：");
        freeman(sevenman);
        for(int i =0;i<7;i++)
        {
            sevenman[i].tell_rank();
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("下面开始按颜色进行二分排序：");
        binarySort(sevenman);
        System.out.println("排序完成");
        for(int i =0;i<7;i++)
        {
            sevenman[i].tell_rank();
            System.out.print(    "报告：");
            sevenman[i].tell_Color();
            System.out.println();
        }
    }

    public static int rand7()
    {
        Random random = new Random();
        int s=random.nextInt(7);
        return s;
    }
    public static void freeman(BottleBaby[] args)
    {
        for(int i=0;i<3;i++)
        {
            int t1=rand7();
            int t2=rand7();
            BottleBaby temp = new BottleBaby();
            if(t1>=0 && t1<7 && t2>=0 && t2<7 && t1!=t2)
            {
                temp = args[t1];
                args[t1]=args[t2];
                args[t2]=temp;
            }
        }
    }

    public static void bubbleSort(BottleBaby[] args)
    {
        BottleBaby temp = new BottleBaby();
        for(int i =0;i<6;i++)
        {
            for(int j =0;j<6;j++)
            {
                if(args[j].rank>args[j+1].rank)
                {
                    temp =args[j];
                    args[j] = args[j+1];
                    args[j+1] = temp;
                    args[j+1].tell_rank();
                    System.out.println(" :"+j+"->"+(j+1));
                }
            }
        }
    }

    public static void binarySort(BottleBaby[] source)
    {
        int i, j;
        int high, low, mid;
        BottleBaby temp = new BottleBaby();
        for (i = 1; i < 7; i++)
        {
            source[i].tell_rank();
            System.out.println(" :"+i+"->temp");
            temp =source[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                mid = (low + high)/2;
                if (temp.color<source[mid].color ) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (j = i - 1; j >=low; j--) {
               source[j].tell_rank();
               System.out.println(" :"+j+"->"+(j+1));
                source[j + 1] = source[j];
            }
            source[i].tell_rank();
            System.out.println(" :temp"+"->"+low);
            source[low] = temp;

        }
    }
}

