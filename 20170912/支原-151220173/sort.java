public class sort {
    public static void main(String[ ] args) {
        int array[] = new int[]{5, 4, 3, 1, 2, 10, 11, 18};
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

    }
}