public class Sort {
    /* 冒泡排序 */
    public void BubbleSort(Brothers bro) {
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                if (bro.BroAfRan[i].Num > bro.BroAfRan[j].Num)
                    bro.PosExchange(i, j);
            }
        }
    }

    /*快速排序*/
    public void QuickSort(Brothers bro, int low, int high)
    {
        if(low < high)
        {
            int i=low,j=high;
            CalaBash x=bro.BroAfRan[low];
            while (i < j)
            {
                while(i < j && bro.BroAfRan[j].Num >= x.Num) // 从右向左找第一个小于x的数
                    j--;
                if(i<j)
                {
                    bro.BroAfRan[i++]=bro.BroAfRan[j];
                    if(j!=i-1)
                    System.out.println(bro.BroAfRan[j].Rank+"："+j+"->"+(i-1));
                }
                while(i < j && bro.BroAfRan[i].Num < x.Num) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                {
                    bro.BroAfRan[j--]=bro.BroAfRan[i];
                    if(i!=j+1)
                    System.out.println(bro.BroAfRan[i].Rank+"："+i+"->"+(j+1));
                }

                //bro.PosExchange(i,j);
            }
            bro.BroAfRan[i]=x;
            if(low!=i)
            System.out.println(x.Rank+"："+low+"->"+i);
            QuickSort(bro,low,i-1);
            QuickSort(bro,i+1,high);
        }
    }
}
