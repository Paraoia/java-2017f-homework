package java_2017_151220144;

public class sortnumbers { 
	public static void main(String[] args) { 
    //System.out.println("Hello World!");
    int num[]=new int[]{100,964,78,2227,6,105,204,32,25,11};
    for(int i=0;i<9;i++)
    	for(int j=0;j<9-i;j++)
    	{
    		if(num[j]>num[j+1])
    		{
    			int temp=num[j];
    			num[j]=num[j+1];
    			num[j+1]=temp;
    			
    		}
    		
    	}
    	for(int i=0;i<10;i++)
    		System.out.print(num[i]+" ");
	
	}

}
