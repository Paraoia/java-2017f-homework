
/*Largest and Smallest Number in an Array Example
  This Java Example shows how to find largest and smallest number in an
  array.
*/
public class Sort {
        public static void main(String[] args) {
                //array of 10 numbers
                int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
                //assign first element of an array to largest and smallest
                /*int smallest = numbers[0];
                int largetst = numbers[0];
                for(int i=1; i< numbers.length; i++)
                {
                        if(numbers[i] > largetst)
                                largetst = numbers[i];
                        else if (numbers[i] < smallest)
                                smallest = numbers[i];
                }
                System.out.println("Largest Number is : " + largetst);
                System.out.println("Smallest Number is : " + smallest);
				*/
				for(int i=0;i<numbers.length;i++)
					for(int j=i+1;j<numbers.length;j++)
					{
						if(numbers[j]<numbers[i])
						{
							int t=numbers[i];
							numbers[i]=numbers[j];
							numbers[j]=t;
						}
						
					}
					System.out.println("After sorting: ");
					for(int i=0;i<10;i++)
					{
						System.out.println(numbers[i]);
					}
        }
}
