public class ArrayRange {
    public static void main(String[] args){
        int numbers[] = new int[]{9, 2, 4, 5, 3, 8, 7, 1, 6, 3};
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] > numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i] + " ");
        }
    }
}
