import java.util.List;

public class BubbleSort implements Sorter {
    @Override
    public void sort(Queue queue) {
        Creature[] creatures = queue.getCreatures();
        for (int i = creatures.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (creatures[j].Greater(creatures[i])) {
                    Creature temp = creatures[i];
                    creatures[i] = creatures[j];
                    creatures[j] = temp;
                }
            }
        }
    }
}
