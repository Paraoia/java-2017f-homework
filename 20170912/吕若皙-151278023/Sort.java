/*
  Sort an array.
*/
public class Sort{
    public static void main(String[] args) {
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        for(int i=1; i< numbers.length-1; i++)
        {
            for(int j=1;j< numbers.length-i;j++)
                if(numbers[j]>numbers[j+1])
                {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                }
        }
        for(int i=1;i<numbers.length;i++)
            System.out.println(" "+ numbers[i]);
    }
}