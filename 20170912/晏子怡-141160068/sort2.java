public class sort2 {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        //assign first element of an array to largest and smallest
        for(int i=0; i< numbers.length-1; i++)
            for(int t=0;t<numbers.length-1-i;t++)
                if(numbers[t]>numbers[t+1])
                {
                    int tmp=numbers[t];
                    numbers[t]=numbers[t+1];
                    numbers[t+1]=tmp;
                }
        for(int j=0;j<numbers.length;j++)
            System.out.println("The " +(j+1)+"th number is : " + numbers[j]);
    }
}
