public class Sort {
    public static int partition(int[] array,int low,int high){
        int pivot = array[low];
        while(low < high)
        {
            while(array[high] >= pivot && high > low)
                high--;

            array[low] = array[high];

            while(array[low] <= pivot && high > low)
                low++;

            array[high] = array[low];
        }
        array[high] = pivot;
        return high;
    }
    public static void Qsort(int[] array,int low,int high){
        if(low >= high)
            return;

        int index = partition(array,low,high);
        Qsort(array,low,index - 1);
        Qsort(array,index + 1,high);

    }
    public static void main(String[] args){
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        Qsort(numbers,0,numbers.length - 1);
        for(int i = 0;i < numbers.length;i++)
            System.out.println(numbers[i]);
    }
}
