package huluwa;

public class BubbleSort implements Sorter{
    @Override
    public void sort(Queue queue) {
        int num = queue.getNum();
        Position[] positions = queue.getPositions();
        for(int i = num-1;i>0;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(((Comparable)positions[j+1].getHolder()).cmp((Comparable) positions[j].getHolder())<0)
                {
                    queue.swap(j,j+1);

                }
            }
        }
       // queue.printNum();
    }
}
