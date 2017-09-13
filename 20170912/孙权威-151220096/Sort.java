public class Sort {
    public static void main(String[] args){
        int numbers[]=new int[]{5,15,6,16,3,13,2,12};
        for(int i=0;i<numbers.length;i++)
        {
            for(int j=i+1;j<numbers.length;j++)
            {
                if(numbers[j]<numbers[i])
                {
                    int temp;
                    temp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        for(int k=0;k<numbers.length;k++)
        {
            System.out.print(numbers[k]+" ");
        }
    }
}
