//@author: xiexian

public class mySort 
{
	    public static void main(String[] args)
	    {
	    	int []myArray={5,42,26,-31,12,2,0};
	        for(int i=0;i<myArray.length-1;i++)
	        	for(int j=i+1;j<myArray.length;j++)
	        	{
	        		if(myArray[i]>myArray[j])
	        		{	  
	        			int temp=myArray[i];
	        			myArray[i]=myArray[j];
	        			myArray[j]=temp;
	        		}	        							        		
	        	}
	        for(int i=0;i<myArray.length;i++)
	        	System.out.println(myArray[i]);
	        		
	    }
}

