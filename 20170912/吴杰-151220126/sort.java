/**
 * Created by jar on 2017/9/12.
 */
public class sort {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        //assign first element of an array to largest and smallest
        int temp;
        for(int i=0;i<10;i++){
            for(int j=0;j<9-i;j++){
                if(numbers[j]>numbers[j+1]){
                    temp=numbers[j+1];
                    numbers[j+1]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        for(int k=0;k<10;k++)
            System.out.println(numbers[k]);
    }
}
