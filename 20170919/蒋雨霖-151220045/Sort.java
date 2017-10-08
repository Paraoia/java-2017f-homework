public class Sort {
    /* 冒泡排序 */
    public void BubbleSort(Brothers bro) {
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                if (bro.getBroAfRan()[i].getNum() > bro.getBroAfRan()[j].getNum())
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
            CalaBash x=bro.getBroAfRan()[low];
            while (i < j)
            {
                while(i < j && bro.getBroAfRan()[j].getNum() >= x.getNum()) // 从右向左找第一个小于x的数
                    j--;
                if(i<j)
                {
                    bro.getBroAfRan()[i++]=bro.getBroAfRan()[j];
                    if(j!=i-1)
                    System.out.println(bro.getBroAfRan()[j].getRank()+"："+j+"->"+(i-1));
                }
                while(i < j && bro.getBroAfRan()[i].getNum() < x.getNum()) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                {
                    bro.getBroAfRan()[j--]=bro.getBroAfRan()[i];
                    if(i!=j+1)
                    System.out.println(bro.getBroAfRan()[i].getRank()+"："+i+"->"+(j+1));
                }

                //bro.PosExchange(i,j);
            }
            bro.getBroAfRan()[i]=x;
            if(low!=i)
            System.out.println(x.getRank()+"："+low+"->"+i);
            QuickSort(bro,low,i-1);
            QuickSort(bro,i+1,high);
        }
    }
}
