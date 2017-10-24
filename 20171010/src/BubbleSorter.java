public class BubbleSorter implements Sorter {
    @Override
    public void sort(Queue queue) {
        Position[] copyPositions = queue.getPositions();
        for(int i = 0; i < copyPositions.length; i++) {
            boolean exchangeHappened = false;
            for (int j = 0; j < copyPositions.length - 1 - i; j++) {
                if (((Comparable) (copyPositions[j].getHolder())).isYoungerThan((Comparable) (copyPositions[j+1].getHolder()))) {
                    exchangeHappened = true;
                    copyPositions[j].swapHolderWith(copyPositions[j+1]);
                }
            }
            if (!exchangeHappened) { break; }
        }
    }
}
