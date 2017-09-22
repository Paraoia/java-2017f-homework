public class SelectSort{
    public static void main(String[] args)
    {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        //assign first element of an array to largest and smallest
        int i,j,k;
        for(i = 0; i< numbers.length; i++)
        {
            k = i;
            for(j = k + 1; j < numbers.length;j++)
            {
                if (numbers[j] < numbers[k])
                {
                    k = j;
                }
            }
            if(i!=k)
            {
                int temp = numbers[i];
                numbers[i] = numbers[k];
                numbers[k] = temp;
            }
        }
        System.out.println("After the sorting, the array becomes:");
        for(i = 0; i<numbers.length;i++)
        {
           System.out.println(numbers[i]+" ");
        }
        System.out.println("Largest Number is : " + numbers[9]+"\n");
        System.out.println("Smallest Number is : " + numbers[0]);
    }
}