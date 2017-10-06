package HuLuBrother;

import java.util.Random;

/**
 * Created by junkai.li on 2017/9/20.
 */

public class HuLuSort {
    static HuLuBaby[] huLuBabies = new HuLuBaby[7];

    public static void init() {
        System.out.println("Line up randomly...");
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
            huLuBabies[index] = new HuLuBaby(cnt);
            cnt++;
        }
        System.out.println("Line up complete!");
    }

    public static void bubbleSort() {
        System.out.println("Starting bubble sorting...");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if (huLuBabies[j].id > huLuBabies[j + 1].id) {
                    System.out.println(huLuBabies[j].name + " : " + j + " -> " + (j + 1));
                    System.out.println(huLuBabies[j + 1].name + " : " + (j + 1) + " -> " + j);
                    HuLuBaby temp = huLuBabies[j];
                    huLuBabies[j] = huLuBabies[j + 1];
                    huLuBabies[j + 1] = temp;

                }
            }
        }
        System.out.println("Bubble sorting complete!");
    }

    public static void binarySort() {
        System.out.println("Starting binary sorting...");
        for(int i = 1; i < 7; i++) {
            int left = 0;
            int right = i - 1;
            int index = 0;  //index用来标注当前的第i个元素最终需要插入的位置

            // 针对第一次插入时前面的有序数组只有一个元素时的情况
            if(left == right) {
                if(huLuBabies[i].color.compareTo(huLuBabies[left].color) < 0) {
                    index = left;
                }
                else {
                    index = right + 1;
                }
            }

            while(left < right) {
                //当当前范围仅有两个数即a[left]和a[right]时，可以插入a[i]
                if(left + 1 == right) {
                    // a[i] < a[left] < a[right]
                    if(huLuBabies[i].color.compareTo(huLuBabies[left].color) < 0) {
                        index = left;
                    }
                    // a[left] < a[right] < a[i]
                    else if(huLuBabies[i].color.compareTo(huLuBabies[right].color) > 0) {
                        index = right + 1;
                    }
                    // a[left] < a[i] < a[right]
                    else {
                        index = right;
                    }
                    break;
                }

                //二分法寻找新的left/right，以此来缩小范围
                int mid = (left + right) / 2;
                if(huLuBabies[mid].color.compareTo(huLuBabies[i].color) < 0) {
                    left = mid;
                }
                else {
                    right = mid;
                }
            }

            //依次插入
            HuLuBaby key = huLuBabies[i];
            for(int j = i -1; j >= index; j--) {
                System.out.println(huLuBabies[j].name + " : " + j + " -> " + (j + 1));
                huLuBabies[j + 1] = huLuBabies[j];
            }
            if(index != i){
                System.out.println(key.name + " : " + i + " -> " + index);
                huLuBabies[index] = key;
            }
        }
        System.out.println("Binary sorting complete!");
    }

    public static void print() {
//        for(int i = 0; i < 7; i++) {
//            System.out.println(huLuBabies[i].id + " " + huLuBabies[i].color + " " + huLuBabies[i].name);
//        }
        System.out.print("The present situation : ");
        for(int i = 0; i < 7; i++) {
            System.out.print(huLuBabies[i].id + " " );
        }
        System.out.print("\n\n");
    }

    public static void main(String[] args) {
        HuLuSort huLuSort = new HuLuSort();

        huLuSort.init();
        huLuSort.print();
        huLuSort.bubbleSort();
        huLuSort.print();

        huLuSort.init();
        huLuSort.print();
        huLuSort.binarySort();
        huLuSort.print();
    }
}
