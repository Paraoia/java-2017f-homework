/**
 * Created by cbcwe on 2017/9/22.
 * Edited by cbcwe on 2017/9/26
 */

public class MyQueue {
    /**
     * 模拟老爷爷和七个葫芦娃的排序队列
     */

    public static void main(String[] args){

        Grandpa grandpa;
        GourdDoll[] gourddoll;
        grandpa = new Grandpa();
        gourddoll = new GourdDoll[7];
        // 爷爷与葫芦娃的初始化
        for (int i = 0; i < 7; ++i) {
            GourdDoll temp = new GourdDoll(i);
            gourddoll[i] = temp;
        }

        // 冒泡排序
        getRandomArray(gourddoll);
        System.out.print("\n随意站队:");
        showRank(gourddoll);
        grandpa.bubbleSort(gourddoll);
        System.out.print("按排行冒泡排序后：");
        showRank(gourddoll);

        // 快速排序
        getRandomArray(gourddoll);
        System.out.print("\n\n随意站队:");
        showName(gourddoll);
        grandpa.quickSort(gourddoll);
        System.out.print("按颜色快速排序后：");
        showName(gourddoll);
    }

    // 展示葫芦娃的名字
    private static void showName(GourdDoll[] gourdDolls) {
        for (int i = 0; i <= 6; ++i)
            gourdDolls[i].speakName();
        System.out.print('\n');
    }

    // 展示葫芦娃的排行
    private static void showRank(GourdDoll[] gourdDolls) {
        for (int i = 0; i <= 6; ++i)
            gourdDolls[i].speakRank();
        System.out.print('\n');
    }

    // 为葫芦娃打乱排队顺序
    private static void getRandomArray(GourdDoll[] gourddoll) {

        for (int i = 0; i <= 6; ++i) {
            int j = (int) (System.currentTimeMillis() % 7);
            GourdDoll temp = gourddoll[i];
            gourddoll[i] = gourddoll[j];
            gourddoll[j] = temp;
        }
    }
}
