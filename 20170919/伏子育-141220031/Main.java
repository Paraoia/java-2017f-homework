import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Brother> bros = new ArrayList<>();
        bros.add(new Brother(Brother.Color.RED, Brother.Name.ONE));
        bros.add(new Brother(Brother.Color.ORANGE, Brother.Name.TWO));
        bros.add(new Brother(Brother.Color.YELLOW, Brother.Name.THREE));
        bros.add(new Brother(Brother.Color.GREEN, Brother.Name.FOUR));
        bros.add(new Brother(Brother.Color.CYAN, Brother.Name.FIVE));
        bros.add(new Brother(Brother.Color.BLUE, Brother.Name.SIX));
        bros.add(new Brother(Brother.Color.PURPLE, Brother.Name.SEVEN));

        QueueManager queueManager = new QueueManager(7);
        Collections.shuffle(bros);
        queueManager.enqueue(bros);
        System.out.println("------Sort by order------");
        queueManager.arrangeQueuebyBubbleSort(new Comparator<Brother>() {
            @Override
            public int compare(Brother o1, Brother o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        queueManager.printQueue();
        Collections.shuffle(bros);
        queueManager.enqueue(bros);
        System.out.println("------Sort by color------");
        queueManager.arrangeQueuebyQuickSort(new Comparator<Brother>() {
            @Override
            public int compare(Brother o1, Brother o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        queueManager.printQueue();
    }
}
