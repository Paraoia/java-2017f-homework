/**
 * Created by cbcwe on 2017/9/22.
 * Edited by cbcwe on 2017/9/26
 */
public class Grandpa {
    /**
     * 模拟爷爷指挥葫芦娃们进行两种排序（bubbleSort和quickSort）并报告交换动作(report)
     */
    public Grandpa(){
        System.out.println("爷爷诞生了");
    }

    // 报告交换动作
    private static void report(GourdDoll gourdDoll,int from , int to ){
        gourdDoll.speakName();
        System.out.println(":"+from+"->"+to);
    }

    // 快速排序的对外接口
    public void quickSort(GourdDoll[] gourddolls) {
        if (gourddolls == null)
            return;
        quickSort(gourddolls, 0, gourddolls.length - 1);
    }

    // 快速排序的内部循环
    private void quickSort(GourdDoll[] gourddolls, int begin, int end) {
        if (begin >= end || gourddolls == null)
            return;
        int p = partition(gourddolls, begin, end);
        quickSort(gourddolls, begin, p - 1);
        quickSort(gourddolls, p + 1, end);
    }

    // 快速排序的paritition部分
    private static int partition(GourdDoll[] gourddolls, int begin, int end) {
        GourdDoll first = gourddolls[begin];
        int i = begin, j = end;
        while (i < j) {
            while (gourddolls[i].getRank() <= first.getRank() && i < end) {
                i++;
            }
            while (gourddolls[j].getRank() > first.getRank() && j >= begin) {
                j--;
            }
            if (i < j) {
                report(gourddolls[i],i,j);
                report(gourddolls[j],j,i);
                GourdDoll.swap(gourddolls,i,j);
            }
        }
        if (j != begin) {
            report(gourddolls[begin],begin,j);
            report(gourddolls[j],j,begin);
            GourdDoll.swap(gourddolls,begin,j);
        }
        return j;
    }

    // 冒泡排序的对外接口
    public void bubbleSort(GourdDoll[] gourdDolls){
        for( int i = gourdDolls.length - 1  ; i > 0  ; -- i )
            for(int j = 0 ; j < i ; ++ j ){
                if( gourdDolls[j].getRank() > gourdDolls[j+1].getRank() ){
                    report(gourdDolls[j],j,j+1);
                    report(gourdDolls[j+1],j+1,j);
                    GourdDoll.swap(gourdDolls,j,j+1);
                }
            }
    }


}
