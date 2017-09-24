/**
 * Created by tangruize on 17-9-20.
 */
public class FuluwaSort {
    public void bubbleSort(Fuluwa[] arr) {
        Fuluwa temp;
        int i, j, len = arr.length;
        for (i = 0; i < len - 1; i++) {
            for (j = 0; j < len - 1 - i; j++) {
                if (arr[j].getNo() > arr[j + 1].getNo()) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void quickSort(Fuluwa[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private void qsort(Fuluwa[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            qsort(arr, p, q - 1);
            qsort(arr, q + 1, r);
        }
    }

    private int partition(Fuluwa[] arr, int p, int r) {
        Fuluwa x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (arr[j].getNo() <= x.getNo()) {
                ++i;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private void swap(Fuluwa[] arr, int i, int j) {
        if (i == j) return;
        System.out.println(arr[i].getName() + ": " + i + "->" + j);
        System.out.println(arr[j].getName() + ": " + j + "->" + i);
        Fuluwa tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
