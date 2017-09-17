public class Sort{
	public static void main(String[] args){
		int[] nums = {21, -3, 6, 43, 124, -34, 0, -546, 65};
		System.out.print("Before sort: ");
		printArray(nums);
		
		System.out.print("After sort: ");
		bubbleSort(nums);
		printArray(nums);
	}
	
	public static void bubbleSort(int[] nums){
		int n = nums.length;
		for(int i = 0; i < n - 1; i++)
			for(int j = 0; j < n - 1 - i; j++)
				if(nums[j] > nums[j+1]){
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
	}
	
	public static void printArray(int[] nums){
        for(int i = 0 ; i < nums.length ; i ++ )
			System.out.print(nums[i] + " ");
        System.out.println("");
    }
}