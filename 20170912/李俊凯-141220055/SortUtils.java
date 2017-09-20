package assignment.homework01;

/**
 * Created by ljkgo_000 on 2017/9/13.
 */
public class SortUtils {
    public static void main(String args[]) {
        int[] arr = {5, 2, 8, 4, 6, 7, 3, 1, 9, 0};
        QuickSort(arr, 0, arr.length - 1);
        PrintArray(arr);
    }

    public static void PrintArray(int a[]) {
        for (int i : a)
            System.out.print(i + " ");
    }

    public static void BubbleSort(int a[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void InsertSort(int a[], int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void SelectionSort(int a[], int n) {
        for (int i = 0; i < n; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (min > a[j]) {
                    min = a[j];
                    minIndex = j;
                }
            }
            if(min < a[i]) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void QuickSort(int a[], int left, int right) {
        if(left < right) {
            int i = left, j = right;
            int split_point = a[i];
            while(i < j) {
                while(i < j && a[j] > split_point) {
                    j--;
                }
                if (i < j){
                    a[i] = a[j];
                    i++;
                }

                while(i < j && a[i] < split_point) {
                    i++;
                }
                if (i < j){
                    a[j] = a[i];
                    j--;
                }
            }
            a[i] = split_point;
            QuickSort(a, left, i);
            QuickSort(a, i + 1, right);
        }
    }

}
