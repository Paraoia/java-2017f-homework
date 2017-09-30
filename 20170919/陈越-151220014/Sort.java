package huluwa;

import java.util.Random;

public class Sort {
    public static void main(String []args)
    {
        Sort sort = new Sort(7);
        sort.shuffle();
        System.out.println("冒泡排序——————————————————————");
        sort.bubbleSort();
        sort.shuffle();
        System.out.println("快速排序——————————————————————");
        sort.quickSort();
    }

    private huluwa children[];
    private int num;
    Sort(int n)
    {
        num = n;
        children = new huluwa[num+1];//第8个位置为空位，用于交换位置

    }
    //让葫芦娃一次输出排名
    private void printNum()
    {
        for(int i=0;i<num;i++)
        {
            children[i].printNum();
        }
    }

    //让葫芦娃一次输出颜色
    private void printColor()
    {
        for(int i=0;i<num;i++)
        {
            children[i].printColor();
        }
    }

    //随机生成葫芦娃的初始排序
    public void shuffle()
    {
        Random ran = new Random();
        children[0] = new huluwa(ran.nextInt(num)+1);
        int i=1;
        for(;i<num;i++) {
            int j = 0;
            while (j != i) {
                children[i] = new huluwa(ran.nextInt(num) + 1);
                for (j = 0; j < i && children[j].cmp(children[i]) != 0; j++) ;
            }
        }
    }

    //交换葫芦娃的位置
    private void swap(int i,int j)
    {
        children[num] = new huluwa();
        children[num] = children[j];
        children[num].myPrintln(j,num);
        children[j]= children[i];
        children[j].myPrintln(i,j);
        children[i]=children[num];
        children[i].myPrintln(num,i);
    }

    //冒泡排序
    public void bubbleSort()
    {
        for(int i = num-1;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(children[j+1].cmp(children[j])<0)
                {
                    swap(j,j+1);

                }
            }
        }
        printNum();
    }
    private int partition(int left,int right)
    {
        int pivotpos = left;
        huluwa temp = new huluwa();
        temp = children[left];
        for(int i=left+1;i<=right;i++)
        {
            if(children[i].cmp(temp) < 0)
            {
                pivotpos++;
                if(pivotpos!=i)
                {
                    swap(i,pivotpos);
                }
            }

        }
        swap(left,pivotpos);
        return pivotpos;
    }
    private void quickPartSort(int left,int right)
    {
        if(left < right)
        {
            int pivotpos = partition(left,right);
            quickPartSort(left,pivotpos-1);
            quickPartSort(pivotpos+1,right);
        }
    }

    //快速排序
    public void quickSort()
    {
        quickPartSort(0,num-1);
        printColor();
    }
}
