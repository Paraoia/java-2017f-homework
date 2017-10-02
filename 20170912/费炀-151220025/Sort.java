public class Sort {
    public static void main(String[] args) {
        //creat an array
        int numbers[] = new int[]{43, 27, 56, 10, 1, 8, 19, 40};
        //bubble sort
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = 0; j < numbers.length - 1 - i; j++) {
                if(numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < numbers.length - 1; i++)
            System.out.print(numbers[i] + ",");
        System.out.println(numbers[numbers.length - 1]);
    }
}
