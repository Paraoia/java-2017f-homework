public class sort
{
    public static void main(String[] args) {
        int[] number = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 10, 11, 20, 18, 19, 17, 16, 16, 14, 13, 12, 11, 15};//the array
        sort(number);
        output(number);
    }

    public static void sort(int[] number)
    {
        for(int i=0;i<number.length;i++)
        {
            for(int j=0;j<number.length - 1 - i;j++)
            {
                if(number[j]>number[j+1])
                {
                    int temp = number[j];
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        }
    }
    public static void output(int[] number)
    {
        for(int i=0;i<number.length;i++)
        {
            System.out.print(number[i]);
            System.out.print(' ');
        }
    }


}
