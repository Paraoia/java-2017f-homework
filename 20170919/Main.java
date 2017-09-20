/**
 * Created by tangruize on 17-9-20.
 */
public class Main {
    public static void main(String[] args) {
        FuluwaSort sort = new FuluwaSort();
        Fuluwa []wa = new Fuluwa[7];
        for (int i = 0; i < 7; ++i) {
            wa[i] = new Fuluwa();
        }
        //Step 1: bubbleSort
        sort.bubbleSort(wa);
        for (int i = 0; i < 7; ++i) {
            System.out.println(wa[i].getName());
        }
        //go home, fuluwa
        for (int i = 0; i < 7; ++i) {
            wa[i].goHome();
        }
        //come out, fuluwa!
        for (int i = 0; i < 7; ++i) {
            wa[i] = new Fuluwa();
        }
        //Step 2: binarySearch
        sort.quickSort(wa);
        for (int i = 0; i < 7; ++i) {
            System.out.println(wa[i].getColor());
        }
    }
}
