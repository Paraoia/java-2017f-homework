import java.util.*;

public class Main {

    public static void main(String[] args) {
        /**
         * implement a bubble sorting algorithm
         * sort the giving array from small to large and output
         */

        int array[] = new int[]{
                2,5,0,9,8,1,6,3,7,4
        };

        Main.printIntArray(array);

        array = Main.bubbleSort(array);

        Main.printIntArray(array);
    }


    private static int[] bubbleSort(int array[]){

        int len = array.length;

        for(int i = 0 ; i < len - 1 ; ++ i)
            for( int j = len - 1 ; j > i  ; -- j){
                if( array[j] < array[j-1] ) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        return array;
    }

    private static void printIntArray(int array[]){
        System.out.println("");
        for( int i = 0 ; i < array.length ; ++ i )
            System.out.print(array[i]+" ");
        System.out.print('\n');
    }
}
