
public class CalabashMountain {

    public static void main(String[] args){
        CalabashBoy []boys = new CalabashBoy[7];
        Grandfather grandfather = new Grandfather();

        grandfather.setname(boys);

        System.out.println("\nA new turn:");
        grandfather.formline(boys, 1); //by name
        grandfather.bubblesort(boys);

        System.out.println("\nA new turn:");
        grandfather.formline(boys, 2); //by color
        grandfather.quicksort(boys);
    }

}
