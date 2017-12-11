import java.util.Random;

public class Queue {
    private Creature[] creatures;
    public int getLength() {
        return creatures.length;
    }
    Queue(Creature[] creature) {
        creatures = creature;
    }
    public Creature[] getCreatures() {
        return creatures;
    }
    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < creatures.length; i++) {
            int j = random.nextInt(creatures.length);
            Creature temp = creatures[i];
            creatures[i] = creatures[j];
            creatures[j] = temp;
        }
    }
    public void queuqReport() {
        for(Creature creature : this.creatures) {
            creature.report();
        }
        System.out.println();
    }
}
