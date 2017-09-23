package sort;

public class sort {
    public static void main(String[] args)
    {
        int data[] = {0,9,2,10,28,11,-1,20,1,3};
        for(int i=0;i< data.length-1;i++)
        {
            int min = i;
            for(int j=i+1;j<data.length;j++)
            {
                if(data[j]<data[min])
                {
                    min = j;
                }
            }
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
        for(int i=0;i< data.length;i++)
        {
            System.out.println(data[i]);
        }
    }
}
