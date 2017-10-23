import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static java.util.Collections.swap;

public class GourdEvaQueue {
    static List<GourdEva> gourdEvaList=new ArrayList<GourdEva>();

    //随机站队
    public void randSetPosition(){
        Random random=new Random();
        for (int i=6;i>=0;i--){
            int j=random.nextInt(i+1);
            swap(gourdEvaList,i,j);
        }
        for(int i=0;i<7;i++){
            gourdEvaList.get(i).setPosition(i);
        }
    }
    public void buddleSort(){
        for (int i=0;i<7;i++)
            for(int j=6;j>i;j--) {
                if (gourdEvaList.get(j).ageBiggerThan(gourdEvaList.get(j-1))) {
                    gourdEvaList.get(j).goToPosition(j-1);
                    gourdEvaList.get(j-1).goToPosition(j);
                    swap(gourdEvaList,j,j-1);
                }
            }
    }
    public int partition(List<GourdEva> troop, int low, int high) {
        GourdEva key = troop.get(low);
        while(low < high) {
            while (low < high && key.colorSmallerThan(troop.get(high))) {
                high--;
            }
            key.goToPosition(high);
            troop.get(high).goToPosition(low);
            swap(gourdEvaList, low, high);
            while (low < high && troop.get(low).colorSmallerThan(key)) {
                low++;
            }
            key.goToPosition(low);
            troop.get(low).goToPosition(high);
            swap(gourdEvaList, low, high);
        }
        return low;
    }
    public void quickSort(int low, int high) {
        if(low < high) {
            int result = partition(gourdEvaList,low, high);
            quickSort(low, result-1);//对low到result-1下标间数进行排序
            quickSort(result+1, high);//对result+1到high下标间数进行排序
        }
        return;
    }
    public void countOffAge(){
        for(int i=0;i<7;i++)
            gourdEvaList.get(i).countOffAge();
        System.out.println();
    }
    public void countOffColor(){
        for (int i=0;i<7;i++)
            gourdEvaList.get(i).countOffColor();
        System.out.println();
    }
}
