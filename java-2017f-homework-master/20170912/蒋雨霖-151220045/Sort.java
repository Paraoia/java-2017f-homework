
public class Sort {
    public static void main(String []args)
    {
        int []numbers={32,43,53,54,32,65,63,98,43,23};
        int temp;
        //bubble sort  in an ascending order
        for(int i=0;i<numbers.length;i++)
        {
            for(int j=i+1;j<numbers.length;j++)
            {
                if(numbers[i]>numbers[j])
                {
                    temp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        //output results
        System.out.println("排序后输出结果：");
        for(int i=0;i<numbers.length-1;i++)
          System.out.print(numbers[i]+" ");
        System.out.println(numbers[numbers.length-1]);
    }
}
