package hlw;

public class BubbleSorter implements Sorter{
    @Override
    public void Sort(Queue queue){
        Position[] space = queue.get_space();
        for (int i = 0; i < space.length - 1; i++){
            for (int j = i +1; j< space.length - 1; j++){
                if ( ((Comparable)space[j].get_holder()).BiggerThan((Comparable) space[i].get_holder())){
                    space[i].get_holder().set_pos(space[space.length-1]);
                    space[j].get_holder().set_pos(space[i]);
                    space[space.length-1].get_holder().set_pos(space[j]);
                }
            }
        }
    }
}
