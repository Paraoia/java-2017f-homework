import java.util.ArrayList;

public class BubbleSorter implements Sorter<Creature> {

    @Override
    public void sort(ArrayList<Position<Creature>> positions, int beg, int end) {
        Creature creature;

        for (int i = beg; i < end; i++) {
            for (int j = beg; j <= end - i; j++) {
                if (((Comparable) (positions.get(j).getHolder())).biggerThan((Comparable) (positions.get(j + 1).getHolder()))) {
                    creature = positions.get(j).getHolder();
                    positions.get(j + 1).getHolder().setPosition(positions.get(j));
                    creature.setPosition(positions.get(j + 1));
                }
            }
        }
    }
}
