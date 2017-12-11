/**
 * Created by Yuyang Wei on 2017/10/17.
 */
public class BubbleSorter implements Sorter{
    @Override
    public void sort(Map map) {
        System.out.println("");
        Creature creature;
        Position[][]positions=map.getPositions();

        for(int i=0;i<7-1;i++){
            for(int j=0;j<7-i-1;j++){
                if(((Comparable) (positions[j+2][9].getHolder())).biggerThan((Comparable) (positions[j+2+1][9].getHolder()))){
                    creature = positions[j+2][9].getHolder();
                    positions[j+2+1][9].getHolder().setPosition(positions[j+2][9]);
                    creature.setPosition(positions[j+2+1][9]);
                }
            }
        }
    }
}
