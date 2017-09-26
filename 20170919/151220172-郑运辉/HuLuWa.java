import java.lang.reflect.Array;
import java.util.Arrays;

public class HuLuWa {
    public static void main(String[] arg) {
        HuLu[] huLu = new HuLu[HuLu.TOTAL];
        Sort sort = new Sort();
        Position position = new Position();
        int[] ArrPosition;

        //冒泡排序
        System.out.println("第一次排队：");
        ArrPosition = position.setPositionByInput();
        HuLu.setPostion(huLu, ArrPosition);
        sort.BubbleSort(huLu);
        HuLu.HuLuHowlNum(huLu);

        //快速排序
        System.out.println("第二次排队：");
        ArrPosition = position.randomArray(0,HuLu.TOTAL-1,7);
        HuLu.setPostion(huLu, ArrPosition);
        sort.QSort(huLu, 0, HuLu.TOTAL - 1);
        HuLu.HuLuHowlColor(huLu);
    }
}
