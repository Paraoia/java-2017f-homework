import java.util.*;

class Huluwa{
    int NO, color;
    // 构造葫芦娃
    public Huluwa(int who) {
        if (who<0 || who>6){
            System.out.println("查无此娃!");
        }
        else{
            NO = who; color = who;
        }
    }
    // 报排行
    public void repoNO(){
        switch(NO){
            case 0: System.out.print("大娃 "); break;
            case 1: System.out.print("二娃 "); break;
            case 2: System.out.print("三娃 "); break;
            case 3: System.out.print("四娃 "); break;
            case 4: System.out.print("五娃 "); break;
            case 5: System.out.print("六娃 "); break;
            case 6: System.out.print("七娃 "); break;
        }
    }
    // 报颜色
    public void repoColor(){
        switch(color){
            case 0: System.out.print("红色 "); break;
            case 1: System.out.print("橙色 "); break;
            case 2: System.out.print("黄色 "); break;
            case 3: System.out.print("绿色 "); break;
            case 4: System.out.print("青色 "); break;
            case 5: System.out.print("蓝色 "); break;
            case 6: System.out.print("紫色 "); break;
        }
    }
}

class HuluwaQueue{
    Huluwa[] queue;
    // 构造函数
    public HuluwaQueue(){
        queue = new Huluwa[7];
        for (int i=0; i<7; i++){
            Huluwa tmpHuluwa = new Huluwa(i);
            queue[i] = tmpHuluwa;
        }
    }
    // 随机站队
    public void randomOrder(){
        int count = 0;
        while (count<7) {
            int curRandom = new Random().nextInt(7);
            boolean legalRandom = true;
            for (int i=0; i<count; i++){
                if (queue[i].NO == curRandom){
                    legalRandom = false;
                    break;
                }
            }
            if (legalRandom){
                queue[count].NO=curRandom; queue[count].color=curRandom; count++;
            }
        }
    }
    // 让所有娃报排行
    public void repoNO(){
        for (int i=0; i<7; i++) queue[i].repoNO();
        System.out.print("\n");
    }
    // 让所有娃报颜色
    public void repoColor(){
        for (int i=0; i<7; i++) queue[i].repoColor();
        System.out.print("\n");
    }
    // 根据排行冒泡排序 & 报告交换动作
    // 位置信息从1开始记
    public void bubbleSort(){
        for(int outIndex=0; outIndex<6; outIndex++) {
            boolean exchangeHappened = false;
            for (int inIndex = 0; inIndex < 6 - outIndex; inIndex++) {
                if (queue[inIndex].NO > queue[inIndex + 1].NO) {
                    queue[inIndex].repoNO(); System.out.print("：" + (inIndex+1) + "->" + (inIndex+2) + " ");
                    queue[inIndex+1].repoNO(); System.out.print("：" + (inIndex+2) + "->" + (inIndex+1) + " ");
                    exchangeHappened = true;
                    Huluwa tmpHuluwa = queue[inIndex];
                    queue[inIndex] = queue[inIndex + 1];
                    queue[inIndex + 1] = tmpHuluwa;
                }
            }
            if (!exchangeHappened) {
                break;
            } else{
                System.out.print("\n");
            }
        }
    }
    // 根据颜色快速排序 & 报告交换动作
    // 位置信息从1开始记
    private int split(int left, int right) {
        int i = left;
        int j = right;
        queue[i].repoColor();  System.out.print("：" + (i+1) + "->" + "OutOfQueue ");
        Huluwa tmpHuluwa = queue[i];
        while (i<j)
        {
            while (i<j && queue[j].NO >= tmpHuluwa.NO)
                j--;
            if (i<j) {
                queue[j].repoColor();  System.out.print("：" + (j+1) + "->" + (i+1) + " ");
                queue[i] = queue[j];
            }
            while (i<j && queue[i].NO <= tmpHuluwa.NO)
                i++;
            if (i<j){
                queue[i].repoColor();  System.out.print("：" + (i+1) + "->" + (j+1) + " ");
                queue[j] = queue[i];
            }
        }
        tmpHuluwa.repoColor();  System.out.print("：OutOfQueue -> " + (i+1) + "\n");
        queue[i] = tmpHuluwa;
        return i;
    }
    public void quickSort(int left, int right){
        int pivot;
        if (left<right)
        {
            pivot = split(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }
}

public class HuluwaProj {
    public static void main(String[] args){
        HuluwaQueue huluwaQueue = new HuluwaQueue();
        huluwaQueue.randomOrder(); // 随机站队
        System.out.println("冒泡排序前：");
        huluwaQueue.repoNO(); // 乱序报排行
        huluwaQueue.bubbleSort();
        System.out.println("冒泡排序后：");
        huluwaQueue.repoNO(); // 有序报排行
        System.out.println("快速排序前：");
        huluwaQueue.randomOrder(); // 随机站队
        huluwaQueue.repoColor(); // 乱序报颜色
        huluwaQueue.quickSort(0, 6);
        System.out.println("快速排序后：");
        huluwaQueue.repoColor(); // 有序报颜色
    }
}
