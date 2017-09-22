import java.util.*;
public class sort {
    public static void main(String[]args)
    {
        int arr[]={5,2,8,6,3,1,0,9,4,7};
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i;j<arr.length;j++)
            {
                if(arr[i]>arr[j])
                {
                    int tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]);
    }


}
