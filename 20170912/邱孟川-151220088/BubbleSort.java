public class BubbleSort {
    public static void main(String[] args){
        final int SIZE = 11;
        int []array = {8, 3, 9, 10, 1, 2, 3, 4, 5, 6, 7};

        for(int i = SIZE-1; i > 0; --i){
            for(int j = SIZE-1; j >= SIZE-i; --j){
                if(array[j] > array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }

        for(int i = 0; i < SIZE; ++i)
            System.out.printf("%d ", array[i]);
    }
}
