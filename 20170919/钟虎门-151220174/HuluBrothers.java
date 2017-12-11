//一个容器包含所容纳的葫芦娃以及该容器对应的位置下标
class Container
{
    Huluwa m_huluboy;
    int m_index;

    //Container构造函数
    Container(Huluwa huluboy,int index)
    {
        m_huluboy=huluboy;
        m_index=index;
    }
}

public class HuluBrothers
{
    //7个容器，每个容器容纳1个葫芦娃
    Container m_containers[];
    //临时容器，用于交换葫芦娃时暂时存放其中一个
    Container temp_container;

    //葫芦藤初始化
    HuluBrothers()
    {
        String names[]={"老大","老二","老三","老四","老五","老六","老七"};
        String colors[]={"赤","橙","黄","绿","青","蓝","紫"};
        m_containers=new Container[7];
        Huluwa temp;
        for (int i=0;i<m_containers.length;i++)
        {
            temp = new Huluwa(names[i], colors[i], i);
            m_containers[i] = new Container(temp, i);
        }
    }
    //随机交换藤上的葫芦
    public void random_sort()
    {
        System.out.println("随机排列：");
        java.util.Random random=new java.util.Random();
        int index1=0,index2=0;
        int count=0;
        while (count<3)
        {
            index1=random.nextInt(7);
            index2=random.nextInt(7);
            if (index1!=index2)
            {
                exchange(index1,index2,false);
                count++;
            }
        }
    }
    //交换藤上对应位置的两个葫芦娃
    private void exchange(int pos1,int pos2,boolean report)
    {
        if (pos1==pos2)
            return;
        if (report)
        {
            //两个葫芦娃均先报告即将交换位置
            m_containers[pos1].m_huluboy.report_position_change(pos1, pos2);
            m_containers[pos2].m_huluboy.report_position_change(pos2, pos1);
        }
        Huluwa temp=m_containers[pos1].m_huluboy;
        m_containers[pos1].m_huluboy=m_containers[pos2].m_huluboy;
        m_containers[pos2].m_huluboy=temp;
    }
    //葫芦娃从左至右报告名字
    public void report_name()
    {
        System.out.print("报数： ");
        for (int i=0;i<m_containers.length;i++)
            m_containers[i].m_huluboy.report_name();
        System.out.println();
    }
    //葫芦娃从左至右报告颜色
    public void report_color()
    {
        System.out.print("报数： ");
        for (int i=0;i<m_containers.length;i++)
            m_containers[i].m_huluboy.report_color();
        System.out.println();
    }
    //冒泡排序对外接口
    public void bubble_sort()
    {
        System.out.println("冒泡排列：");
        for (int i=0;i<m_containers.length;i++)
            for(int j=0;j<m_containers.length-i-1;j++)
                if (m_containers[j].m_huluboy.m_age>m_containers[j+1].m_huluboy.m_age)
                    exchange(j,j+1,true);

    }
    //快速排序partition函数
    private int partition(int low,int high)
    {
        Huluwa temp=m_containers[high].m_huluboy;
        int i=low-1;
        for (int j=low;j<high;j++)
            if (m_containers[j].m_huluboy.m_age<=temp.m_age)
            {
                i++;
                exchange(i,j,true);
            }
        exchange(i+1,high,true);
        return i+1;
    }
    //快速排序的具体实现函数
    private void qsort(int low,int high)
    {
        if (low<high)
        {
            int index=partition(low,high);
            qsort(low,index-1);
            qsort(index+1,high);
        }
    }
    //快速排序提供的对外接口
    public void quick_sort()
    {
        System.out.println("快速排列：");
        qsort(0,m_containers.length-1);
    }
    public static void main(String []args)
    {
        HuluBrothers vine=new HuluBrothers();
        vine.random_sort();
        vine.report_name();
        vine.bubble_sort();
        vine.report_name();
        vine.random_sort();
        vine.report_name();
        vine.quick_sort();
        vine.report_color();
    }
}


