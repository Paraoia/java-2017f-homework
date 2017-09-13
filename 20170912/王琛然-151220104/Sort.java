public class Sort {
    public static void main(String[] args)
    {
        int str[]=new int[]{1,3,5,7,9,2,4,6,8,10};
        for(int i=0;i<str.length;i++)
        {
            for(int j=0;j<str.length-i-1;j++)
            {
                if(str[j]>str[j+1])
                {
                    int temp=str[j+1];
                    str[j+1]=str[j];
                    str[j]=temp;
                }
            }
        }
        for(int i=0;i<str.length;i++)
            System.out.println(str[i]);
    }
}
