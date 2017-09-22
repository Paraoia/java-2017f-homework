package java2017;

public class Sort {
    public static void main(String[] args) {
        int array[] = new int[]{5, 3, 45, 54, 1, 6, 7, 2, 23, 32};
        int tmp;

        System.out.println("before sort: ");
        for(int i=0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();

        for (int i = 0; i < array.length; i++)
            for (int j = 1; j < array.length; j++)
                if (array[j - 1] > array[j]) {
                    tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }

        System.out.println("after sort: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
