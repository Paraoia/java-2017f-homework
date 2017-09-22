public class HelloWorld {
 public static void main(String args[]){
        int temp;
	int number[]={1,3,5,7,9,2,4,8,6};
	int size=number.length;
	for(int i=0;i<size;i++)
		for(int j=i+1;j<size;j++)
			if(number[i]>number[j])
			{
			    temp=number[j];
			    number[j]=number[i];
			    number[i]=temp;
			}
	for(int i=0;i<size;i++)
	 System.out.print(number[i]+" ");
	System.out.print("\n");
    }
}
