public class Sort {
    public static void main(String [] args){
        int numbers[]={10,9,8,3,1,0,-1,2,4,5};
        int temp;
        for(int i=0;i<numbers.length;++i)
        {
            for(int j=i+1;j<numbers.length;++j)
            {
                if(numbers[i]>numbers[j])
                {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for(int i=0;i<numbers.length;i++)
        {
            System.out.print(numbers[i]+" ");
        }
        System.out.print("\n");
    }
}
