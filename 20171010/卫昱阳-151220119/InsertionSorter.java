/**
 * Created by Yuyang Wei on 2017/10/17.
 */
public class InsertionSorter implements Sorter{
    @Override
    public void sort(Map map){
        System.out.println("");
        Position[][] positions=map.getPositions();
        Creature creature=null;
        int j;
        for (int i = 1; i < 7; i++) {
            for (j = i; j > 0; j--) {
                if (!((Comparable) (positions[j+2][9].getHolder())).biggerThan((Comparable) (positions[j+2-1][9].getHolder()))) {
                    creature = positions[j+2][9].getHolder();
                    positions[j+2-1][9].getHolder().setPosition(positions[j+2][9]);
                    creature.setPosition(positions[j+2-1][9]);
                }
            }
        }

    }
}
