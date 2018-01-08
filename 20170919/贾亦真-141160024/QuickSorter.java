package hlw;

public class QuickSorter implements Sorter{
    private void sub_quick(Position[] array, int start, int end){
        if (start >= end){
            return;
        }
        int i = start;
        int j = end;
        Creature key_hlw = array[start].get_holder();
        while (i < j)
        {
            while(i<j && (((Comparable) key_hlw).BiggerThan((Comparable)array[j].get_holder())))
            {
                j--;
            }
            array[j].get_holder().set_pos(array[i]);
            while(i<j && ((Comparable)array[i].get_holder()).BiggerThan((Comparable) key_hlw))
            {
                i++;
            }
            array[i].get_holder().set_pos(array[j]);
        }
        key_hlw.set_pos(array[i]);
        sub_quick(array, start, i - 1);
        sub_quick(array, i + 1, end);
    }
    @Override
    public void Sort(Queue queue) {
        Position[] space = queue.get_space();
        sub_quick(space, 0, space.length - 2);
    }
}
