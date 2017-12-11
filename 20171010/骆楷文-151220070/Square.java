import javafx.geometry.Pos;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Square {

    public static final int SQUARE_SIZE =  16;

    private Position[][] square;

    public Position[][] getSquare() {
        return square;
    }

    private Creature[][] creatures;

    public Creature[][] getCreatures() {
        return creatures;
    }

    public Square(){
        this.square = new Position[SQUARE_SIZE][SQUARE_SIZE];

        this.creatures = new Creature[SQUARE_SIZE][SQUARE_SIZE];

        for(int i = 0;i < SQUARE_SIZE;i++){
            for(int j = 0;j < SQUARE_SIZE;j++){
                this.square[i][j] = new Position(i*SQUARE_SIZE + j);
                this.creatures[i][j] = null;
            }
        }
    }

    public void union(Queue queue){
        Position[] positions = queue.getPositions();
        for(int i = 0;i < positions.length;i++){
            this.square[this.SQUARE_SIZE/2][i].setHolder(positions[i].getHolder());
           creatures[this.SQUARE_SIZE/2][i] = positions[i].getHolder();
        }
    }

    public void union(Snake snake){
        this.square[2][3*SQUARE_SIZE/4].setHolder(snake);
        creatures[2][3*SQUARE_SIZE/4] = snake;
    }

    public void union(Grandpa grandpa){
        this.square[2][SQUARE_SIZE/4].setHolder(grandpa);
        creatures[2][SQUARE_SIZE/4] = grandpa;
    }

    public void union(LouLuo[] louLuos,Scorpion scorpion,int type){
        Place place = new Place(type);
        this.square[(SQUARE_SIZE/2 + place.coord[0][1])][
                SQUARE_SIZE/2+place.coord[0][0]].setHolder(scorpion);
        scorpion.setPosition(square[(SQUARE_SIZE/2 + place.coord[0][1])][
                SQUARE_SIZE/2+place.coord[0][0]]);
        creatures[(SQUARE_SIZE/2 + place.coord[0][1])][
                SQUARE_SIZE/2+place.coord[0][0]] = scorpion;
        for (int i = 0; i < louLuos.length && i < place.length; i++) {
            this.square[(SQUARE_SIZE/2 + place.coord[i+1][1])][
                    SQUARE_SIZE/2+place.coord[i+1][0]].setHolder(louLuos[i]);
            louLuos[i].setPosition(this.square[(SQUARE_SIZE/2 + place.coord[i+1][1])][
                    SQUARE_SIZE/2+place.coord[i+1][0]]);
            creatures[(SQUARE_SIZE/2 + place.coord[i+1][1])][
                    SQUARE_SIZE/2+place.coord[i+1][0]] = louLuos[i];
        }
    }

    public void clear(){
        this.square = new Position[SQUARE_SIZE][SQUARE_SIZE];

        this.creatures = new Creature[SQUARE_SIZE][SQUARE_SIZE];

        for(int i = 0;i < SQUARE_SIZE;i++){
            for(int j = 0;j < SQUARE_SIZE;j++){
                this.square[i][j] = new Position(i*SQUARE_SIZE + j);
                this.creatures[i][j] = null;
            }
        }
    }

    public void rollcall(){
        for(int i = 0;i < SQUARE_SIZE;i++){
            for(int j = 0;j < SQUARE_SIZE;j++){
                System.out.print("||");
                if(creatures[i][j] != null)
                    //creatures[i*SQUARE_SIZE + j].report();
                    square[i][j].getHolder().report();
                else
                    System.out.print("口口口口");
            }
            System.out.print("\n");

        }
        System.out.print("\n\n");
    }

    public static void main(String[] args){
        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }

        Queue queue1 = new Queue(brothers);

        queue1.rollCall();
        queue1.shuffle();
        new BubbleSorter().sort(queue1);
        queue1.rollCall();

        Square square = new Square();
        queue1.join(square);
        //square.union(queue1);
        square.rollcall();

        LouLuo[] louLuos = new LouLuo[6];
        for(int i = 0;i < louLuos.length;i++){
            louLuos[i] = new LouLuo(LName.values()[i]);
        }

        Scorpion scorpion = new Scorpion();

        square.union(louLuos,scorpion,8);

        Snake snake = new Snake();
        Grandpa grandpa = new Grandpa();
        square.union(snake);
        square.union(grandpa);

        square.rollcall();

        square.clear();
        square.rollcall();

        queue1.join(square);
        square.rollcall();
    }
}
