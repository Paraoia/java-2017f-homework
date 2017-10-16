public interface Sorter //排序器接口
{
    public void sort(Queue queue);
}
class BubbleSorter implements Sorter //冒泡排序器
{
    @Override
    public void sort (Queue queue)
    {
        Position[] positions = queue.getPositions();
        int i, j;
        for (i = 0; i < positions.length - 1; i++)
        {
            for (j = 0; j < positions.length - 1 - i; j++)
            {
                 if (((Comparable)(positions[j].getHolder())).biggerThan((Comparable)(positions[j + 1].getHolder())) )
                {
                    queue.Swap(positions[j], positions[j+1]);// 位于位置j和位置j+1的两个生物交换位置
                }
            }
        }
    }
}

class QuickSorter implements Sorter  //快速排序器
{
    private Position[] positions;
    private Queue queue;
    @Override
    public void sort(Queue queue)
    {
        positions = queue.getPositions();
        this.queue = queue;
        QuickSort(0, positions.length - 1);
    }
    public void QuickSort( int left, int right) //快速排序
    {
        if(left < right)
        {
            int pivotpos = Partition(left, right);
            QuickSort(left, pivotpos - 1);
            QuickSort(pivotpos+1, right);
        }
    }
    private int Partition(int low, int high)
    {
        int pivotpos = low;
        Creature pivot =  positions[low].getHolder();
        int i;
        for(i = low + 1; i <= high; i++)
        {
            if (((Comparable)(pivot)).biggerThan((Comparable)(positions[i].getHolder())) )
            {
                pivotpos++;
                if(pivotpos != i)
                {
                    queue.Swap(positions[i], positions[pivotpos]);// 位于位置i和位置pivotpos的两个生物交换位置
                }
            }
        }
        if(pivotpos != low)
        {
            queue.Swap(positions[low], positions[pivotpos]);// 位于位置low和位置pivotpos的两个生物交换位置
        }
        return pivotpos;
    }
}
