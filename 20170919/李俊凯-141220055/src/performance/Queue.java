package performance;

import character.HuLuWa;

import java.util.Random;
/**
 * Created by ljkgo_000 on 2017/10/2.
 */
public class Queue {
    public static HuLuWa[] huLuWas = new HuLuWa[7];

    public static void randomQueue() {
        System.out.println("随意站队中...");
        int[] flag = new int[7];
        for(int i = 0; i < 7; i++) {
            flag[i] = -1;
        }
        int cnt = 1;
        while(cnt < 8) {
            int index = new Random().nextInt(7);
            while(flag[index] != -1) {
                index = new Random().nextInt(7);
            }
            flag[index] = 0;
            huLuWas[index] = new HuLuWa(cnt);
            cnt++;
        }
        System.out.println("站队完毕!");
    }

    public static void printQueue() {
//        for(int i = 0; i < 7; i++) {
//            System.out.println(huLuBabies[i].id + " " + huLuBabies[i].color + " " + huLuBabies[i].name);
//        }
        System.out.print("目前的顺序是 : ");
        for(int i = 0; i < 7; i++) {
            System.out.print(huLuWas[i].getId()+ " " );
        }
        System.out.print("\n\n");
    }
    public static void main(String[] args) {
        Queue huLuQueue = new Queue();

        huLuQueue.randomQueue();
        huLuQueue.printQueue();
        Sort.bubbleSort(huLuQueue.huLuWas);
        huLuQueue.printQueue();

        huLuQueue.randomQueue();
        huLuQueue.printQueue();
        Sort.binarySort(huLuQueue.huLuWas);
        huLuQueue.printQueue();
    }
}
