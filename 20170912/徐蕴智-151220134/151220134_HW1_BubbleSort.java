class BubbleSort {
    public static void main(String[] args) {
		//array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        //assign first element of an array to largest and smallest
        //int smallest = numbers[0];
        //int largetst = numbers[0];
        for(int i=0; i< numbers.length; i++)
        {
            for(int j=i; j< numbers.length; j++)
            {
            	if(numbers[i]>numbers[j])
            	{
            		int temp=numbers[i];
            		numbers[i]=numbers[j];
            		numbers[j]=temp;
            	}
            }
        }
        //System.out.println("Largest Number is : " + largetst);
        //System.out.println("Smallest Number is : " + smallest);
        for(int k=0; k< numbers.length-1; k++)
        {
        	System.out.print(numbers[k]+",");
        }
        System.out.print(numbers[9]+"\n");
    }
}
