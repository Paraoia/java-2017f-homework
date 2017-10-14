public class Grandfather {
    public static void main(String[] args){
        Queue huluwaQueue = new Queue();
        Huluwa huluwas[] = new Huluwa[7];
        for (int i=0; i<7; i++) huluwas[i] = new Huluwa(i); // 爷爷种了七个葫芦
        huluwaQueue.randomEnqueue(huluwas);
        System.out.println("冒泡排序前："); huluwaQueue.repoName(); // 乱序报排行
        huluwaQueue.bubbleSort();
        System.out.println("冒泡排序后："); huluwaQueue.repoName(); // 有序报排行
        huluwaQueue.allDequeue();
        huluwaQueue.randomEnqueue(huluwas);
        System.out.println("快速排序前："); huluwaQueue.repoColor(); // 乱序报颜色
        huluwaQueue.quickSort(0, 6);
        System.out.println("快速排序后："); huluwaQueue.repoColor(); // 有序报颜色
    }
}
