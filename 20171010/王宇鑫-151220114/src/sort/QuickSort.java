package sort;

import field.Position;
import unit.Unit;

import java.util.Random;

public class QuickSort implements Sorter {
    @Override
    public void sort(Sortable list) {
        System.out.println("--- Quick Sort ---");
        qSort(list, list.getFirst(), list.getLast());
        System.out.println("------ End ------");
    }

    private void qSort(Sortable list, Position l, Position r) {
        if (list.distance(r, l) < 1) return;
        //save
        Position ls = l, rs = r;
        //pivot
        Random random = new Random(System.currentTimeMillis());
        Position pivotPosition = list.get(l, random.nextInt(list.distance(r, l) + 1));
        Unit pivot = pivotPosition.getSeat();
        //prepare
        Position empty = l;
        l = list.get(l, 1);
        empty.getSeat().moveTo(pivotPosition);
        //go
        out: while (true) {
            while (true) {
                if (r.getSeat().compareTo(pivot) < 0) break;
                r = list.get(r, -1);
                if (list.distance(l, r) > 0) break out;
            }
            r.getSeat().moveTo(empty);
            empty = r;
            while (true) {
                if (l.getSeat().compareTo(pivot) > 0) break;
                l = list.get(l, 1);
                if (list.distance(l, r) >= 0) break out;
            }
            l.getSeat().moveTo(empty);
            empty = l;
        }
        //fulfill empty
        pivot.moveTo(empty);
        //sort the remain
        qSort(list, ls, list.get(empty, -1));
        qSort(list, list.get(empty, 1), rs);
    }
}
