/**
* quick sort algorithm
*/
public class Sort {
    public static void main(String[] args) {
        // array of 10 numbers
        int numbers[] = new int[] { 32, 43, 53, 54, 32, 65, 63, 98, 43, 23 };

        quickSort(numbers);

        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
    }

    public static void quickSort(int[] numbers) {
        quickSortAux(numbers, 0, numbers.length - 1);
    }

    public static void quickSortAux(int[] numbers, int l, int r) {
        if (l >= r)
            return;

        // partition
        int pivot = r;
        int i = l, j = l;
        while (j < pivot) {
            if (numbers[j] < numbers[pivot]) {
                // swap numbers[i] with numbers[j]
                int tmp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = tmp;

                i++;
            }
            j++;
        }

        // swap numbers[i] with numbers[pivot]
        int tmp = numbers[i];
        numbers[i] = numbers[pivot];
        numbers[pivot] = tmp;

        pivot = i;
        quickSortAux(numbers, l, pivot - 1);
        quickSortAux(numbers, pivot + 1, r);
    }
}
