public class mySort {

	private static int[] array = {1,3,2,4,5};
	
	public static void main( String[] args){
		sort(array);
		for(int i:array){
			System.out.printf(i + " ");
		}
	}

	private static void sort(int[] array){
		for(int i = 0; i < array.length-1;i++){
			for(int j = i ; j <array.length;j++){
				if(array[i] < array[j]){
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}

}
