import java.util.List;

public class QuickSort implements Sorter{
    @Override
    public void sort(Queue queue) {
        Creature[] creatures = queue.getCreatures();
        Qsort(creatures,0, creatures.length);
    }

    private int Partition(Creature[] creatures, int s, int t) {
        int i = s - 1;
        for (int j = s; j < t; j++) {
            if(creatures[t].Greater(creatures[j])) {
                i++;
                if(i == j)
                    continue;
                Creature temp = creatures[i];
                creatures[i] = creatures[j];
                creatures[j] = temp;
            }
        }
        if((i+1) == t)
            return (i+1);
        Creature temp = creatures[i+1];
        creatures[i+1] = creatures[t];
        creatures[t] = temp;
        return (i+1);
    }

    private void Qsort(Creature[] creatures, int s, int t) {
        if(s >= t)
            return;
        int p = Partition(creatures, s, t);
        Qsort(creatures, s, p-1);
        Qsort(creatures, p+1, t);
    }
}
