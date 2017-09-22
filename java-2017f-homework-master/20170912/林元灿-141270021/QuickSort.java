public class QuickSort {

    public static void qs(int[] a, int lo, int hi)
    {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        qs(a, lo, j - 1);
        qs(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
            while (a[++i] < a[lo])
                if (i == hi) break;
            while (a[--j] > a[lo])
                if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }
    private static void swap(int[] a, int lo, int hi)
    {
        int temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }
    public static void main(String[] args) {
        int[] arr={21,92,3,24,56,9,8,77,6};
        qs(arr,0,arr.length-1);
        for(int i=0;i<arr.length;++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
