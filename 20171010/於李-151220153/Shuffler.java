import java.util.Random;

public class Shuffler {
    public int[] shuffledArray(int len) {
        int index, temp;
        Random random = new Random();
        int []array = new int[len];
        for (int i = 0; i < array.length; i++)
            array[i] = i;
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
