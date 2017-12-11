package calabashDollSort;

/*
* 此文件包含葫芦娃的爷爷类Grandpa
* Grandpa类中包含main函数
* Grandpa类中包含藤蔓对象
*/

public class Grandpa {
    public static void main(String args[]){
        Cirrus aCirrus = new Cirrus();
        aCirrus.RandomSort();
        aCirrus.SayPos();
        aCirrus.BubbleSort();
        System.out.println("\n");

        aCirrus.RandomSort();
        aCirrus.SayPos();
        System.out.println("快速排序：");
        aCirrus.QuickSort(0,6);
        aCirrus.SayColor();
    }
}
