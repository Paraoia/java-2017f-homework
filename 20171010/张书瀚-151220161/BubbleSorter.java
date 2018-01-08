import java.util.ArrayList;

public class BubbleSorter implements Sorter {
    @Override
    public void sort(Space space) {
        Creature temp;
        //Creature[][] creatures = space.getCreatures();
        ArrayList<Creature> creatures = space.getCreatures().get(1);
        for (int i = 0; i < creatures.size() - 1; i++) {
            for (int j = 0; j < creatures.size() - 1 - i; j++) {
                if (((Comparable) creatures.get(j)).biggerThan((Comparable) creatures.get(j + 1))) {
                    temp = creatures.get(j);
                    creatures.set(j, creatures.get(j + 1));
                    creatures.set(j + 1, temp);
                }
            }
        }
    }
}
