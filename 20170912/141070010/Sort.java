import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2017/9/19.
 */
public class Sort {
    public static void main(String[] args) {
        final int N=20;
        int[] numbers=new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        System.out.println("Before sorting,the array is: ");
        for (int i = 0; i < N; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        Arrays.sort(numbers);
        System.out.println("After sorting,the array is: ");
        for (int i = 0; i < N; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
