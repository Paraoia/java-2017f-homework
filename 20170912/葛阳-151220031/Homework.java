public class Homework {

	public static void main(String[] args) {
		//array of 10 numbers 
		int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23}; 
		
		
		for(int i=1; i< numbers.length; i++) {
			int min=i;
			for (int j=i+1;j<numbers.length;j++)
			{
				if(numbers[j]<numbers[min])
					min=j;					
			}
			if (min!=i)
			{
				int t=numbers[i];
				numbers[i]=numbers[min];
				numbers[min]=t;
				
			}
			}
		System.out.print("Sort £º");
		for (int i=1;i<numbers.length;i++)			
		System.out.print(numbers[i]+" ");
		 

	}

}