import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Space {

    private static final int SIZE = 100;//二维平面大小
    private Position[][] positions;//二维平面

    public Position[][] getPositions() {
        return positions;
    }

    public static int getSIZE() {
        return SIZE;
    }

    public Space(){
        positions = new Position[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                positions[i][j] = new Position(i, j);
            }
        }
    }

    public boolean EnterCreature(Creature creature, int row, int col){
        if(row >= SIZE || col >= SIZE){
            System.out.println("Out of space!");
            return false;
        }
        creature.setPosition(positions[row][col]);
        positions[row][col].setHolder(creature);
        return true;
    }

    public boolean EnterRow(Creature[] creatures, int row, int col){
        if((col + creatures.length) > SIZE){
            System.out.println("Out of space!");
            return false;
        }
        for(int i = 0; i < creatures.length; i++){
            EnterCreature(creatures[i], row, col + i);
        }
        return true;
    }

    public boolean EnterCol(Creature[] creatures, int row, int col){
        if((row + creatures.length) > SIZE){
            System.out.println("Out of space!");
            return false;
        }
        for(int i = 0; i < creatures.length; i++){
            EnterCreature(creatures[i], row + i, col);
        }
        return true;
    }

    public void shuffle_row(int row, int col, int length){
        if((col + length) > SIZE){
            System.out.println("Out of space!");
            return;
        }
        Random random = ThreadLocalRandom.current();
        for(int i = length - 1; i >= 0; i--){
            int index = random.nextInt(length);
            Creature creature = positions[row][col + i].getHolder();
            positions[row][col + i].setHolder(positions[row][col + index].getHolder());
            positions[row][col + index].setHolder(creature);
        }
    }

    public void report(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++) {
                if(positions[i][j].is_occupied())
                    positions[i][j].getHolder().report();
                else
                    System.out.print("''");
            }
            System.out.print("\n");
        }
    }

    public void report_row(int row, int col, int length){
        if((col + length) > SIZE){
            System.out.println("Out of range!");
            return;
        }
        for(int i = 0; i < length; i++){
            if(positions[row][col + i].is_occupied())
                positions[row][col + i].getHolder().report();
            else
                System.out.print("''");
        }
        System.out.print("\n");
    }

    public void reset(){
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                    positions[i][j].cleanHolder();
            }
        }
    }

    public Creature cleanPosition(int row, int col){
        if(positions[row][col].is_occupied()){
            Creature creature = positions[row][col].getHolder();
            positions[row][col].cleanHolder();
            return creature;
        }
        return null;
    }
}
