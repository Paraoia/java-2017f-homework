public class sort {
    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        //assign first element of an array to largest and smallest
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 - i; j++ ) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < 10; i++)
            System.out.println(numbers[i] + " ");
    }
}