import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        //assign first element of an array to largest and smallest
        quickSort(numbers,0,numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }
    public static void quickSort(int[] numbers,int low,int high){
        if(low < high){
            int middle = getMiddle(numbers,low,high);
            quickSort(numbers,low,middle-1);
            quickSort(numbers,middle+1,high);
        }
    }
    public static int getMiddle(int[] numbers,int low,int high){
        int temp = numbers[low];
		
        while(low < high)
        {
            while(low < high && numbers[high] >= temp)
                high--;
            numbers[low] = numbers[high];
			
            while(low < high && numbers[low] <= temp)
                low++;
            numbers[high] = numbers[low];
        }
		
        numbers[low] = temp;
		
        return low;
    }
}