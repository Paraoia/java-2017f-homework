
public class Sort {
    public static void main(String[] args) {
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        BubbleSort(numbers);
        for(int i=0;i<numbers.length;i++)
            System.out.print(numbers[i] + " ");

    }

    public static void BubbleSort(int[] numbers)
    {
        int temp;

        for(int i=0;i<numbers.length;i++)
        {
            for(int j=0;j<numbers.length-i-1;j++)
            {
                if(numbers[j]>numbers[j+1])
                {
                    temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
    }
    
}