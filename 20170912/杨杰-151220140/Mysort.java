package java_sort;

public class Mysort{
    public static void main(String[] args)
    {
        int numbers[] = new int[]{5,2,6,3,7,1,4};
        for(int i = 0;i < 7;i++){
            for(int j = 0;j < 6;j++){
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        for(int i = 0;i < 7;i++)
            System.out.println(numbers[i]);
    }
}