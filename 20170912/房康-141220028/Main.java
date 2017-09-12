public class Main{
    public static void main(String[] args){
        int[] numbers = new int[]{32,43,53,54,32,65,63,98,43,23};
        sort(numbers, 0, numbers.length - 1);
        for(int num : numbers){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    private static void sort(int[] array, int low, int high){
        if(low < high){
            int pos = partition(array, low, high);
            sort(array, low, pos - 1);
            sort(array, pos + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high){
        int temp = array[low];
        int i = low, j = high;
        while(i != j){
            while(array[j] >= temp && i < j){
                j--;
            }
            while(array[i] <= temp && i < j){
                i++;
            }
            if(i < j){
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        array[low] = array[i];
        array[i] = temp;
        return i;
    }
}