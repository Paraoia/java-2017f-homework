/**
 * Created by cbcwe on 2017/9/22.
 */

public class Game {

    public static void main(String[] arg) {
        GourdDoll[] gourddoll = new GourdDoll[7];
        MySort my_sort = new MySort();
        for (int i = 0; i <= 6; ++i) {
            GourdDoll temp = new GourdDoll(i);
            gourddoll[i] = temp;
        }

        getRandomArray(gourddoll);
        System.out.println("随意站队：");
        showRank(gourddoll);
        my_sort.bubbleSort(gourddoll);
        System.out.println("按排行冒泡排序后：");
        showRank(gourddoll);

        getRandomArray(gourddoll);
        System.out.println("\n随意站队：");
        showColor(gourddoll);
        my_sort.quickSort(gourddoll);
        System.out.println("按颜色快速排序后：");
        showColor(gourddoll);
    }

    private static void showColor(GourdDoll[] gourdDolls) {
        for (int i = 0; i <= 6; ++i)
            gourdDolls[i].speakColor();
        System.out.print('\n');
    }

    private static void showRank(GourdDoll[] gourdDolls) {
        for (int i = 0; i <= 6; ++i)
            gourdDolls[i].speakRank();
        System.out.print('\n');
    }

    private static void getRandomArray(GourdDoll[] gourddoll) {
        // 将顺序打乱
        for (int i = 0; i <= 6; ++i) {
            int j = (int) (System.currentTimeMillis() % 7);
            GourdDoll temp = gourddoll[i];
            gourddoll[i] = gourddoll[j];
            gourddoll[j] = temp;
        }
    }
}
