import java.lang.reflect.Array;
import java.util.Arrays;

public class HuLuWa {
    public static void main(String[] arg) {
        HuLu[] huLu = new HuLu[HuLu.Sum];
        Sort sort = new Sort();
        Position position = new Position();
        int[] ArrPosition;

        //冒泡排序
        System.out.println("第一次排队：");
        ArrPosition = position.setPositionByInput();
        HuLu.setPostion(huLu, ArrPosition);
        sort.BubbleSort(huLu);
        HuLu.HuLuprint(huLu);

        //二分排序
        System.out.println("第二次排队：");
        ArrPosition = position.randomArray(0,HuLu.Sum-1,7);
        //System.out.println(Arrays.toString(ArrPosition));
        HuLu.setPostion(huLu, ArrPosition);
        sort.QSort(huLu, 0, HuLu.Sum - 1);
        HuLu.HuLuprint(huLu);
    }
}
