import java.util.*;

public class HuluBrothers {
    private ArrayList<Huluwa> huluwas;

    public HuluBrothers() {
        huluwas = new ArrayList<Huluwa>();
        for (int i = 1; i <= 7; i++) {
            huluwas.add(new Huluwa(i));
        }
    }

    public void tellRank() {
        for (Huluwa a : huluwas) {
            a.tellRank();
        }
    }

    public void tellColor() {
        for (Huluwa a : huluwas) {
            a.tellColor();
        }
    }

    public void tellAll() {
        System.out.println(huluwas);
    }

    public void shuffle() {
        Collections.shuffle(huluwas);
    }

    public void bubbleSort() {
        for (int i = huluwas.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (huluwas.get(j + 1).lessThan(huluwas.get(j))) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void swap(int i, int j) {
        System.out.format("%s %d->%d, %s %d->%d\n", huluwas.get(i).toRankString(), i, j, huluwas.get(j).toRankString(), j, i);
        Huluwa tmp = huluwas.get(i);
        huluwas.set(i, huluwas.get(j));
        huluwas.set(j, tmp);
    }

    public void quickSort() {
        quickSortAux(0, huluwas.size() - 1);
    }

    private void quickSortAux(int l, int r) {
        if (l >= r)
            return;

        // partition
        int pivot = r;
        int i = l, j = l;
        while (j < pivot) {
            if (huluwas.get(j).lessThan(huluwas.get(pivot))) {
                if (i != j)
                    swap(i, j);
                i++;
            }
            j++;
        }

        if (i != pivot)
            swap(i, pivot);

        pivot = i;
        quickSortAux(l, pivot - 1);
        quickSortAux(pivot + 1, r);
    }
}
