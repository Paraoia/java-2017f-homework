public class MyHand{
    public static void main(String[] args){
        System.out.println("The Initial:");
        CalabashSort calabashSort = new CalabashSort();
        calabashSort.Randomize();
        calabashSort.displayByName();

        System.out.println("The Bubble Sort:");
        calabashSort.BubbleSort();

        System.out.println("After the Bubble Sort:");
        calabashSort.displayByName();

        System.out.println("Randomize:");
        calabashSort.Randomize();
        calabashSort.displayByName();

        System.out.println("The Quick Sort:");
        calabashSort.quickSort(0,6);

        System.out.println("After the Quick Sort:");
        calabashSort.displayByColor();
    }
}