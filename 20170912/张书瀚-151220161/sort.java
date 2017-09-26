public class sort {
    public static void main(String args[]) {
        int[] arry = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(arry, 10);
        for(int i=0; i<10; i++)
            System.out.print(arry[i]+" ");
    }

    public static void bubbleSort(int[] num, int n) {
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(num[j] > num[j+1]) {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }
}
