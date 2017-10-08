package calabash;


public class Vine {
    private calabashBrother[] babies;


    //长出七个娃并初始化
    //==================================================================
    Vine()
    {
        babies = new calabashBrother[7];
        randsort();
    }
    //==================================================================
    //end


    //随机排序七个娃
    //==================================================================
    public void randsort()
    {

        //随机数组声明
        int[] array = new int[7];
        //获得随机数组
        foundation.randarray(array,7);
        //葫芦娃设置
        for(int i=0;i<7;i++)
        {
            babies[i] = new calabashBrother(array[i],i,foundation.Color.values()[array[i]]);
        }
    }
    //==================================================================
    //end




    //交换两个葫芦娃的位置，并让葫芦娃进行报告
    //==================================================================
    public void exchange(calabashBrother w1, calabashBrother w2)
    {
        //获得两个葫芦娃位置信息
        int w1p = w1.getPosition();
        int w2p = w2.getPosition();

        //交换两个葫芦娃位置
        calabashBrother.equal(w1,w2);


        //汇报位置变化情况
        w1.TellChange(w2p,w1p);
        w2.TellChange(w1p,w2p);
    }
    //==================================================================
    //end




    //冒泡排序
    //==================================================================
    public void BubbleSort()
    {
        for(int i = 0;i < babies.length;i++)
        {
            for(int j = 0;j < babies.length - 1 - i;j++)
            {
                if(babies[j].getOrder() > babies[j + 1].getOrder())
                {
                    exchange(babies[j], babies[j+1]);
                }
            }
        }
    }
    //==================================================================
    //end





    //快速排序
    //==================================================================================================================
    int externLargeRegion(int low,int high)
    {
        int p = low;
        int current = high;
        while(current > low)
        {
            if(babies[current].getOrder() < babies[p].getOrder())
            {
                exchange(babies[current], babies[p]);
                p = current;
                break;
            }
            current--;
        }
        return p;
    }

    int externSmallRegion(int low,int high)
    {
        int p = high;
        int current = low;
        while(current < high)
        {
            if(babies[current].getOrder() > babies[p].getOrder())
            {
                exchange(babies[current], babies[p]);
                p = current;
                break;
            }
            current++;
        }
        return p;
    }

    int partition(int first,int last)
    {
        int low;
        int high;
        low = first;
        high = last;
        while(low<high)
        {
            int highvac = externLargeRegion(low,high);
            int lowVac = externSmallRegion(low+1, highvac);
            low = lowVac;
            high = highvac - 1;
        }
        return low;
    }

    public void binarysort(int first, int last)
    {
        if(first<last)
        {
            int splitpoint = partition(first,last);
            binarysort(first,splitpoint - 1);
            binarysort(splitpoint+1,last);
        }
        return;
    }
    //快速排序结束
    //==================================================================================================================
    //end





    //依次报名字
    //==================================================================
    public void tellNames()
    {
        for(int i=0;i<babies.length;i++)
        {
            System.out.print(babies[i].getName() + " ");
        }
        System.out.println();
    }
    //==================================================================
    //end







    //依次报颜色
    //==================================================================
    public void tellColor()
    {
        for(int i=0;i<babies.length;i++)
        {
            System.out.print(babies[i].getColor() + " ");
        }
        System.out.println();
    }
    //==================================================================
    //end



}
