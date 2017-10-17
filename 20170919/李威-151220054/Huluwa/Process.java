package Huluwa;

public class Process {
    public static void main(String []args){

        HuLuWa huluwa[]=new HuLuWa[7];
        for(int i=1;i<8;i++)
            huluwa[i-1]=new HuLuWa(i);

        Queue queue=new Queue();
        queue.initQueue(huluwa);
        System.out.println("葫芦兄弟随机初序列为:");
        queue.reportName();
        System.out.println("下面开始冒泡排序");
        queue.bubbleSort();
        System.out.println("经过冒泡排序之后...");
        queue.reportName();

        System.out.println();

        queue.initQueue(huluwa);
        System.out.println("葫芦兄弟随机初序列为:");
        queue.reportColor();
        System.out.println("下面开始快速排序");
        queue.quickSort(0,6);
        System.out.println("经过快速排序之后...");
        queue.reportColor();


    }
}
