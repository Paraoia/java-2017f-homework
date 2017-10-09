/**
*package nju.wxz.java2017;
*copyright@wxz
*2017/9/13
*/
class ArrSort{
	public static void main(String[] args){
		int[] arr =new int []{12,41,25,34,76,28,19,25,33,40,61};
		// pre Array
		PrintArr(arr);
		int[] arr2 = BubbleSort(arr);
		//after Array
		PrintArr(arr2);
		
	}	
	public static int[] BubbleSort(int[] Arr){
		for(int i=0;i<Arr.length-1;i++){
			for(int j=i+1;j<Arr.length;j++){
				int temp=0;
				if(Arr[i]>Arr[j]){
					temp = Arr[i];
					Arr[i] = Arr[j];
					Arr[j] = temp;
				}
			}
		}
		return Arr;
	}	
	public static void PrintArr(int[] Arr){
		int index = Arr.length;
	//	for(int i=0;i<Arr.length-1;i++){
		for(int i=0;i<index-1;i++){
			System.out.print(Arr[i]+" ");
		}
		System.out.println(Arr[index-1]);	
	}
}