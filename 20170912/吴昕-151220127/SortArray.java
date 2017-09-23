/*
    Input an array and sort it in ascending order.
 */
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the number of integer: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Please input " + n + " integer:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // bubble sort
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        System.out.println("Result: ");
        System.out.println(Arrays.toString(arr));
    }
}
