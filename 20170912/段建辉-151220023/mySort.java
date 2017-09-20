/**
 * This is a quick sort version
 */
public class mySort {
    public static void quickSort(int[] arr){
        qSort(arr, 0, arr.length-1);
    }
    private static void qSort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);
            qSort(arr, low, pivot-1);
            qSort(arr, pivot+1, high);
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        while (low<high){
            while (low<high && arr[high]>=pivot)
                --high;
            arr[low]=arr[high];
            while (low<high && arr[low]<=pivot)
                ++low;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
    public static void main(String arg[]) {
        int[] arr = {100,1,23,4,77,6,0};
        quickSort(arr);
        for(int i = 0;i < arr.length; i++)
            System.out.print(arr[i] + " ");

        return;
    }
}
