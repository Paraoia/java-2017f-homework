public class homework{

    public static void main(String[] args) {
        int numbers[] = {32,43,53,54,32,65,63,98,43,23};
        bubbleSort(numbers);
        for(int i = 0 ; i < 10 ; i++)
            System.out.print(numbers[i]+" ");
    }

    private static void bubbleSort(int[] numbers) {   
    int temp;
    int size = numbers.length;  
    for (int i = 0; i < size - 1; i++) {   
        for (int j = i + 1; j < size; j++) {   
            if (numbers[i] > numbers[j]) {  
                temp = numbers[i];   
                numbers[i] = numbers[j];   
                numbers[j] = temp;   
            }   
        }   
    }   
}  
}
