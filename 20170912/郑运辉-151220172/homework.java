import java.util.Arrays;

public class homework {
    static public void main(String []arg){
        //System.out.println("Hello World");
        int[] arr = new int[]{1,3,2,5,9,7,6,4,2,1};
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        System.out.print(Arrays.toString(arr));
    }
}
