import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class defines CalabashBrothers which could sort the Calabash Brothers.
 */

public class CalabashBrothers {
    private CalabashBrother[] calabashBrothers;

    public void main(){
        initial();

        System.out.println("Now Begin!\nNO.1");
        randomStandInLine();
        System.out.println("Now Sorting!");
        myBubbleSort();
        System.out.println("Over!");
        countOff(0);

        System.out.println("\nNO.2");
        randomStandInLine();
        System.out.println("Sorting Now!");
        myQuickSort(calabashBrothers, 0, 6);
        System.out.println("Over!");
        countOff(1);
    }
    public void initial(){
        calabashBrothers = new CalabashBrother[7];
        calabashBrothers[0] = new CalabashBrother("大娃","Red",1);
        calabashBrothers[1] = new CalabashBrother("二娃","Orange",2);
        calabashBrothers[2] = new CalabashBrother("三娃","Yellow",3);
        calabashBrothers[3] = new CalabashBrother("四娃","Green",4);
        calabashBrothers[4] = new CalabashBrother("五娃","Blue",5);
        calabashBrothers[5] = new CalabashBrother("六娃","Indigo",6);
        calabashBrothers[6] = new CalabashBrother("七娃","Purple",7);
    }
    public void randomStandInLine(){
        List<CalabashBrother> list = Arrays.asList(calabashBrothers);
        Collections.shuffle(list);
    }
    public void countOff(int kind){
        for(CalabashBrother i:calabashBrothers){
            if(0==kind)
                System.out.println(i.getName());
            else if(1==kind)
                System.out.println(i.getColor());
        }
    }
    public void myBubbleSort(){
        for(int i=0;i<7;i++){
            for(int j=0;j<7-i-1;j++){
                if(calabashBrothers[j].getSeniority()>calabashBrothers[j+1].getSeniority()){
                    System.out.println(calabashBrothers[j].getName() + ":" + (j+1) + "->" + (j+2));
                    System.out.println(calabashBrothers[j+1].getName() + ":" + + (j+2) + "->" + (j+1));
                    CalabashBrother temp = calabashBrothers[j];
                    calabashBrothers[j] = calabashBrothers[j+1];
                    calabashBrothers[j+1] = temp;
                }
            }
        }
    }
    public void myQuickSort(CalabashBrother[] array, int left, int right){
        if (left < right)
        {
            int i = left, j = right;
            CalabashBrother m = array[left];
            while (i < j)
            {
                while(i < j && array[j].getSeniority() >= m.getSeniority()) j--;
                if(i < j){
                    System.out.println(calabashBrothers[j].getName() + ":" + (j+1) + "->" + (i+1));
                    array[i++] = array[j];
                }
                while(i < j && array[i].getSeniority() < m.getSeniority()) i++;
                if(i < j){
                    System.out.println(calabashBrothers[i].getName() + ":" + (i+1) + "->" + (j+1));
                    array[j--] = array[i];
                }
            }
            if(left!=i)
                System.out.println(m.getName() + ":" + (left+1) + "->" + (i+1));
            array[i] = m;
            myQuickSort(array, left, i - 1);
            myQuickSort(array, i + 1, right);
        }
    }
}
