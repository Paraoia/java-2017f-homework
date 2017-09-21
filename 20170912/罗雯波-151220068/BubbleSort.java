public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{32, 9, 65, 67, 26, 75, 23, 12, 7, 34, 92, 85, 99};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        for (int x : array) {
            System.out.print(x);
            System.out.print(' ');
        }
    }

    private void sort(int[] array) {
        for (int i = array.length - 1; i > 1; i --) {
            for (int k = 0; k < i; k ++) {
                if (array[k] > array[k + 1]) {
                    int temp = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = temp;
                }
            }
        }
    }
}
