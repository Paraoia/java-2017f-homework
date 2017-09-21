public class Intsort {
    public static void main(String[] args)
    {
        int array[] = new int []{2,58,59,5,87,76,7,97,46,4};
        for(int i = 0; i < 10; ++i)
        {
            int min_index = i;
            for(int j = i; j < 10; ++j)
            {
                if(array[j] < array[min_index])
                {
                    min_index = j;
                }
            }
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
        System.out.println("array sorted:");
        for(int i = 0; i < 10; ++i)
            System.out.println(array[i]);
    }
}
