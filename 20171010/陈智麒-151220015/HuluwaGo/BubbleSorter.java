package HuluwaGo;

public class BubbleSorter implements Sorter {

    @Override
    public void sort(Queue queue){
        System.out.println("冒泡排序中...");
        _bubbleSort(queue);
        System.out.println("冒泡排序完成！");
    }

    private void _bubbleSort(Queue queue){
        Position[] positions = queue.getPositions();
        int len = positions.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - 1; j++){
                /*queue.compare(j, j+1) > 0*/
                if(((Comparable)positions[j].getHolder()).biggerThan(
                                (Comparable) (positions[j+1].getHolder()))){
                    queue.swap(positions[j], positions[j+1]);
                }
            }
        }
    }
}
