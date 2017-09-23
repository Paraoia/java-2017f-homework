import java.awt.*;
import java.util.Arrays;

public class sort{
    public static void  main(String args[]){
        int arr[]=new int[]{23,12,45,65,2,43,11,89,32};
        for(int i=0;i<arr.length-1;i++)
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        System.out.println(Arrays.toString(arr));
    }


}