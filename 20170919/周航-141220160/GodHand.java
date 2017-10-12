import sun.reflect.generics.tree.BottomSignature;

public class GodHand {
    public static void main(String[] args){
        Queue huluQueue=new Queue();

        System.out.print("随机排列后,");
        huluQueue.randomQ();
        huluQueue.printName();
        //冒泡排序
        System.out.println("冒泡排序：");
        huluQueue.bubbleSort();
        huluQueue.printName();
        //随机站队
        System.out.print("随机排列后,");
        huluQueue.randomQ();
        huluQueue.printName();
        //快速排序
        System.out.println("快速排序：");
        huluQueue.quickSort(0,6);
        System.out.println(" ");
        huluQueue.printColor();
    }
}
