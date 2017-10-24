public class BubbleSorter implements Sorter{
    @Override
    public void sort(Position[] positions, int length) {
        Creature creature;
        for (int i = positions.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(((Comparable)(positions[j].getHolder())).biggerThan((Comparable)(positions[j + 1].getHolder()))) {
                    //exchange position
                    creature = positions[j].getHolder();
                    positions[j + 1].getHolder().setPosition(positions[j]);
                    creature.setPosition(positions[j + 1]);
                }
            }
        }
    }
}
