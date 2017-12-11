
public class BubbleSorter implements Sorter {
    @Override
    public void sort(Field queue ,int row) {
        Creature creature;
        Position[] positions = queue.getPositions(row);

        for (int i = 4; i < 10; i++) {
            for (int j = 4; j < 10; j++) {
                if (((Comparable) (positions[j].getHolder())).biggerThan((Comparable) (positions[j + 1].getHolder()))) {
                    creature = positions[j].getHolder();
                    positions[j + 1].getHolder().setPosition(positions[j]);
                    creature.setPosition(positions[j + 1]);
                }
            }
        }
    }
}

