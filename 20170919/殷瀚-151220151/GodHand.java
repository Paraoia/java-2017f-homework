/*上帝之手，这是该程序的入口，给葫芦娃们进行两次排序*/
public class GodHand {
    public static void main(String[] args){
        /*根据排行，冒泡排序*/
        System.out.println("第一次排序");
        bubbleSorter bubbleSortByName = new bubbleSorter();
        bubbleSortByName.main();

        /*根据颜色，快速排序*/
        System.out.println("第二次排序");
        quickSorter quickSortByColor = new quickSorter();
        quickSortByColor.main();
    }
}
