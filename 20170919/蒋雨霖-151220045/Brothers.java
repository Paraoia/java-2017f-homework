import java.util.*;

public class Brothers {
    CalaBash []Brothers; //存储初始化的葫芦娃信息
    CalaBash []BroAfRan; //随意站队后葫芦娃排序的数组

    /* 初始化Brothers数组 得到葫芦娃老大到老七的信息*/
    Brothers()
    {
        Brothers = new CalaBash[7];
        BroAfRan = new CalaBash[7];
        Brothers[0]= new CalaBash("红色","老大",1);
        Brothers[1]= new CalaBash("橙色","老二",2);
        Brothers[2]= new CalaBash("黄色","老三",3);
        Brothers[3]= new CalaBash("绿色","老四",4);
        Brothers[4]= new CalaBash("青色","老五",5);
        Brothers[5]= new CalaBash("蓝色","老六",6);
        Brothers[6]= new CalaBash("紫色","老七",7);

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
            System.out.print(BroAfRan[i].Rank+" ");
        }
        System.out.println(BroAfRan[6].Rank);

    }

    /* 打印输出队列从头至尾 葫芦娃的颜色*/
    public void PrintColor()
    {
        for(int i=0;i<6;i++)
        {
            System.out.print(BroAfRan[i].Color+" ");
        }
        System.out.println(BroAfRan[6].Color);

    }

    /* 交换位置时 输出信息 (快排不用 仅用于冒泡排序)*/
    public void PosExchange(int i, int j)
    {
        CalaBash temp;
        System.out.print(BroAfRan[i].Rank+":"+i+"->"+j+"  ");
        System.out.println(BroAfRan[j].Rank+":"+j+"->"+i+"  ");
        temp = BroAfRan[i];
        BroAfRan[i]=BroAfRan[j];
        BroAfRan[j]=temp;
    }
}
