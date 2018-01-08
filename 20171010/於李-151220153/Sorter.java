import java.util.ArrayList;

public interface Sorter<T extends Creature>  {

    public void sort(ArrayList<Position<T>> positions, int beg, int end);
}
