/*编写一个Java类及其main方法，实现对一个给定的整型数组进行排序后输出*/

public class ordonner
{
    public static void main(String[] args)
    {
        int int_arr[] = {7, 5, 1, 3, 3, 6, 1, 0};

        for (int i = 0; i < int_arr.length-1; i++)
        {
            for (int j = 0; j < int_arr.length-1-i; j++)
            {
                if (int_arr[j] < int_arr[j+1])
                {
                    int_arr[j] += int_arr[j+1];
                    int_arr[j+1] = int_arr[j] - int_arr[j+1];
                    int_arr[j] = int_arr[j] - int_arr[j+1]; 
                }
            }
        }

        System.out.println("Les chiffres rangés par order sont: ");
        for (int n = 0; n < int_arr.length; n++)
            System.out.println(int_arr[n]);
    }
}
