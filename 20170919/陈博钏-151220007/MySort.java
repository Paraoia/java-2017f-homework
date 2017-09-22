/**
 * Created by cbcwe on 2017/9/22.
 */
public class MySort {
    private static void report(GourdDoll gourdDoll,int from , int to ){
        switch(gourdDoll.value){
            case 0:
                System.out.print("老大 ");
                break;
            case 1:
                System.out.print("老二 ");
                break;
            case 2:
                System.out.print("老三 ");
                break;
            case 3:
                System.out.print("老四 ");
                break;
            case 4:
                System.out.print("老五 ");
                break;
            case 5:
                System.out.print("老六 ");
                break;
            case 6:
                System.out.print("老七 ");
                break;
            default:
                System.out.print("爷爷什么时候多摘了个葫芦？ ");
        }
        System.out.println(":"+from+"->"+to);
    }

    private static int partition(GourdDoll[] gourddolls, int begin, int end) {
        GourdDoll first = gourddolls[begin];
        int i = begin, j = end;
        while (i < j) {
            while (gourddolls[i].value <= first.value && i < end) {
                i++;
            }
            while (gourddolls[j].value > first.value && j >= begin) {
                j--;
            }
            if (i < j) {
                report(gourddolls[i],i,j);
                report(gourddolls[j],j,i);
                GourdDoll temp = gourddolls[i];
                gourddolls[i] = gourddolls[j];
                gourddolls[j] = temp;
            }
        }
        if (j != begin) {
            report(gourddolls[begin],begin,j);
            report(gourddolls[j],j,begin);
            GourdDoll temp = gourddolls[begin];
            gourddolls[begin] = gourddolls[j];
            gourddolls[j] = temp;
        }
        return j;
    }

    public void quickSort(GourdDoll[] gourddolls) {
        if (gourddolls == null)
            return;
        quickSort(gourddolls, 0, gourddolls.length - 1);
    }

    public void quickSort(GourdDoll[] gourddolls, int begin, int end) {
        if (begin >= end || gourddolls == null)
            return;
        int p = partition(gourddolls, begin, end);
        quickSort(gourddolls, begin, p - 1);
        quickSort(gourddolls, p + 1, end);
    }

    public void bubbleSort(GourdDoll[] gourdDolls){
        for( int i = gourdDolls.length - 1  ; i > 0  ; -- i )
            for(int j = 0 ; j < i ; ++ j ){
                if( gourdDolls[j].value > gourdDolls[j+1].value ){
                    report(gourdDolls[j],j,j+1);
                    report(gourdDolls[j+1],j+1,j);
                    GourdDoll temp = gourdDolls[i];
                    gourdDolls[i] = gourdDolls[j];
                    gourdDolls[j] = temp;
                }
            }
    }


}
