import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CreatrueQueue implements Queue{


    private Position[] positions;

    @Override
    public Position[] getPositions() {
        return positions;
    }

    @Override
    public Creature[] getCreatures() {
        return creatures;
    }



    private Creature[] creatures;

    public CreatrueQueue(Creature[] creatures) {


        this.positions = new Position[creatures.length];

        this.creatures = creatures;

        for (int i = 0; i < creatures.length; i++) {

            this.positions[i] = new Position(i, 0);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }

    @Override
    public void rollCall() {

        for (Position position : this.positions) {

            position.getHolder().report();
        }

        System.out.println("\n");
        System.out.flush();
    }

    @Override
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

