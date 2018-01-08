import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class Queue {//Queue里面存放的是葫芦娃队伍
    private Position[]positions;
    private static final int NUM =7;
    private Creature[]creatures=new Huluwa[NUM];
    Queue()
    {
        this.positions=new Position[NUM];
        for(int i=0;i<creatures.length;i++)
        {
            creatures[i]=new Huluwa(i+1);
            this.positions[i]=new Position(0,i);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }
    public Position[] getPositions() {
        return positions;
    }
    public Creature[] getCreatures() {
        return creatures;
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
    public void rollCall() {
        /*for (Creature creature : this.creatures) {
            creature.report();
        }
        System.out.println();
        System.out.flush();
       */
        for (Position position : this.positions) {

            position.getHolder().report();
        }
        System.out.println();
        System.out.flush();

    }
    public static void main(String[] args){
        Queue queue=new Queue();
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
