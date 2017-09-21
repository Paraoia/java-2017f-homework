/*
    My way to sort the array.
    @郑聪尉-151220169。
 */

public class MyQuickSort {

    public static void main(String[] args) {
        //array of 10 numbers
        int numbers[] = new int[]{32,43,53,54,32,65,63,98,43,23};
        QuickSort(numbers,0,numbers.length-1);
        for(int i: numbers)
            System.out.println(i);
    }

    static void QuickSort(int array[], int left, int right)
    {
        if (left < right)
        {
            int i = left, j = right, m = array[left];
            while (i < j)
            {
                while(i < j && array[j] >= m) j--;
                if(i < j) array[i++] = array[j];
                while(i < j && array[i] < m) i++;
                if(i < j) array[j--] = array[i];
            }
            array[i] = m;
            QuickSort(array, left, i - 1);
            QuickSort(array, i + 1, right);
        }
    }
}
