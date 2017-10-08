//package nju.java2017;
/*Largest and Smallest Number in an Array Example
  This Java Example shows how to find largest and smallest number in an
  array.
*/
import java.util.Arrays;
import java.util.*;

public class ArraySort{
        public static void main(String[] args) {
                //array of 10 numbers
                int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};

                Arrays.sort(numbers);

                for(int i : numbers)
                        System.out.print(i + " ");

                System.out.println();
        }
}