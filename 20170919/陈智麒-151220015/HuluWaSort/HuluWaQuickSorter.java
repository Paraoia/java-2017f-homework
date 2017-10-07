package HuluWaSort;

import java.util.ArrayList;

public class HuluWaQuickSorter extends HuluWaGeneralSorter {

    HuluWaQuickSorter(ArrayList<HuluWa> huluWaList) {
        super(huluWaList);
    }

    @Override
    public void sort() {
        System.out.println("快速排序中：");
        _quickSort(0, huluWaList.size() - 1);
        System.out.println("\n快速排序完成！");
    }

    private void _quickSort(int l, int r) {
        if (l >= r) return;

        int middle = l;
        int split = l;
        for (int i = middle + 1; i <= r; i++) {
            if (compare(middle, i) > 0) {
                split++;
                swap(split, i, true);
            }
        }

        swap(split, middle, true);
        middle = split;

        _quickSort(l, middle - 1);
        _quickSort(middle + 1, r);
    }
}
