public class InsertionSort {
    public static void main(String[] args){
        int a[] = {32, 13, 24, 56, 12, 77, 34, 65};
        InsertionSort obj=new InsertionSort();
        System.out.println("Original:");
        obj.printArray(a);
        obj.insertionSort(a);
        System.out.println("Sorted:");
        obj.printArray(a);
    }

    public void printArray(int[] A){
        for(int i=0; i<A.length;i++){
            System.out.printf("%d ", A[i]);
        }
        System.out.print("\n");
    }

    private void insertionSort(int[] A){
        for(int i=1; i<A.length; i++){
            if ( A[i] < A[i-1]) {
                int temp = A[i];
                A[i] = A[i - 1];
                int j = i - 1;
                while (j > 0 && A[j - 1] > temp) {
                    A[j] = A[j - 1];
                    j = j - 1;
                }
                A[j] = temp;
            }
        }
    }
}
