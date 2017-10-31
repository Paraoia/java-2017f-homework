package Homework2;

public class Homework2 {
    public static void main(String[] args) {
        System.out.println("初始化");
        CalabashBrothers brothers = new CalabashBrothers();
        System.out.println("随机排列");
        brothers.randomArrange();
        System.out.println("冒泡排序");
        brothers.bubbleSort();
        System.out.println("随机排列");
        brothers.randomArrange();
        System.out.println("快速排序");
        brothers.quickSort();
    }
}
