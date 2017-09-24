/**
 * Created by rajesh on 17-9-18.
 */
public class Array {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};

        for(int i = 0;i < numbers.length - 1;i++) {
            for(int j = 0;j <= i;j++) {
                if(numbers[i+1] < numbers[j]) {
                    int tmp = numbers[i+1];
                    for(int k = i;k >= j;k--)
                        numbers[k+1] = numbers[k];
                    numbers[j] = tmp;
                    break;
                }
            }
        }
        for(int i = 0;i < numbers.length;i++)
            System.out.print(numbers[i] + " ");
        System.out.println();
    }
}
