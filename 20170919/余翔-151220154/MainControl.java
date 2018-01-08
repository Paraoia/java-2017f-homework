import java.util.*;

public class MainControl {
    public static void main(String[] args){

        //冒泡排序并报数
        HuluBrothers huluwas = new HuluBrothers();
        huluwas.UseBubbleSort();
        huluwas.TellNumber();

        //快速排序并报数
        huluwas = new HuluBrothers();
        huluwas.UseQuickSort();
        huluwas.TellColor();
    }
}

