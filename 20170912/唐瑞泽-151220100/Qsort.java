/*************************************************************************
	> File Name: Qsort.java
	> Author: Tang Ruize
	> Mail: 151220100@smail.nju.edu.cn
	> Creation Time: 2017-09-12 16:48
	> Description: quick sort
 ************************************************************************/

public class Qsort {
    private int []array;
    private final int size = 10;

    public static void main(String[] args) {
        Qsort s = new Qsort();
        System.out.println("Before sort: ");
        s.printElements();
        s.qsort();
        System.out.println("after sort: ");
        s.printElements();
    }

    public Qsort() {
        array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = (int)(Math.random() * 1000);
        }
    }

    public void qsort() {
        qsort(0, size - 1);
    }

    private void qsort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            qsort(p, q - 1);
            qsort(q + 1, r);
        }
    }

    private int partition(int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (array[j] <= x) {
                ++i;
                swap(i, j);
            }
        }
        swap(i + 1, r);
        return i + 1;
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void printElements() {
        for (int i = 0; i < size; ++i) {
            System.out.print(" " + array[i]);
        }
        System.out.println("");
    }
}
