public class Grandfa {
    public static void main(String[] args){
        Queue brothers = new Queue();

        brothers.reset();
        //brothers.show();
        brothers.bubblesort();
        brothers.show();

        brothers.reset();
        //brothers.show();
        brothers.quicksort();
        brothers.show();
    }
}
