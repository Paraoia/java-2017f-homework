import sun.reflect.generics.tree.BottomSignature;

public class GodHand {
    public static void main(String[] args){
        HuluSort hulu=new HuluSort();

        //初始化
       // System.out.println("随机排列前：");
        hulu.init();
        //hulu.printName();
        //随机站队
        System.out.print("随机排列后,");
        hulu.randomQ();
        hulu.printName();
        //冒泡排序
        System.out.println("冒泡排序：");
        hulu.bubbleSort();
        hulu.printName();
        //随机站队
        System.out.print("随机排列后,");
        hulu.randomQ();
        hulu.printName();
        //快速排序
        System.out.println("快速排序：");
        hulu.quickSort(0,6);
        System.out.println(" ");
        hulu.printColor();
    }
}
