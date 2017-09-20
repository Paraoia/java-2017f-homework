public class Sort {
    public static void main(String[] args) {
        //array of ten numbers
        int numbers[] = new int[]{99, 66, 44, 23, 11, 33, 22, 90, 88, 35};
        //bubble sort
        for (int i = 1; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length - i; j++) {
                if(numbers[j] < numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        System.out.println("Sorted Array: ");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
