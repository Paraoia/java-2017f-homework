import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue {


    private Position[] positions;

    public Position[] getPositions() {
        return positions;
    }


    public Creature[] getCreatures() {
        return creatures;
    }



    private Creature[] creatures;

    public Queue(Huluwa[] brothers) {


        this.positions = new Position[brothers.length];

        this.creatures = brothers;

        for (int i = 0; i < brothers.length; i++) {

            this.positions[i] = new Position(i);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }


    public void rollCall() {
        for (Creature creature : this.creatures) {
            creature.report();
        }
        System.out.println();
        System.out.flush();

        for (Position position : this.positions) {

            position.getHolder().report();
        }

        System.out.println("\n");
        System.out.flush();
    }

    private void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = creatures.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Position position = creatures[index].getPosition();
            creatures[index].setPosition(creatures[i].getPosition());
            creatures[i].setPosition(position);
        }
    }

    public static void main(String[] args) {

        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }

        Queue queue = new Queue(brothers);

        queue.rollCall();

        queue.shuffle();


        queue.rollCall();

        new InsertionSorter().sort(queue);

        queue.rollCall();

        queue.shuffle();


        queue.rollCall();

        new BubbleSorter().sort(queue);
        queue.rollCall();

    }
}

