public class QuickSorter implements Sorter{
    public int partition(int low,int high,Queue queue){
        Position[] positions = queue.getPositions();
        Creature creature = positions[low].getHolder();
        while(low < high){
            while(low < high && ((Comparable) (positions[high].getHolder())).biggerThan((Comparable) (creature)))
                    --high;
            positions[high].getHolder().setPosition(positions[low]);
            while(low < high && (((Comparable) creature).biggerThan((Comparable) (positions[low].getHolder()))))
                ++low;
            positions[low].getHolder().setPosition(positions[high]);
        }
        creature.setPosition(positions[low]);
        return low;
    }

    public void Qsort(int low,int high,Queue queue){

        if(low < high){
            int pivot = partition(low,high,queue);
            Qsort(low,pivot-1,queue);
            Qsort(pivot+1,high,queue);
        }
    }

    @Override
    public void sort(Queue queue){
        Qsort(0,queue.getPositions().length-1,queue);
    }
}
