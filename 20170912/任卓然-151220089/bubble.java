package java;

public class bubble {
    public static void main(String[] args) {
        int a[] = {89, 102, 6, 44, 15, 32, 21, 3, 65, 44,};
        int temp = 0;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                if (a[j] < a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        for (int i = 0; i < 9; i++)
            System.out.println(a[i]);

    }

}
