public class MyHand{
    public static void main(String[] args){
        System.out.println("The Initial:");
        CalabashSort calabashSort = new CalabashSort();
        System.out.println("The Bubble Sort:");
        calabashSort.BubbleSort();
        System.out.println("After the Bubble Sort:");
        calabashSort.displayOrder(1);
        System.out.println("Randomize:");
        calabashSort.Randomize();
        calabashSort.displayOrder(0);
        System.out.println("The Quick Sort:");
        calabashSort.quickSort(0,6);
        System.out.println("After the Quick Sort:");
        calabashSort.displayOrder(2);
    }
}