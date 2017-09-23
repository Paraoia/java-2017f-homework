public class Main{
    public static void main(String []args){
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        //assign first element of an array to largest and smallest
        for(int i=1; i< numbers.length; i++)
        {
            for(int j=0; j< numbers.length-i; j++)
            {
                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j+1];
                    numbers[j+1]=numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for(int i=1; i< numbers.length; i++)
        System.out.println(numbers[i]);
    }
}