/**
 * Created by admin on 2017/9/13.
 */
public class selectedSort {
    public static void main(String[] args) {
        int array[] = {3,2,4,14,13,6,7,8,9,130};
        for(int i=0;i < array.length;i++) {
            int min = Integer.MAX_VALUE;
            int index = i;
            for (int j = i; j < array.length; j++) {
                if(min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            int tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
        for(int i=0;i < array.length;i++)
            System.out.println(array[i]);
    }
}
