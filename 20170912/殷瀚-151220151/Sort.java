/* sort a given integer array using bubble sort and then output it */
public class Sort {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        //bubble sort
        for(int i=0; i< numbers.length; i++)
        {
            for(int j=0; j< numbers.length-i-1; j++)
            {
                if(numbers[j] < numbers[j+1])
                {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        //output
        System.out.println("Sorted Array: ");
        for(int i=0; i< numbers.length; i++)
            System.out.println(numbers[i]);
    }
}
