public class InsertionSorter implements Sorter {
    @Override
    public void sort(Position[] positions, int length) {
        Creature creature;
        for (int i = 1; i < length; i++) {
            int j;
            creature = positions[i].getHolder();
            for(j = i - 1; j >= 0; j--)
            {
                if(((Comparable)(positions[j].getHolder())).biggerThan((Comparable)(creature)))
                {
                    positions[j].getHolder().setPosition(positions[j + 1]);
                }
                else{
                    break;
                }
            }
            creature.setPosition(positions[j + 1]);
        }
    }
}