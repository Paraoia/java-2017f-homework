public class QuickSort {
    public static void main(String[] args) {
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        Qsort(numbers, 0, 9);
        System.out.println("The sorted numbers are:");
        for(int i = 0; i < 9; i++)
            System.out.print(numbers[i] + " ");
        System.out.println(numbers[9]);
    }

    private static void Exchange(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

    private static int Partition(int[] num, int s, int t) {
        int x = num[t];
        int i = s - 1;
        for(int j = s; j < t; j++) {
            if(num[j] <= x) {
                i++;
                Exchange(num, i, j);
            }
        }
        Exchange(num,i+1, t);
        return (i+1);
    }

    private static void Qsort(int[] num, int s, int t) {
        if(s >= t || num == null)
            return;
        int p = Partition(num, s, t);
        Qsort(num, s, p-1);
        Qsort(num,p+1, t);
    }
}