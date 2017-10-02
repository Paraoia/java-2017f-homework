package java_sort;

import java.util.ArrayList;
import java.util.Scanner;

public class Mysort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> Array=new ArrayList<Integer>(); 
		Scanner In=new Scanner(System.in);
		while(In.hasNext()) {
			Array.add(In.nextInt());
		}
		//Array.sort(null);
		for(int i=1;i<Array.size();i++){
			for(int j=0;j<Array.size()-i;j++) {
				if(Array.get(j)>Array.get(j+1)) {
					int temp=Array.get(j);
					Array.set(j, Array.get(j+1));
					Array.set(j+1, temp);
				}
			}
		}
		for(int i=0;i<Array.size();i++)
			System.out.print(Array.get(i)+" ");
		In.close();
	}
}
