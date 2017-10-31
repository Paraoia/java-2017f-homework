package huluwa;

public class main {
    public static void main(String[] args)
    {
       /*new_huluwa[] bros=new new_huluwa[7];
        sort p1=new sort();
        p1.set_random();
        p1.init(bros);
        p1.printfirst();
        p1.bubblesort();
        p1.printfirst();
        p1.set_random();
        p1.init(bros);
        p1.printfirst();
        p1.QuickSort(0,6);
        p1.printfirst();*/
       for(int i=0;i<3;i++)
       {
            formation p=new formation(10);
           p.changeformation(i);
             p.printformation();
       }
    }
}
