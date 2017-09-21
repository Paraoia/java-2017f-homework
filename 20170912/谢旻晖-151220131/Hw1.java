/*
* @author Minhui Xie
* @date 12,09,2017
* @time 8:59 PM
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hw1 {
    public static void main(String[] args) {
        Hw1 hw1 = new Hw1();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        System.out.println(list);
    }

}