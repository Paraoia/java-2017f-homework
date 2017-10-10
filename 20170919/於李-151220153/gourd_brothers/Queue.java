package gourd_brothers;

import java.util.Random;

public class Queue {
    private Boy []boys;

    private void ReportByColour(Boy []boys) {
        for (Boy guy: boys) {
            guy.ReportColour();
            System.out.print(" ");
        }
        System.out.println();
    }

    private void ReportByOrder(Boy []boys) {
        for (Boy guy: boys) {
            guy.ReportOrder();
            System.out.print(" ");
        }
        System.out.println();
    }

    private void BubbleSort(Boy []boys) {
        for (int i = 0; i < boys.length; i++) {
            for (int j = 0; j < boys.length - i - 1; j++) {
                if (boys[j].Compare(boys[j + 1])) {
                    boys[j].ReportOrder();
                    System.out.println(":" + j + "->" + (j + 1));
                    boys[j + 1].ReportOrder();
                    System.out.println(":" + (j + 1) + "->" + j);
                    Boy temp = boys[j];
                    boys[j] = boys[j + 1];
                    boys[j + 1] = temp;
                }
            }
        }
    }

    private void QuickSort(Boy []boys, int beg, int end) {
        if (beg >= end) return;
        Boy key = boys[beg];
        int pivot = beg;
        for (int i = beg + 1; i <= end; i++) {
            if (key.Compare(boys[i])) {
                pivot++;
                if (pivot != i) {
                    boys[pivot].ReportOrder();
                    System.out.println(":" + pivot + "->" + i);
                    boys[i].ReportOrder();
                    System.out.println(":" + i + "->" + pivot);
                    Boy temp = boys[pivot];
                    boys[pivot] = boys[i];
                    boys[i] = temp;
                }
            }
        }
        boys[pivot].ReportOrder();
        System.out.println(":" + pivot + "->" + beg);
        boys[beg].ReportOrder();
        System.out.println(":" + beg + "->" + pivot);
        Boy temp = boys[pivot];
        boys[pivot] = key;
        boys[beg] = temp;
        QuickSort(boys, beg, pivot - 1);
        QuickSort(boys, pivot + 1, end);
    }

    public void QueueByOrder() {
        System.out.println("排序前:");
        ReportByOrder(boys);
        BubbleSort(boys);
        System.out.println("排序后:");
        ReportByOrder(boys);
    }

    public void QueueByColour() {
        System.out.println("排序前:");
        ReportByColour(boys);
        QuickSort(boys, 0, boys.length - 1);
        System.out.println("排序后:");
        ReportByColour(boys);
    }

    public void ShuffleArray() {
        int index, temp;
        Random random = new Random();
        int []array = new int[boys.length];
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        for (int i = 0; i < boys.length; i++)
            boys[i] = new Boy(array[i]);
    }

    Queue(int n) {
        boys = new Boy[n];
        ShuffleArray();
    }

    public static void main(String args[]) {
        Queue activity = new Queue(7);
        activity.QueueByOrder();
        activity.ShuffleArray();
        activity.QueueByColour();
    }
}
