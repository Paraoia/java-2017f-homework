import java.util.*; 

public class MySort {
	public static int[] array={9,8,7,6,5,4,3,2,1};
	
	public static void main(String args[]){
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-i-1;j++){
				if(array[j]>array[j+1]){
					int temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
		}
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		
	}
}
