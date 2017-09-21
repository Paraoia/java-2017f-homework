/**
 * Created by Yuyang Wei on 2017/9/12.
 */
//import java.util.Arrays;

public class ArrangeIntNumber {
    public static void main(String[] args){
        int numbers[]={32,43,53,54,32,65,63,98,41};
        for(int i=0;i<numbers.length-1;i++)
        {
            int minIndex=i;
            for(int j=i+1;j<numbers.length;j++)
            {
                if(numbers[minIndex]>numbers[j])
                {
                    minIndex=j;
                }
            }
            if(minIndex!=i)
            {
                int temp=numbers[i];
                numbers[i]=numbers[minIndex];
                numbers[minIndex]=temp;
            }
        }

       //Arrays.sort(numbers);
       for(int i=0;i<numbers.length;i++)
       {
           System.out.print(numbers[i]+" ");
       }
    }
}

