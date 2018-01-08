import java.util.ArrayList;

public class BinarySorter implements Sorter {
    public void sort(Space space) {
        Creature temp;
        //Creature creatures[][] = space.getCreatures();
        ArrayList<Creature> creatures = space.getCreatures().get(1);
        int low, middle, high;

        for (int i = 1; i <= 6; i++) {
            temp = creatures.get(i);
            low = 0;
            high = i - 1;
            while (low <= high) {
                middle = (low + high) / 2;
                if (!((Comparable) creatures.get(i)).biggerThan((Comparable) creatures.get(middle)))
                    high = middle - 1;
                else
                    low = middle + 1;
            }

            for (int j = i - 1; j >= low; j--) {
                creatures.set(j + 1, creatures.get(j));
            }
            creatures.set(low, temp);
        }
    }
}
