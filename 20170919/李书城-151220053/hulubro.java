import java.util.Random;

public class hulubro {
    hulu[] bros = new hulu[7];

    //让所有葫芦兄弟随机站队
    public void random_queue()
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

                ++num;
            }
        }
    }

    //交换两个葫芦娃的位置， 并让他们报告交换动作
    public void exchange(int i, int j)
    {
        bros[i].dis_name();
        System.out.print(i + "->" + j + "\n");

        bros[j].dis_name();
        System.out.print(i + "->" + j + "\n");

        hulu temp = bros[i];
        bros[i] = bros[j];
        bros[j] = temp;
    }

    //对葫芦兄弟进行冒泡排序
    public void bubble_sort_and_name_report()
    {
        for(int i = 1 ; i < 7;++i)
            for(int j = 0; j< 7-i;++j)
                if(bros[j].cmp(bros[j+1]))
                    exchange(j,j+1);

        for(int i = 0 ; i < 7;++i)
            bros[i].dis_name();
        System.out.println();
    }


    void qsort(hulu a[], int low, int high)
    {
        if(low >= high)
            return;
        int first = low;
        int last = high;

        hulu pivot = a[first];
        while(first < last)
        {
            while(first < last && a[last].cmp(pivot))
                --last;
            if(first<last)
            {
                exchange(first,last);
                ++first;
            }

            while(first < last && pivot.cmp(a[first]))
                ++first;
            if(first<last)
            {
                exchange(first,last);
                --last;
            }
        }

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
        b1.random_queue();
        b1.bubble_sort_and_name_report();

        b1.random_queue();
        b1.qsort_and_color_report();
    }
}

