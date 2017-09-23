public class Main {

    public static void main(String[] args) {
	// write your code here
        Hulubros h = new Hulubros();
        h.printName();
        Sort s = new Sort();
        s.bubbleSort(h);
        h.printName();
        h.printColor();
        h.shuffle();
        h.printName();
        s.quickSort(h);
        h.printName();
    }
}
