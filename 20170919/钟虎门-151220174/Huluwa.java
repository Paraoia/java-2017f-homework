class Huluwa_individual
{
    private String m_name;
    private String m_color;//0-6 赤橙黄绿青蓝紫
    int m_age;//0-6
    Huluwa_individual(String name,int age)
    {
        m_name = name;
        m_age = age;
        switch (age)
        {
            case 0:
                m_color = "赤色";
                break;
            case 1:
                m_color = "橙色";
                break;
            case 2:
                m_color = "黄色";
                break;
            case 3:
                m_color = "绿色";
                break;
            case 4:
                m_color = "青色";
                break;
            case 5:
                m_color = "蓝色";
                break;
            case 6:
                m_color = "紫色";
                break;
            default:
                m_color = "ERROR";
                break;
        }
    }
    void show_name()
    {
        System.out.print(m_name+" ");
    }
    void show_color()
    {
        System.out.print(m_color+" ");
    }
    void show_position_change(int pre,int des)
    {
        System.out.println(m_name+":"+pre+"->"+des);
    }
}


public class Huluwa {
    Huluwa_individual []members;
    public void initialize()
    {
        members=new Huluwa_individual[7];
        String names[]={"老大","老二","老三","老四","老五","老六","老七"};
        for (int i=0;i<names.length;i++)
        {
            members[i] = new Huluwa_individual(names[i], i);
        }
    }
    void swap(int i,int j)
    {
        if (i!=j)
        {
            members[i].show_position_change(i, j);
            members[j].show_position_change(j, i);
            Huluwa_individual temp = members[i];
            members[i] = members[j];
            members[j] = temp;
        }
    }
    int partition(int low,int high)
    {
        Huluwa_individual temp=members[high];
        int i=low-1;
        for (int j=low;j<high;j++)
        {
            if (members[j].m_age<=temp.m_age)
            {
                i++;
                swap(i,j);
            }
        }
        swap(i+1,high);
        return i+1;
    }
    void qsort(int low,int high)
    {
        if (low<high)
        {
            int index=partition(low,high);
            qsort(low,index-1);
            qsort(index+1,high);
        }
    }
    void show_name()
    {
        for(int i=0;i<members.length;i++)
        {
            members[i].show_name();
        }
        System.out.println();
    }
    void show_color()
    {
        for(int i=0;i<members.length;i++)
        {
            members[i].show_color();
        }
        System.out.println();
    }
    void random_sort()
    {
        java.util.Random random=new java.util.Random();
        int index1=0,index2=0;
        int count=0;
        while(count<4)
        {
            index1=random.nextInt(7);
            index2=random.nextInt(7);
            if (index1!=index2)
            {
                //swap
                Huluwa_individual temp=members[index1];
                members[index1]=members[index2];
                members[index2]=temp;
                count++;
            }
        }
        System.out.println("随机排列：");
        show_name();
    }
    void bubble_sort()
    {
        for (int i=0;i<members.length;i++)
        {
            for(int j=0;j<members.length-1-i;j++)
            {
                if (members[j].m_age>members[j+1].m_age)
                {
                    swap(j,j+1);
                }
            }
        }
        System.out.println("冒泡排序：");
        show_name();
    }
    void quick_sort()
    {
        qsort(0,members.length-1);
        System.out.println("快速排序：");
        show_color();
    }
    public static void main(String []args)
    {
        Huluwa hulu=new Huluwa();
        hulu.initialize();
        hulu.random_sort();
        hulu.bubble_sort();
        hulu.random_sort();
        hulu.quick_sort();
    }
}
