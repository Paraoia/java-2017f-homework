public class BubbleSorter implements Sorter {
    @Override
    public void sort(Queue queue, int startRow, int startCol, int len) {
        Creature creature;
        Position[] positions = queue.getPositions(startRow);
        for (int i = startCol; i < startCol + len - 1; i++) {
            for (int j = startCol; j < startCol + len - 1; j++) {
                if (((Comparable) (positions[j].getHolder())).biggerThan((Comparable) (positions[j + 1].getHolder()))) {
                    creature = positions[j].getHolder();
                    positions[j + 1].getHolder().setPosition(positions[j]);
                    creature.setPosition(positions[j + 1]);
                }
            }
        }
    }
}
