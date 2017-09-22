package Homework1;
import java.util.*;

public class Main{
	
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public static void main(String[] Args){
		System.out.println("Press Ctrl+Z to close input");
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
				numbers.add(input.nextInt());
		}
		System.out.println(numbers);
		
		QuickSort(numbers, 0, numbers.size()-1);
		
		System.out.println(numbers);
	}

	public static void QuickSort(ArrayList<Integer> numbers, int begin, int end) {
		if(begin < end){
			int peak = Partition(numbers, begin, end);
			QuickSort(numbers, begin, peak-1);
			QuickSort(numbers, peak+1, end);
		}
	}
	public static int Partition(ArrayList<Integer> numbers, int begin, int end) {
		int x = numbers.get(end);
		int i = begin-1;
		
		for(int j=begin; j<end; j++){
			if(numbers.get(j) <= x){
				i = i+1;
				swap(numbers, i, j);
			}
		}
		swap(numbers, i+1, end);
		return i+1;
	}
	public static void swap(ArrayList<Integer> numbers, int i, int j){
		int temp;
		
		temp = numbers.get(i);
		numbers.set(i, numbers.get(j));
		numbers.set(j, temp);
	}
}
