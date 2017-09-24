/*
  This Java Example shows how to sort all the numbers in an
  array by using bubble sort algorithm.
*/
public class Sort{
        public static void main(String[] args) {
                //array of 10 numbers
                int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
                //assign first element of an array to largest and smallest
                for(int i = 0; i < numbers.length - 1; i++)
					for(int j = 0; j < numbers.length - 1 - i; j++)
                {
						int temp;
                        if(numbers[j] > numbers[j+1])
						{
							temp = numbers[j];
							numbers[j] = numbers[j+1];
							numbers[j+1] = temp;
						}
                }
				for(int i=0; i< numbers.length; i++)
					System.out.print(numbers[i] + " ");
        }
}