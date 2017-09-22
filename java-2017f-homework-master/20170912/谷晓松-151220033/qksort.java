package generaluse;

public class qksort {
	
	public static void sort(int []array,int low,int hign)
	{
		if(hign<=low)
			return;
		
		int key=array[low],i=low,j=hign;
		while(j>i)
		{
			while(j>i&&array[j]>=key)
				j--;
			array[i]=array[j];
			while(j>i&&array[i]<=key)
				i++;
			array[j]=array[i];
		}
		array[i]=key;
		sort(array,low,i-1);
		sort(array,i+1,hign);
	}
	public static void main(String[] args)
	{
		int array[]=new int[] {24,346,6574,23,234,546,56,8,67,100};
		sort(array,0,array.length-1);
		for(byte i=0;i<array.length;i++)
			System.out.println(array[i]+" ");
	}

}