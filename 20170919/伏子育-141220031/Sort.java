/**
 * Created by rajesh on 17-9-25.
 */

import java.util.List;
import java.util.Comparator;

public class Sort {
    public void bubbleSort(List<Brother> list, Comparator<Brother> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    Brother tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                    System.out.println("Bother " + list.get(j).getName() + ":" + j + "->" + (j + 1));
                    System.out.println("Bother " + list.get(j + 1).getName() + ":" + (j + 1) + "->" + j);
                }
            }
        }
    }

    private int partition(List<Brother> list, Comparator<Brother> comparator, int low, int high) {
        Brother pivot = list.get(low);
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && comparator.compare(list.get(right), pivot) >= 0) {
                right--;
            }
            while (left < right && comparator.compare(list.get(left), pivot) <= 0) {
                left++;
            }
            if (left < right) {
                Brother tmp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, tmp);
                System.out.println("Bother " + list.get(left).getName() + ":" + left + "->" + right);
                System.out.println("Bother " + list.get(right).getName() + ":" + right + "->" + left);
            }
        }
        list.set(low, list.get(left));
        list.set(left, pivot);
        return left;
    }

    public void sort(List<Brother> list, Comparator<Brother> comparator, int low, int high) {
        if (low < high) {
            int p = partition(list, comparator, low, high);
            sort(list, comparator, low, p - 1);
            sort(list, comparator, p + 1, high);
        }
    }

    public void quickSort(List<Brother> list, Comparator<Brother> comparator) {
        sort(list, comparator, 0, list.size() - 1);
    }
}
