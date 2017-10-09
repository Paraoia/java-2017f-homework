public class Helloworld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] x={1,3,2,4,11,6,7,8,9,10}; 
		for(int i=0;i<10;i++)
		{	for(int j=i+1;j<10;j++)
			{
			  if(x[i]>x[j])
			  {  
				  int t=x[i];
				  x[i]=x[j];
				  x[j]=t;
			  }
			}
		}
		for(int i=0;i<10;i++)
		{
			System.out.println(x[i]+",");
		}
	}

}
