//import java.util.Scanner;

public class Test
{
    public static void main(String []args)
    {
        //System.out.println("Hello World!");
        int array[]=new int[]{10,9,8,6,7,4,5,3,2,1};
        for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<array.length-i-1;j++)
            {
                if (array[j]>array[j+1])
                {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        for (int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }
}
