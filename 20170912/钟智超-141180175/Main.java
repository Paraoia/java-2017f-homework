public class Main {
    public static void main(String[] args)
    {
        //set 10 numbers in the array
        final int NumberArray[]={32,43,12,54,2,47,66,28,90,43};
        //initialize the signal numbers
        int LargestNumber=NumberArray[0];
        int SmallestNumber=NumberArray[0];
        for(int i=1;i<10;i++)
        {
            if(LargestNumber<NumberArray[i])
            {
                LargestNumber=NumberArray[i];
            }
            else if(SmallestNumber>NumberArray[i])
            {
                SmallestNumber=NumberArray[i];
            }
        }
        System.out.println("Largest number:"+LargestNumber);
        System.out.println("Smallest number:"+SmallestNumber);
    }
}
