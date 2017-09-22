
public class hello {
	public static void main(String[] args)
	{
		int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        for(int i=0; i< numbers.length; i++)
        {
                for(int j=i+1;j<numbers.length;j++)
                {
                	if(numbers[i]>numbers[j])
                	{
                		int temp=numbers[i];
                		numbers[i]=numbers[j];
                		numbers[j]=temp;
                	}
                }
        }
        for(int i=0;i<numbers.length;i++)
        {
        System.out.println(numbers[i]);
        }
		
	}
}
