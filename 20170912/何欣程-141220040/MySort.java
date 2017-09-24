package mysort;

public class MySort {
	public static void main(String[] args)
	{
	    int temp = 0;
	    int numbers[]={51,36,75,81,55,100,-10};
	    int size = numbers.length;
	    for(int i = 0 ; i < size-1; i ++)
	    {
	    	for(int j = 0 ;j < size-1-i ; j++)
	    	{
	    		if(numbers[j] > numbers[j+1])  
	    		{
	    			temp = numbers[j];
	    			numbers[j] = numbers[j+1];
	    			numbers[j+1] = temp;
	    		}
	    	}
	    }
	    for(int k=0;k<size;k++)
	    	System.out.print(String.valueOf(numbers[k])+",");
	}
}

