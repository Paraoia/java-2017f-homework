public class BubbleSorter implements Sorter {

    @Override
    public void sort(Position[] positions, int beg, int end) {
        Creature creature;

        for (int i = beg; i < end; i++) {
            for (int j = beg; j <= end - i; j++) {
                if (((Comparable) (positions[j].getHolder())).biggerThan((Comparable) (positions[j + 1].getHolder()))) {
                    creature = positions[j].getHolder();
                    positions[j + 1].getHolder().setPosition(positions[j]);
                    creature.setPosition(positions[j + 1]);
                }
            }
        }
    }
}
