import java.util.*;
public class Brothers {
    private CalaBash []Brothers; //存储初始化的葫芦娃信息
    private CalaBash []BroAfRan; //随意站队后葫芦娃排序的数组

    /* 初始化Brothers数组 得到葫芦娃老大到老七的信息*/
    Brothers()
    {
        Brothers = new CalaBash[7];
        BroAfRan = new CalaBash[7];

    }

    public void RandomQueue()
    {

        Set<Integer> set = new HashSet<Integer>();
        Random creator = new Random();
        int old= set.size();
        int j=0;
        while(set.size()<7)
        {
            int n=creator.nextInt(7);
            set.add(n);
            if(set.size()!=old)
            {
             BroAfRan[j]=Brothers[n];
             j++;
             old=set.size();
            }
        }

    }


    /* 打印输出队列从头至尾 葫芦娃的辈分*/
    public void PrintRank()
    {
        for(int i=0;i<6;i++)
        {
            System.out.print(BroAfRan[i].getRank()+" ");
        }
        System.out.println(BroAfRan[6].getRank());

    }

    /* 打印输出队列从头至尾 葫芦娃的颜色*/
    public void PrintColor()
    {
        for(int i=0;i<6;i++)
        {
            System.out.print(BroAfRan[i].getColor()+" ");
        }
        System.out.println(BroAfRan[6].getColor());

    }

    /* 交换位置时 输出信息 (快排不用 仅用于冒泡排序)*/
    public void PosExchange(int i, int j)
    {
        CalaBash temp;
        System.out.print(BroAfRan[i].getRank()+":"+i+"->"+j+"  ");
        System.out.println(BroAfRan[j].getRank()+":"+j+"->"+i+"  ");
        temp = BroAfRan[i];
        BroAfRan[i]=BroAfRan[j];
        BroAfRan[j]=temp;
    }

    public CalaBash[] getBroAfRan() {
        return BroAfRan;
    }

    public CalaBash[] getBrothers() {
        return Brothers;
    }
}

enum COLOR
{
    红色,橙色, 黄色, 绿色, 青色, 蓝色, 紫色
}
enum Rank
{
    老大,老二, 老三, 老四, 老五, 老六, 老七
}