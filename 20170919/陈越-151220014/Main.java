package huluwa;

public class Main {
    public static void main(String []args)
    {
        Queue huluwaqueue = new Queue(7);
        huluwaqueue.shuffle();
        System.out.println("冒泡排序——————————————————————");
      //  huluwaqueue.bubbleSort();
        new BubbleSort().sort(huluwaqueue);
        huluwaqueue.shuffle();
        System.out.println("快速排序——————————————————————");
       // huluwaqueue.quickSort();
        new QuickSort().sort(huluwaqueue);
    }
}
