public class HuluwaBrothers //葫芦娃兄弟队列
{
    public Position[] positions; //一排座位

    void Initialize() //初始化
    {
        positions = new Position[7];
        int i;
        for (i = 0; i < 7; i++) {
            positions[i] = new Position();
            positions[i].index = i;
            Huluwa newbrother = new Huluwa(i + 1);
            positions[i].holder = newbrother;
            //BrothersQueue[i].Initialize(i+1); 错误写法!! brothers[i]此时为NULL!
        }
    }

    public void LineUpRandomly() //任意站队
    {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6};
        int i, rand;
        for (i = 6; i >= 0; i--) {
            java.util.Random random = new java.util.Random();// 定义随机类
            rand = random.nextInt(i + 1);// 返回[0,7)集合中的整数，注意不包括7
            if (rand != i) {
                int temp = array[i];
                array[i] = array[rand];
                array[rand] = temp;
            }
        }
        Position[] positionsCopy = new Position[7];
        for (i = 0; i < 7; i++) {
            //System.out.print(array[i] + " ");
            positionsCopy[i] = new Position();
            positionsCopy[i].index = i;
            positionsCopy[i].holder = positions[array[i]].holder; //葫芦娃随机入队
        }
        positions = positionsCopy;
    }

    public void ReportNumbers() //报数
    {
        int i;
        for (i = 0; i < 7; i++)
            positions[i].holder.reportNumber(); //每个葫芦娃依次报数
        System.out.println();
    }

    public void ReportColors() //报颜色
    {
        int i;
        for (i = 0; i < 7; i++)
            positions[i].holder.reportColor(); //每个葫芦娃依次报颜色
        System.out.println();
    }

    public void BubbleSort() //冒泡排序
    {
        int i, j;
        for (i = 0; i < 7 - 1; i++)
        {
            for (j = 0; j < 7 - 1 - i; j++)
            {
                if (positions[j].holder.index > positions[j + 1].holder.index)
                {
                    Huluwa temp = positions[j].holder;
                    positions[j+1].holder.JumpandReport(this, j+1, j);//移动位置并报告
                    temp.JumpandReport(this, j , j+1);//移动位置并报告
                }
            }
        }
    }
    private int Partition(int low, int high)
    {
        int pivotpos = low;
        Huluwa pivot =  positions[low].holder;
        int i;
        for(i = low + 1; i <= high; i++)
        {
            if( positions[i].holder.color.getColorIndex() < pivot.color.getColorIndex()) //按颜色排序
            {
                pivotpos++;
                if(pivotpos != i)
                {
                    Huluwa temp = positions[i].holder;
                    positions[pivotpos].holder.JumpandReport(this, pivotpos, i);//移动位置并报告
                    temp.JumpandReport(this, i , pivotpos);//移动位置并报告
                }
            }
        }
        if(pivotpos != low)
        {
            Huluwa temp = positions[low].holder;
            positions[pivotpos].holder.JumpandReport(this, pivotpos, low);//移动位置并报告
            temp.JumpandReport(this, low , pivotpos);//移动位置并报告
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

class Position //队列位置类
{
    public int index;
    public Huluwa holder;
}