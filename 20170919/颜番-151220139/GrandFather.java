package FancyYan.HuluSort;

/**
 * 包含main函数，排序动作的执行者
 */
public class GrandFather {
    public static void main(String args[]){
        Cane HuluCane = new Cane();

        System.out.println("初始顺序为：");
        HuluCane.reportPosRank();
        System.out.println("冒泡排序开始：");
        HuluCane.bubbleSort();
        System.out.println("冒泡排序后顺序为：");
        HuluCane.reportPosRank();

        System.out.println("重置顺序为：");
        HuluCane.RandomSetPos();
        HuluCane.reportPosRank();

        System.out.println("快速排序：");
        HuluCane.quickSort(0, 6);
        System.out.println("快速排序结束，顺序为：");
        HuluCane.reportPosColor();
    }
}
