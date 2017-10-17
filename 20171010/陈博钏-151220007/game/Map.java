package game;

import creature.Creature;
import java.util.Scanner;

/**
 * Created by cbcwe on 2017/10/16.
 * 'game.Map' contains N*N 'Position', and each 'Position' hold a 'creature.Creature'
 */

public class Map {

    /* inner class */
    private class Position{

        /* members variables */
        public boolean valid;
        private Creature creature;

        /* constructor */
        Position(){
            valid = false;
        }

        /* public methods */
        public boolean isValid(){
            return valid;
        }

        public void reportName(){
            creature.reportName();
        }

        public void putCreature(Creature new_creature){
            creature = new_creature;
            valid = true;
        }
        public Creature getCreature(){
            if ( ! valid )
                System.out.println("Error: unable to get a creature from position without creature");
            return creature;
        }
        public Creature removeCreature(){
            if ( ! valid )
                System.out.println("Error: unable to remove a creature from position without creature");
            valid = false;
            return creature;
        }
    }

    /* members variables */
    private Position [][] positions;
    public static int LENGTH;

    /* constructor */
    Map(int N){
        positions = new Position[N][N];
        LENGTH = N;
    }

    /* public methods */
    public boolean isValidXY(int x, int y){
        return positions[x][y].isValid();
    }

    public void printMap(){
        for(int i = 0; i < positions.length ; ++i ) {
            for (int j = 0; j < positions.length; ++j)
                positions[i][j].reportName();
            System.out.print('\n');
        }
    }

    public void putCreatureInXY(Creature creature, int x , int y){
        positions[x][y].putCreature(creature);
    }
    public Creature getCreatureInXY(int x,int y){
        return positions[x][y].getCreature();
    }
    public Creature removeCreatureInXY(int x,int y){
        return positions[x][y].removeCreature();
    }

    public static void main(String[] args){

        System.out.println("输入N来创建一个N*N的地图：");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // create the world
        Map map = new Map(N);

    }
}
