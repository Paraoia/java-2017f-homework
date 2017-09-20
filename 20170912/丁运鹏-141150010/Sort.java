/*
  Sort Numbers in an Array Example
*/
public class Sort {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};

        int i, j;
        for(i = 0; i < numbers.length; i++) {
            int min_index = i;
            for(j = i; j < numbers.length; j++)
                if(numbers[j] < numbers[min_index])
                    min_index = j;
            if(i != min_index) {
                int temp = numbers[i];
                numbers[i] = numbers[min_index];
                numbers[min_index] = temp;
            }
        }
        System.out.print("Sorted numbers: ");
        for(i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
        System.out.print("\n");
    }
}