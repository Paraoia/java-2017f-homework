public class Mysort {
    public static void main(String[] args) {
        int numbers[] = new int[]{32, 43, 53, 54, 32, 65, 63, 98, 43, 23};
        for(int i = 0; i < numbers.length; i++)
        {
            int min = i;
            for(int j = i+1; j < numbers.length; j++)
                if (numbers[j] < numbers[min])
                    min = j;
            if (min != i)
            {
                int temp = numbers[min];
                numbers[min] = numbers[i];
                numbers[i] = temp;
            }
        }
        for(int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);
    }
}
