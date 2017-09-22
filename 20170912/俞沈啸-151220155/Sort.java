
public class Sort {
    public static void main(String[] args){
        int numbers[]=new int[]{5,4,7,6,2,8,1,9,3,10};
        for(int i=0;i<numbers.length;i++)
            for(int j=0;j<numbers.length-1;j++)
            {
                if(numbers[j]>=numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        for(int i=0;i<numbers.length;i++)
            System.out.print(numbers[i]+" ");
    }
}
