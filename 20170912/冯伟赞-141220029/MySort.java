import java.util.Arrays;

/**
 * Created by fwz on 2017/9/18.
 */
public class MySort {
    public static void main(String[] args) {
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        Arrays.sort(numbers);
        for (int i : numbers) {
            System.out.println(i);
        }
    }
}
