import java.util.Random;

/**
 * Created by jar on 2017/9/22.
 */
public class Huluqueue {
    Hulubro[] hulu = new Hulubro[7];

    public Huluqueue() {
        int[] num = new int[7];
        num = this.Upset();
        for (int i = 0; i < hulu.length; i++) {
            hulu[i] = new Hulubro();
            hulu[i].Huluborn(num[i]);
        }
    }

    private int[] Upset() {
        int[] num = new int[7];
        for (int i = 0; i < 7; i++) {
            num[i] = i + 1;
        }
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int a = random.nextInt(6);
            int b = random.nextInt(6);
            int c = num[a];
            num[a] = num[b];
            num[b] = c;
        }
        return num;
    }

    //快速排序
    private void exchange(Hulubro[] hulu, int a, int b) {
        Hulubro temp = hulu[a];
        hulu[a] = hulu[b];
        hulu[b] = temp;
        System.out.printf(hulu[a].name + ": " + b + "->" + a + "\n");
        System.out.printf(hulu[b].name + ": " + a + "->" + b + "\n");
    }

    private int partition(Hulubro[] hulu, int start, int end) {
        int x = hulu[end].rank, i = start - 1;
        for (int j = start; j < end; j++) {
            if (hulu[j].rank <= x) {
                i++;
                exchange(hulu, i, j);
            }
        }
        exchange(hulu, i + 1, end);
        return i + 1;
    }

    public void quicksort(int start, int end) {
        if (start < end) {
            int q = partition(hulu, start, end);
            quicksort(start, q - 1);
            quicksort(q + 1, end);
        }
    }

    public void tell_colour() {
        for (int i = 0; i < hulu.length; i++) {
            hulu[i].tell_colour();
            System.out.printf(" ");
        }
    }

    //冒泡排序
    public void bubblesort() {
        Hulubro temp;
        for (int i = 0; i < hulu.length; i++) {
            for (int j = 0; j < hulu.length - 1 - i; j++) {
                if (hulu[j].rank > hulu[j + 1].rank) {
                    temp = hulu[j + 1];
                    hulu[j + 1] = hulu[j];
                    hulu[j] = temp;
                    System.out.printf(hulu[j].name + ": " + (j + 1) + "->" + j + "\n");
                    System.out.printf(hulu[j + 1].name + ": " + j + "->" + (j + 1) + "\n");
                }
            }
        }
    }

    public void tell_name() {
        for (int i = 0; i < hulu.length; i++) {
            hulu[i].tell_name();
            System.out.printf(" ");
        }
        System.out.printf("\n");
    }
}
