import java.util.Arrays;

public class QuickSort{
    public static void main(String[] args){
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1, 10, 11};
        QuickSort qs = new QuickSort();
        qs.qsort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    } 

    void qsort(int[] array, int a, int b){
        if (b - a <= 0){
            return;
        }
        int index = partition(array, a, b);
        qsort(array, a, index-1);
        qsort(array, index+1, b);
    }

    int partition(int[] array, int a, int b){
        int len = b - a + 1;
        int p = (int)(Math.random() * len + a);
        swap(array, p, b);
        int index = a - 1;
        for (int i = a; i <= b; i++){
            if (array[i] < array[b]){
                index += 1;
                swap(array, index, i);
            }
        }
        index += 1;
        swap(array, index, b);
        return index;
    }

    void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}