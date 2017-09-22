/*
  The output of a given integer array is sorted
*/
public class Sort {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        for(int i=0; i< numbers.length-1; i++)
        {
            for (int j=0;j<numbers.length-1-i;j++)
            if(numbers[j] > numbers[j+1])
            {
                int temp=numbers[j];
                numbers[j]=numbers[j+1];
                numbers[j+1]=temp;
            }
        }
        for (int i=0;i<numbers.length-1;i++)
        {
            System.out.print(numbers[i]+" ");
        }
        System.out.println(numbers[numbers.length-1]);
    }
}
