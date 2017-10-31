
public class BubbleSorter implements Sorter {

    @Override
    public void sort(Space space, int row, int col, int length){
        Position[][] positions = space.getPositions();
        Creature creature;
        for(int i = 0; i < length - 1; i++){
            for(int j = 0; j < length - i - 1; j++){
                if(((Comparable) (positions[row][col + j + 1].getHolder())).rank_biggerThan((Comparable)(positions[row][col + j].getHolder()))){
                    creature = positions[row][col + j + 1].getHolder();
                    positions[row][col + j + 1].setHolder(positions[row][col + j].getHolder());
                    positions[row][col + j].setHolder(creature);
                }
            }
        }
    }
}
