public class qsort{
	public static void main(String[] args){
		int[] arr = new int[]{13,18,9,1,-3,8,10};
		quicksort(arr,0,arr.length-1);
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}
	public static void quicksort(int[] arr, int left, int right){
		if(left < right){
			int pivot = partition(arr, left, right);
			quicksort(arr, left, pivot - 1);
			quicksort(arr, pivot + 1, right);
		}
	}
	public static int partition(int[] arr, int left, int right){
		int pivotpos = left;
		int pivotval = arr[left];
		for(int i = left + 1; i <= right; i++){
			if(arr[i] < pivotval){
				pivotpos ++;
				if(pivotpos != i){
					int temp = arr[pivotpos];
					arr[pivotpos] = arr[i];
					arr[i] = temp;
				}
			}
		}
		arr[left] = arr[pivotpos];
		arr[pivotpos] = pivotval;
		return pivotpos;
	}
}
