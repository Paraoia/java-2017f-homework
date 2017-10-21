public class BinarySorter implements Sorter {
    public void sort(Space space) {
        Creature temp;
        Creature creatures[][] = space.getCreatures();
        int low, middle, high;

        for (int i = 0 + 1; i <= 6; i++) {
            temp = creatures[1][i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                middle = (low + high) / 2;
                if (!((Comparable)creatures[1][i]).biggerThan((Comparable)creatures[1][middle]))
                    high = middle - 1;
                else
                    low = middle + 1;
            }

            for (int j = i - 1; j >= low; j--) {
                creatures[1][j + 1] = creatures[1][j];
            }
            creatures[1][low] = temp;
        }
    }
}
