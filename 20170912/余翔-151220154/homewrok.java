import java.lang.reflect.Array;

public class homewrok {
    public static void main(String [] args){
        int arr[]= new int[]{1,3,2,7,9,5,10};
        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
       for(int i=0;i<arr.length;i++)
           System.out.println(arr[i]);
    }
}
