/**
 * Created by Yuyang Wei on 2017/10/16.
 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Map {

    public static final int N=12;

    private Position[][] positions;

    public Position[][] getPositions() {
        return positions;
    }

    public Creature[][] getCreatures() {
        return creatures;
    }

    private Creature[][] creatures;

    public Map(){
        this.positions=new Position[N][N];
        this.creatures=new Creature[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                this.positions[i][j]=new Position(i,j);
            }
        }
    }

    public void putMan(int x, int y, Creature creature){
        this.creatures[x][y]=creature;
        //this.positions[x][y]=new Position(x,y);
        this.positions[x][y].setHaveTrue();
        this.creatures[x][y].setPosition(this.positions[x][y]);
    }

    public void showMap(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(this.positions[i][j].getHave()==true){
                    positions[i][j].getHolder().report();
                    System.out.print("\t");
                }
                else
                {
                    System.out.print("          \t");
                }

            }
            System.out.print("\n");
        }
    }

    public void rollCall(int x, int y){
        positions[x][y].getHolder().report();

        System.out.println(" ");
        System.out.flush();
    }

    private void shuffle(int y){
        System.out.println("");
        Random rnd=ThreadLocalRandom.current();
        for(int i=8;i>1;i--){
            int index=rnd.nextInt(i+1);

            if(index<3){
                index+=2;
            }// in case of overflow

            Position position=creatures[index][y].getPosition();
            creatures[index][y].setPosition(creatures[i][y].getPosition());
            creatures[i][y].setPosition(position);
        }
    }

    public static void main(String[] args) {
        Huluwa[] brothers=new Huluwa[7];
        for(int i=0;i<brothers.length;i++){
            brothers[i]=new Huluwa(COLOR.values()[i],SENIORITY.values()[i]);
        }

        Map map=new Map();


        for(int i=0;i<brothers.length;i++){
            map.putMan(i+2,9,brothers[i]);
        }

        for(int i=0;i<brothers.length;i++){
            map.rollCall(i+2,9);
        }

        map.shuffle(9);

        for(int i=0;i<brothers.length;i++){
            map.rollCall(i+2,9);
        }


        new InsertionSorter().sort(map);

        for(int i=0;i<brothers.length;i++){
            map.rollCall(i+2,9);
        }

        map.shuffle(9);

        for(int i=0;i<brothers.length;i++){
            map.rollCall(i+2,9);
        }

        new BubbleSorter().sort(map);

        for(int i=0;i<brothers.length;i++){
            map.rollCall(i+2,9);
        }

        Scorpion scorpion=new Scorpion();

        Toad[] toads=new Toad[7];
        for(int i=0;i<7;i++){
            toads[i]=new Toad();
        }

        Snake snake=new Snake();

        Grandfather grandfather=new Grandfather();


        new HeYiZhen().marshal(map,scorpion,toads,N);

        new SnakeCheer().cheer(map,snake);

        new GrandfatherCheer().cheer(map,grandfather);

        map.showMap();

        new FangZhen().marshal(map,scorpion,toads,N);

        new SnakeCheer().cheer(map,snake);

        new GrandfatherCheer().cheer(map,grandfather);

        map.showMap();
    }//main

}
