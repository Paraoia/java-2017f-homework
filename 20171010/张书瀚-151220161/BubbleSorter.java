
public class BubbleSorter implements Sorter {
    @Override
    public void sort(Space space) {
        Creature temp;
        Creature[][] creatures = space.getCreatures();

        for (int i = 0; i < creatures[1].length - 1; i++) {
            for (int j = 0; j < creatures[1].length - 1 - i; j++) {
                if (((Comparable) creatures[1][j]).biggerThan((Comparable) creatures[1][j + 1])) {
                    temp = creatures[1][j];
                    creatures[1][j] = creatures[1][j + 1];
                    creatures[1][j + 1] = temp;
                }
            }
        }

    }
}
