
public class MySort {
	
	public static void main(String[] args)
	{
		int[] a = new int[] {5,2,3,1,4};
		sort(a,a.length);
		
		for(int i = 0;i < a.length;++i)
			System.out.print(a[i]);
		
	}
	
	static void sort(int a[],int length)
	{
		for(int i = 0;i < length-1;++i)
		{
			for(int j = 0;j < length-i-1;++j)
			{
				if(a[j] > a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}								
			}
			
		}		
	}
	
}
