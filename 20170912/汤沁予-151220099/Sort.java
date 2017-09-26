public class Sort
{
    public static void main(String[] args)
    {
        int numbers[] = new int[]{32,45,53,54,31,65,63,98,43,23};
        for(int i=numbers.length-1; i>=0; i--)
        {
            for(int j=0;j<i;j++)
            {
                if(numbers[j]>numbers[j+1])
                {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        for(int i=0; i<numbers.length;i++)
            System.out.println( numbers[i] + " ");
    }
}