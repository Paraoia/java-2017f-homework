import java.util.*;

public class Queue {
    private ArrayList List = new ArrayList();

    public Queue(){
        List.clear();
    }

    public int Size() {
        return List.size();
    }

    public void EnQueue(Creature creature) {
        List.add(creature);
    }

    public void DeQueue(int index) {
//        for(int i=0;i<List.size();i++) {
//            Calabash temp = (Calabash) List.get(i);
//            if(temp.GetIndex() == index) {
//                List.remove(i);
//                return;
//            }
//        }
        List.remove(index);
    }

    public Creature GetCreature(int index) {
        return (Creature)List.get(index);
    }

    public void swap(int a, int b) {
        System.out.println(((Calabash)List.get(a)).GetName() + " : " + a + " -> " + b);
        System.out.println(((Calabash)List.get(b)).GetName() + " : " + b + " -> " + a);
        Calabash temp = (Calabash)List.get(a);
        List.set(a, List.get(b));
        List.set(b, temp);

    }

    public void shuffle() {
        Collections.shuffle(List);
    }

//    public void ReportColor() {
//        for(int i=0;i<List.size();i++)
//            System.out.println(((Calabash)List.get(i)).GetColor());
//    }

    public void Echo() {
        for(int i=0;i<List.size();i++)
            ((Creature)List.get(i)).Echo();
    }
}