import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue {
	private Position[] positions;
	private Creature[] creatures;
	
	Queue(Creature[] creatures){
		
        this.positions = new Position[creatures.length];

        this.creatures = creatures;

        for (int i = 0; i < creatures.length; i++) {

            this.positions[i] = new Position();
            this.creatures[i].setPosition(this.positions[i]);
        }
	}
	
    public Position[] getPositions() {
        return positions;
    }

    public Creature[] getCreatures() {
        return creatures;
    }
    
    public void report() {

        //每个位置上的葫芦娃
        for (Position position : this.positions) {
            position.getHolder().report();
        }

        System.out.println("\n");
        System.out.flush();
    }

    //随机
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
