import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue {
    final static int N=16;
    protected Position[] positions;

    public Position[] getPositions() {
        return positions;
    }


    public Creature[] getCreatures() {
        return creatures;
    }



    protected Creature[] creatures;
    public Queue(){};
    /*public Queue(Huluwa[] brothers) {


        this.positions = new Position[brothers.length];

        this.creatures = brothers;

        for (int i = 0; i < brothers.length; i++) {

            this.positions[i] = new Position(N/2+N/4,i);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }*/


    public void rollCall() {
        /*for (Creature creature : this.creatures) {
            creature.report();
        }
        System.out.println();
        System.out.flush();*/

        for (Position position : this.positions) {

            position.getHolder().report();
        }

        System.out.println("\n");
        System.out.flush();
    }

    public void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = creatures.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Position position = creatures[index].getPosition();
            creatures[index].setPosition(creatures[i].getPosition());
            creatures[i].setPosition(position);
        }
    }


}

