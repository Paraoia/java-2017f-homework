package performance;

import character.HuLuWa;

/**
 * Created by ljkgo_000 on 2017/10/2.
 */
public class Sort {

    public static void bubbleSort(HuLuWa[] huLuWas) {
        System.out.println("Starting bubble sorting...");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if (huLuWas[j].getId() > huLuWas[j + 1].getId()) {
                    System.out.println(huLuWas[j].getName() + " : " + j + " -> " + (j + 1));
                    System.out.println(huLuWas[j + 1].getName() + " : " + (j + 1) + " -> " + j);
                    HuLuWa temp = huLuWas[j];
                    huLuWas[j] = huLuWas[j + 1];
                    huLuWas[j + 1] = temp;

                }
            }
        }
        System.out.println("Bubble sorting complete!");
    }

    public static void binarySort(HuLuWa[] huLuWas) {
        System.out.println("Starting binary sorting...");
        for(int i = 1; i < 7; i++) {
            int left = 0;
            int right = i - 1;
            int index = 0;  //index用来标注当前的第i个元素最终需要插入的位置

            // 针对第一次插入时前面的有序数组只有一个元素时的情况
            if(left == right) {
                if(huLuWas[i].getColor().compareTo(huLuWas[left].getColor()) < 0) {
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
                    if(huLuWas[i].getColor().compareTo(huLuWas[left].getColor()) < 0) {
                        index = left;
                    }
                    // a[left] < a[right] < a[i]
                    else if(huLuWas[i].getColor().compareTo(huLuWas[right].getColor()) > 0) {
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
                if(huLuWas[mid].getColor().compareTo(huLuWas[i].getColor()) < 0) {
                    left = mid;
                }
                else {
                    right = mid;
                }
            }

            //依次插入
            HuLuWa key = huLuWas[i];
            for(int j = i -1; j >= index; j--) {
                System.out.println(huLuWas[j].getName() + " : " + j + " -> " + (j + 1));
                huLuWas[j + 1] = huLuWas[j];
            }
            if(index != i){
                System.out.println(key.getName() + " : " + i + " -> " + index);
                huLuWas[index] = key;
            }
        }
        System.out.println("Binary sorting complete!");
    }
}
