public class HelloWorld {
    public static void main(String args[]){
        int array[] = {9,8,7,6,5,4,3,2,1};
        for(int i = 0; i < array.length; i++){
            int idx = i;
            for(int j = array.length - 1; j > i; j--){
                if(array[j] < array[idx]){
                    idx = j;
                }
            }
            int temp = array[i];
            array[i] = array[idx];
            array[idx] = temp;
        }
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");
    }
}
