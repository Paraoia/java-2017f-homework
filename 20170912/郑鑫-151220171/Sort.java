public class Sort {
    public static void main(String[ ] args) {
        int array[] = new int[]{32, 1, 231, 54, 83, 2, 23, 6};
        for (int i = 0; i < array.length; i++)
            for (int j = i; j < array.length; j++)
            {
                if(array[i] > array[j])
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }

        for(int i = 0;i < array.length;i++)
            System.out.println(array[i]);


    }



}
