public class InsertionSorter implements Sorter {
    @Override
    public void sort(Queue queue) {
        Position[] positions = queue.getPositions();
        Creature creature = null;
        int j;
        for (int i = 1; i < positions.length; i++) {
            for (j = i; j > 0; j--) {
                if (!((Comparable) (positions[j].getHolder())).biggerThan((Comparable) (positions[j - 1].getHolder()))) {
                    creature = positions[j].getHolder();
                    positions[j - 1].getHolder().setPosition(positions[j]);
                    creature.setPosition(positions[j - 1]);
                }
            }
        }
    }
}
