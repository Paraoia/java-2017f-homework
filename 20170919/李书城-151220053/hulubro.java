import java.util.Random;

public class hulubro {
    hulu[] bros = new hulu[7];

    //让所有葫芦兄弟随机站队
    public void init()
    {
        int hulu = 1;
        int num  = 0;
        int[] dif = new int[7];
        for(int i = 0; i < 7;++i)
        {
            dif[i] = -1;
        }
        while(num < 7)
        {
            java.util.Random r=new java.util.Random();
            int index = Math.abs((r.nextInt())%7);
           // System.out.println(index);
            if(dif[index] == -1)
            {
                dif[index] = 0;
                bros[index] = new hulu(hulu++);
                bros[index].pos = index;
                bros[index].last_pos = index;

                ++num;
            }
        }
    }

    //打按顺序打印葫芦兄弟的名字
    public void disp()
    {
        for(int i = 0; i < 7;++i)
        {
            bros[i].dis_name();
        }
        System.out.println();
    }

    //对葫芦兄弟进行冒泡排序并报名字
    public void bubble_sort_and_name_report()
    {
        for(int i = 1 ; i < 7;++i)
        {
            for(int j = 0; j< 7-i;++j)
            {
                if(bros[j].index > bros[j+1].index)
                {
                    bros[j].last_pos = bros[j].pos;
                    bros[j+1].last_pos = bros[j+1].pos;
                    int temp_index = bros[j].pos;
                    bros[j].pos = bros[j+1].pos;
                    bros[j+1].pos = temp_index;

                    hulu temp = bros[j];
                    bros[j] = bros[j+1];
                    bros[j+1] = temp;
                    bros[j].dis_pos();
                    bros[j+1].dis_pos();
                }
            }
        }
        disp();
    }


    void qsort(hulu a[], int low, int high)
    {
        if(low >= high)
            return;
        int first = low;
        int last = high;

        hulu pilot = a[first];
        while(first < last)
        {
            while(first < last && a[last].cl.ordinal() >= pilot.cl.ordinal())
                --last;
            a[first] = a[last];
            a[last].last_pos = a[last].pos;
            a[last].pos = first;
            a[last].dis_pos();

            while(first < last && a[first].cl.ordinal() <= pilot.cl.ordinal())
                ++first;
            a[last] = a[first];
            a[first].last_pos = a[first].pos;
            a[first].pos = last;
            a[first].dis_pos();
        }
        a[first]  = pilot;
        pilot.last_pos = pilot.pos;
        pilot.pos = first;
        pilot.dis_pos();

        qsort(a,low,first-1);
        qsort(a,first+1,high);
    }


    //对葫芦兄弟进行快速排序并报出颜色
    public void qsort_and_color_report()
    {
        qsort(bros,0,6);
        for(int i = 0; i < 7;++i)
        {
            bros[i].dis_col();
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        hulubro b1 = new hulubro();
        b1.init();
        b1.bubble_sort_and_name_report();

        b1.init();
        b1.qsort_and_color_report();
    }
}

