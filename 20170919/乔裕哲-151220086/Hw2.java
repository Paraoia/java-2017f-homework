
public class Hw2 {
    public static void main(String []args){

        HuluBrothers hulubrothers = new HuluBrothers();//天地之初，有7个葫芦娃，为了拯救即将废弃的爷爷小屋，毅然决定成为偶像，组成葫芦兄弟

        //开始表演
        hulubrothers.shuffle();
        System.out.println("排序前：");
        hulubrothers.printAllName();
        System.out.println("开始冒泡排序：");
        hulubrothers.bubbleSort();
        System.out.println("排序后：");
        hulubrothers.printAllName();

        hulubrothers.shuffle();
        System.out.println("打乱后：");
        hulubrothers.printAllName();
        System.out.println("开始快速排序");
        hulubrothers.quickSort(0, hulubrothers.getNumber() - 1);
        System.out.println("排序后：");
        hulubrothers.printAllColor();
    }
}



