
/*Select Sort
*/
public class Sort {
        public static void main(String[] args) {
                //array of 10 numbers
                int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
                
                
                for(int i=0; i< numbers.length; i++)
                {
                    int min=i;
                    for(int j=i+1;j<numbers.length;j++)
                        if(numbers[j] < numbers[min])
                                min = j;
                    int temp=numbers[i];
                    numbers[i]=numbers[min];
                    numbers[min]=temp;

                }
                System.out.println("The result is:");
                for(int i=0; i< numbers.length; i++)
                {
                    System.out.print(numbers[i]+" ");
                }
                
                
        }
}
