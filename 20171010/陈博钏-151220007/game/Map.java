package game;

import creature.Creature;

/**
 * Created by cbcwe on 2017/10/16.
 * 'game.Map' contains N*N 'Position', and each 'Position' hold a 'creature.Creature'
 */

public final class Map {

    /* inner class */
    private class Position{

        /* members variables */
        public boolean valid = false;
        private Creature creature;

        /* constructor
        Position(){
            valid = false;
        }
        */

        /* public methods */
        public boolean isValid(){
            return valid;
        }

        public String toString(){
            String result;
            if(valid)
                result = creature.toString();
            else
                result = "口口";
            result += " ";
            return result;
        }

        public void putCreature(final Creature creature){
            this.creature = creature;
            valid = true;
        }
        public Creature getCreature(){
            if ( ! valid ) {
                System.out.println("Error: unable to get a creature from position without creature");
                return null;
            }
            return creature;
        }
        public Creature removeCreature(){
            if ( ! valid ) {
                System.out.println("Error: unable to remove a creature from position without creature");
                return null;
            }
            valid = false;
            return creature;
        }
    }

    /* members variables */
    private Position [][] positions;
    public final int LENGTH;

    /* constructor */
    public Map(int N){
        positions = new Position[N][N];
        LENGTH = N;
        for(int i = 0 ; i < N ; ++ i)
            for( int j = 0 ; j < N ; ++ j)
                positions[i][j] = new Position();
    }

    /* public methods */
    public boolean isValidXY(final int x, final int y){
        return positions[x][y].isValid();
    }

    public String toString(){
        String result = "\n";
        for(int i = 0; i < positions.length ; ++i ) {
            for (int j = 0; j < positions.length; ++j)
                result += positions[i][j];
            result += "\n";
        }
        return  result+"\n";
    }

    public void printMap(String arg){
        System.out.print(arg+toString());
    }

    public void putCreatureInXY(Creature creature, final int x , final int y){
        if( x < 0 || x >= LENGTH || y < 0 || y >= LENGTH )
            return;
        positions[x][y].putCreature(creature);
    }
    public Creature getCreatureInXY(final int x, final int y) {
        if( x < 0 || x >= LENGTH || y < 0 || y >= LENGTH )
            return null;
        return positions[x][y].getCreature();
    }
    public Creature removeCreatureInXY(final int x, final int y) {
        if( x < 0 || x >= LENGTH || y < 0 || y >= LENGTH )
            return null;
        return positions[x][y].removeCreature();
    }

    // For unit test
    public static void main(String[] argv){
        Map map = new Map(12); // test a 10*10 map
        map.printMap("test");           // construct a map successfully
    }
}
