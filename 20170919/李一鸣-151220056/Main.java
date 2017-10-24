public class Main {
    public static void main (String[] args) {
        Operation baby = new Operation();



        baby.randomQueue();
        baby.display(1);
        baby.BubbleSort();
        baby.display(1);

        System.out.println();

        baby.randomQueue();
        baby.display(2);
        baby.QuickSort();

        System.out.println();
        baby.display(2);
    }
}

