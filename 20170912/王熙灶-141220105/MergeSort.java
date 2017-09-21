package njuics.assignments;

/**
 * merge sort algorithm
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = {1, 4, 6, 8, 2, 3, 9, 10, -1, 100, 99, 72};
        printArray(intArray);
        intSort(intArray);
        printArray(intArray);
    }

    public static void intSort(int[] intArray) {
        sort(intArray, 0, intArray.length - 1);
    }

    /**
     * recursive function, inner sort
     * @param intArray, array to be sort
     * @param left, left index
     * @param right, right index
     */
    private static void sort(int[] intArray, int left, int right) {
        if(left >= right) return;
        int mid = (left + right) / 2;
        sort(intArray, left, mid);
        sort(intArray, mid+1, right);
        merge(intArray, left, mid, right);
    }

    /**
     * inner function, merge two arrays together
     * @param intArray, array to be merged
     * @param left, left index
     * @param mid, mid index
     * @param right, right index
     */
    private static void merge(int[] intArray, int left, int mid, int right) {
        int arrayLength = right - left + 1;
        int[] newArray = new int[arrayLength];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right) {
            if(intArray[i] <= intArray[j]) {
                newArray[k++] = intArray[i++];
            }
            else {
                newArray[k++] = intArray[j++];
            }
        }
        if(i > mid) {
            while(k < arrayLength) {
                newArray[k++] = intArray[j++];
            }
        }
        else {
            while(k < arrayLength) {
                newArray[k++] = intArray[i++];
            }
        }
        for(int index1 = left, index2 = 0; index1 <= right; index1++, index2++) {
            intArray[index1] = newArray[index2];
        }
    }

    /**
     * helper function, used to print an array
     * @param intArray, array to be printed
     */
    private static void printArray(int[] intArray) {
        for(int x : intArray) {
            System.out.print(x + " ");
        }
        System.out.print("\n");
    }
}
