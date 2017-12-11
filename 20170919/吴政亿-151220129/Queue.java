import java.util.ArrayList;
import java.util.Collections;

public class Queue {
    private ArrayList List = new ArrayList();
    
    public Queue(){
    	List.clear();
    }
    
    public int Size() {
    	return List.size();
    }
    
    public void EnQueue(Calabash calabash) {
    	List.add(calabash);
    }
    
    public void DeQueue(int index) {
    	for(int i=0;i<List.size();i++) {
    		Calabash temp = (Calabash)List.get(i);
    		if(temp.GetIndex() == index) {
    			List.remove(i);
    			return;
    		}
    	}	
    }
    
    public Calabash GetCalabash(int index) {
    	return (Calabash)List.get(index);
    }
    
    public void swap(int a, int b) {
    	System.out.println(((Calabash)List.get(a)).GetName() + " : " + a + " -> " + b);
        System.out.println(((Calabash)List.get(b)).GetName() + " : " + b + " -> " + a);
    	Calabash temp = (Calabash)List.get(a);
    	List.set(a, List.get(b));
    	List.set(b, temp);
    	
    }
    
    public void shuffle() {
        // ¥Ú¬“À≥–Ú
        Collections.shuffle(List);
    }
    
    public void ReportColor() {
    	for(int i=0;i<List.size();i++)
    		System.out.println(((Calabash)List.get(i)).GetColor());
    }
    
    public void ReportName() {
    	for(int i=0;i<List.size();i++)
    		System.out.println(((Calabash)List.get(i)).GetName());
    }
}