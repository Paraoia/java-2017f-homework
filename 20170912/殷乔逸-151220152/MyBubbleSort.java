/*
 * My function to sort the array
 * @Qiaoyi-151220152
 */

public class MyBubbleSort{
	
	public static void main(String[] args) {
		int array[]={32,43,53,54,32,65,63,98,43,23};
		int num=10;
		BubbleSort(array,num);
		for(int i:array)
			System.out.println(i);
	}

	static void BubbleSort(int array[], int num){

		for (int i=0;i<num-1;i++){
			for (int j=num-1;j>i;j--){
				if (array[j]>array[j-1]){
					int temp=array[j];
					array[j]=array[j-1];
					array[j-1]=temp;
				}
			}
		}
	}
}


			
