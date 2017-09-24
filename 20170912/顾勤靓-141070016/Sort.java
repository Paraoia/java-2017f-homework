public class Sort {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32, 43, 53, 54, 32, 65, 63, 98, 43, 23};
        //sort array
        int temp = 0;
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    temp= numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        System.out.println("The array after sorting is : ");
        for (int k = 0; k < numbers.length; k++) {
            System.out.print(numbers[k] + " ");
        }
    }
}