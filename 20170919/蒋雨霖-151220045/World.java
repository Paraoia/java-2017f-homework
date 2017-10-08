public class World {
    public static void main(String []args)
    {
        Brothers bro =new Brothers();
        Sort sort = new Sort();
        /* 随意站队 */
        bro.RandomQueue();
        System.out.println("冒泡排序前的站队：");
        bro.PrintRank();//按辈分输出
        sort.BubbleSort(bro);
        System.out.println("冒泡排序后的站队");
        bro.PrintRank();
        /*重新随意站队*/
        bro.RandomQueue();
        System.out.println("快速排序前的站队：");
        bro.PrintColor();//按颜色输出
        sort.QuickSort(bro,0,6);
        System.out.println("快速排序后的站队：");
        bro.PrintColor();
    }
}
