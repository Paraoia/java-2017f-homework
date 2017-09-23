public class Sort {
	public static void main(String[] args){
		int arr[] = new int []{9,8,7,6,5,4,3,2,1,0};
		for(int i=0;i<arr.length-1;i++)
			for(int j=0;j<arr.length-1-i;j++)
				if(arr[j]>arr[j+1])
				{
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}