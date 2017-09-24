import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Niusort {
	private ArrayList<Integer> list = new ArrayList<Integer>();
	public Niusort(){
	}
	public void Mysort(int[] array) {
		for(int x : array) {
			list.add(x);
		}
		Comparator<? super Integer> c = null;
		list.sort(c);
		for(Integer x : list) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = in.nextInt();
		}
		Niusort niuxu = new Niusort();
		niuxu.Mysort(array);
	}

}
