public class Sort {
    public static void main(String[] args) {
        int array[] = new int[] {32,43,53,54,32,65,63,98,43,23};
        for(int i = 0; i < array.length; ++i)
            for(int j = 1; j < array.length; ++j)
                if(array[j - 1] > array[j])
                {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
        for(int i : array)
            System.out.println(i);
    }
}