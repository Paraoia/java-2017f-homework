package huluwa;

public class QuickSort implements Sorter{
    @Override
    public void sort(Queue queue) {
        quickSort(queue);
    }
    private int partition(int left,int right,Queue queue)
    {
        int pivotpos = left;
        huluwa temp = new huluwa();
        temp = (huluwa)queue.getPositions()[left].getHolder();
        for(int i=left+1;i<=right;i++)
        {
            if(((Comparable)queue.getPositions()[i].getHolder()).cmp((Comparable) temp) < 0)
            {
                pivotpos++;
                if(pivotpos!=i)
                {
                    queue.swap(i,pivotpos);
                }
            }

        }
        queue.swap(left,pivotpos);
        return pivotpos;
    }
    private void quickPartSort(int left,int right,Queue queue)
    {
        if(left < right)
        {
            int pivotpos = partition(left,right,queue);
            quickPartSort(left,pivotpos-1,queue);
            quickPartSort(pivotpos+1,right,queue);
        }
    }

    //快速排序
    private void quickSort(Queue queue)
    {
        quickPartSort(0,queue.getNum()-1,queue);
        queue.printColor();
    }
}
