public class Sort{
	public static void main(String args[]){
		int numbers[] = new int[]{64,33,75,83,6,58,95,84,12,38};
		
		//bubble sort
		for(int i=0;i<numbers.length-1;i++){
			for(int j=i;j<numbers.length;j++){
				if(numbers[i]>numbers[j])
				{
					int temp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		
		//print	
		for(int i=0;i<numbers.length;i++){
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
	} 
}
