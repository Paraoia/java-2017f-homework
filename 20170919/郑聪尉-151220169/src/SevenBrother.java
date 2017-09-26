/**
 * This class defines Huluwas.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SevenBrother {
    private Huluwa[] Huluwas;
    public static void main(String[] args) {
        SevenBrother test = new SevenBrother();
        test.process();
    }
    public void process(){
        initial();

        randomStandInLine();
        System.out.print("-------------\n Bubble Sort\n-------------\n");
        myBubbleSort();
        System.out.print("-------------\n  Count Off\n-------------\n");
        for(int i=0;i<7;i++) {
            System.out.print("NO." + (i+1) + "\t");
            Huluwas[i].countOff(0);
        }

        randomStandInLine();
        System.out.print("\n\n-------------\n Quick Sort\n-------------\n");
        myQuickSort(Huluwas, 0, 6);
        System.out.print("-------------\n  Count Off\n-------------\n");
        for(int i=0;i<7;i++) {
            System.out.print("NO." + (i+1) + "\t");
            Huluwas[i].countOff(0);
        }
    }
    public void initial(){
        Huluwas = new Huluwa[7];
        Huluwas[0] = new Huluwa(Global.NAME.Dawa,   Global.COLOR.Chi,   1);
        Huluwas[1] = new Huluwa(Global.NAME.Erwa,   Global.COLOR.Cheng, 2);
        Huluwas[2] = new Huluwa(Global.NAME.Sanwa,  Global.COLOR.Huang, 3);
        Huluwas[3] = new Huluwa(Global.NAME.Siwa,   Global.COLOR.Lv,    4);
        Huluwas[4] = new Huluwa(Global.NAME.Wuwa,   Global.COLOR.Qing,  5);
        Huluwas[5] = new Huluwa(Global.NAME.Liuwa,  Global.COLOR.Lan,   6);
        Huluwas[6] = new Huluwa(Global.NAME.Qiwa,   Global.COLOR.Zi,    7);
    }
    public void randomStandInLine(){
        List<Huluwa> list = Arrays.asList(Huluwas);
        Collections.shuffle(list);
    }
    public void myBubbleSort(){
        for(int i=0;i<7;i++){
            for(int j=0;j<7-i-1;j++){
                if(Huluwas[j].getPosition()>Huluwas[j+1].getPosition()){
                    Huluwas[j].jumpFromTo(j+1, j+2);
                    Huluwas[j+1].jumpFromTo(j+2, j+1);
                    Huluwa temp = Huluwas[j];
                    Huluwas[j] = Huluwas[j+1];
                    Huluwas[j+1] = temp;
                }
            }
        }
    }
    public void myQuickSort(Huluwa[] array, int left, int right){
        if (left < right) {
            int i = left, j = right;
            Huluwa m = array[left];
            while (i < j) {
                while(i < j && array[j].getPosition() >= m.getPosition()) j--;
                if(i < j){
                    Huluwas[j].jumpFromTo(j+1, i+1);
                    array[i++] = array[j];
                }
                while(i < j && array[i].getPosition() < m.getPosition()) i++;
                if(i < j){
                    Huluwas[i].jumpFromTo(i+1, j+1);
                    array[j--] = array[i];
                }
            }
            if(left!=i) m.jumpFromTo(left+1, i+1);
            array[i] = m;
            myQuickSort(array, left, i - 1);
            myQuickSort(array, i + 1, right);
        }
    }
}
