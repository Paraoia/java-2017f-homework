package lyl.java.huluwa;

import java.util.Random;

public class HuluWaSort {
    static int MAX = 7;
    HuLu[] huLuWa = {
            new HuLu("大娃", "红色"),
            new HuLu("二娃", "橙色"),
            new HuLu("三娃", "黄色"),
            new HuLu("四娃", "绿色"),
            new HuLu("五娃", "青色"),
            new HuLu("六娃", "蓝色"),
            new HuLu("七娃", "紫色")
    };

    //小葫芦依次报数
    void allReportNumber(){
        for(int i=0; i < MAX; i++) {
            huLuWa[i].reportNumber();
            System.out.print(" ");
        }
        System.out.println();
    }

    //小葫芦依次报颜色
    void allReportColor(){
        for(int i=0; i < 7; i++) {
            huLuWa[i].reportColor();
            System.out.print(" ");
        }
        System.out.println();
    }

    //交换下标为i和j的葫芦娃
    void swap(int i, int j) {
        HuLu tmp;
        tmp = huLuWa[j];
        huLuWa[j] = huLuWa[i];
        huLuWa[i] = tmp;
    }

    //随机打乱葫芦兄弟
    void randomOrder() {
        Random random = new Random();
        int j;
        for(int i=0; i < 7; i++){
            j = random.nextInt(6) % 7;  //产生0-6之间随机数
            if(i != j) swap(i, j);
        }
    }

    //根据排行进行冒泡排序
    void bubbleSort() {
        for(int i=0; i < 6; i++)
            for(int j=0; j < 6-i; j++)
                if(huLuWa[j].compareNumberTo(huLuWa[j+1]) > 0 ) {
                    huLuWa[j].reportNumber();
                    System.out.println(": " + (j+1) + "->" + (j+2));
                    swap(j, j + 1);
                }
    }

    //根据颜色进行二分排序
    void binarySort() {
        int i, j;
        int high, low, mid;
        HuLu tmp;
        for (i = 1; i < 7; i++) {
            low = 0;
            high = i - 1;
            tmp = huLuWa[i];
            while (low <= high) {
                mid = (low + high) >> 1;
                if (huLuWa[mid].compareColorTo(tmp) > 0 ) {
                    high = mid - 1;
                 } else {
                    low = mid + 1;
                }
             }
            for (j = i - 1; j >= low; j--) {
                huLuWa[j].reportNumber();
                System.out.println(": " + (j+1) + "->" + (j+2));
                huLuWa[j + 1] = huLuWa[j];
            }

            tmp.reportNumber();
            System.out.println(": " + (i+1) + "->" + (low+1));
            huLuWa[low] = tmp;
    }
  }


    public static void main(String[] args) {
        HuluWaSort huLuWa = new HuluWaSort();

        huLuWa.randomOrder();
     //   huLuWa.allReportNumber();

        huLuWa.bubbleSort();
        huLuWa.allReportNumber();

        huLuWa.randomOrder();
     //   huLuWa.allReportColor();

        huLuWa.binarySort();
        huLuWa.allReportColor();

    }

}
