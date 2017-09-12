/*
* @author Minhui Xie
* @date 12,09,2017
* @time 8:59 PM
*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class Hw1 {
    public static void main(String[] args) {
        Hw1 hw1=new Hw1();
        hw1.showArray(hw1.sort(new int[]{1,2,5,56,3,4,5}));
    }

    public int[] sort(int [] list) {
        Arrays.sort(list);
        return list;
    }
    public void showArray(int [] list){
        for (int it:list) {
            System.out.print(""+it+' ');
        }
    }

}