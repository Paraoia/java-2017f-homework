public class QuickSort implements Sorter {
    public void sort(Queue queue){
        Position[] copyPositions = queue.getPositions();
        quickSort(0, copyPositions.length-1, copyPositions);
    }
    private int split(int left, int right, Position[] positions) {
        int i = left;
        int j = right;
        Creature tmpCreature = positions[i].getHolder();
        while (i<j)
        {
            while (i<j && (((Comparable)(positions[j].getHolder())).isYoungerThan((Comparable)(tmpCreature))))
                j--;
            if (i<j) {
                positions[j].moveHolderTo(positions[i]);
            }
            while (i<j && (((Comparable)(positions[i].getHolder())).isOlderThan((Comparable)(tmpCreature))))
                i++;
            if (i<j){
                positions[i].moveHolderTo(positions[j]);
            }
        }
        tmpCreature.setPosition(positions[i]);
        return i;
    }
    private void quickSort(int left, int right, Position[] positions){
        int pivot;
        if (left<right)
        {
            pivot = split(left, right, positions);
            quickSort(left, pivot - 1, positions);
            quickSort(pivot + 1, right, positions);
        }
    }
}
