public class HuluwaBrothers
{
    Huluwa []brothers;
    void Initialize() //初始化
    {
        brothers = new Huluwa[7];
        int i;
        for(i = 0; i < 7; i++)
        {
            Huluwa newbrother = new Huluwa(i+1);
            brothers[i] = newbrother;
            //brothers[i].Initialize(i+1); 错误写法!! brothers[i]此时为NULL!
        }
    }
    public void LineUpRandomly() //任意站队
    {
        int [] array = new int []{0,1,2,3,4,5,6};
        int i, rand;
        for(i = 6; i >= 0; i--)
        {
            java.util.Random random=new java.util.Random();// 定义随机类
            rand = random.nextInt(i+1);// 返回[0,7)集合中的整数，注意不包括10
            if(rand != i)
            {
                int temp = array[i];
                array[i] = array[rand];
                array[rand] = temp;
            }
        }
        Huluwa []brothersCopy = new Huluwa[7];
        for(i = 0; i < 7; i++)
        {
            //System.out.print(array[i] + " ");
            brothersCopy[i] = brothers[array[i]];
        }
        brothers = brothersCopy;
    }
    public void GiveNumbers() //报数
    {
        int i;
        for(i = 0; i < 7; i++)
            brothers[i].giveNumber(); //每个葫芦娃依次报数
        System.out.println();
    }
    public void GiveColors() //报颜色
    {
        int i;
        for(i = 0; i < 7; i++)
            brothers[i].giveColor(); //每个葫芦娃依次报颜色
        System.out.println();
    }
    public void BubbleSort() //冒泡排序
    {
        int i, j;
        for(i = 0; i < 7 - 1; i++)
        {
            for(j = 0; j < 7 - 1 - i; j++)
            {
                if(brothers[j].index > brothers[j+1].index)
                {
                    brothers[j].Move(j, j+1);//报告交换位置
                    brothers[j+1].Move(j+1, j);//报告交换位置
                    Huluwa temp = brothers[j];
                    brothers[j] = brothers[j+1];
                    brothers[j+1] = temp;
                }
            }
        }
    }
    private int Partition(int low, int high)
    {
        int pivotpos = low;
        Huluwa pivot = brothers[low];
        int i;
        for(i = low + 1; i <= high; i++)
        {
            if(brothers[i].index < pivot.index)
            {
                pivotpos++;
                if(pivotpos != i)
                {
                    brothers[i].Move(i, pivotpos); //报告交换位置
                    brothers[pivotpos].Move(pivotpos, i); //报告交换位置
                    Huluwa temp = brothers[i];
                    brothers[i] = brothers[pivotpos];
                    brothers[pivotpos] = temp;
                }
            }
        }
        if(pivotpos != low)
        {
            brothers[pivotpos].Move(pivotpos, low); //报告交换位置
            pivot.Move(low, pivotpos); //报告交换位置
            brothers[low] = brothers[pivotpos];
            brothers[pivotpos] = pivot;
        }
        return pivotpos;
    }
    public void QuickSort(int left, int right) //快速排序
    {
        if(left < right)
        {
            int pivotpos = Partition(left, right);
            QuickSort(left, pivotpos - 1);
            QuickSort(pivotpos+1, right);
        }
    }
}
