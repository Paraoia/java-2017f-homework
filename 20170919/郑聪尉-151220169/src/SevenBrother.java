/**
 * This class defines Huluwas.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SevenBrother {
    private Huluwa[] Huluwas;
    public static void main(String[] args) {
        SevenBrother example = new SevenBrother();
        example.process();
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
        System.out.print("\n-------------\n Quick Sort\n-------------\n");
        myQuickSort(Huluwas, 0, 6);
        System.out.print("-------------\n  Count Off\n-------------\n");
        for(int i=0;i<7;i++) {
            System.out.print("NO." + (i+1) + "\t");
            Huluwas[i].countOff(1);
        }
    }
    public void initial(){
        Huluwas = new Huluwa[7];
        for(int i=0;i<7;i++){
            Huluwas[i] = new Huluwa(Global.NAME[i],Global.COLOR[i],i+1);
        }
    }
    public void randomStandInLine(){
        List<Huluwa> myList = Arrays.asList(Huluwas);
        Collections.shuffle(myList);
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
            Huluwa middle = array[left];
            while (i < j) {
                while(i < j && array[j].getPosition() >= middle.getPosition()) j--;
                if(i < j){
                    Huluwas[j].jumpFromTo(j+1, i+1);
                    array[i++] = array[j];
                }
                while(i < j && array[i].getPosition() < middle.getPosition()) i++;
                if(i < j){
                    Huluwas[i].jumpFromTo(i+1, j+1);
                    array[j--] = array[i];
                }
            }
            if(left!=i) middle.jumpFromTo(left+1, i+1);
            array[i] = middle;
            myQuickSort(array, left, i - 1);
            myQuickSort(array, i + 1, right);
        }
    }
}
