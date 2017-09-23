import java.util.Random;


enum color {
    红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色;
}

class Calabash {
    public int order;
    public String name;
    public color costume;

    Calabash(int order, color costume, String name) {
        this.order = order;
        this.costume = costume;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        Calabash test = new Calabash(3, color.黄色, "老三");
        System.out.println(test);
    }
}

public class CalabashBrothers {
    private static Calabash[] brothers;

    static {
        brothers = new Calabash[]{
                new Calabash(1, color.红色, "老大"),
                new Calabash(2, color.橙色, "老二"),
                new Calabash(3, color.黄色, "老三"),
                new Calabash(4, color.绿色, "老四"),
                new Calabash(5, color.青色, "老五"),
                new Calabash(6, color.蓝色, "老六"),
                new Calabash(7, color.紫色, "老七")
        };
    }

    private static void shuffle(Calabash[] a) {
        System.out.print("Random Shuffle: ");
        Random random = new Random();
        for (int i = 0; i < a.length; ++i) {
            int p = random.nextInt(i + 1);
            Calabash temp = a[i];
            a[i] = a[p];
            a[p] = temp;
        }
        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort temp = new QuickSort();
        BubbleSort temp1 = new BubbleSort();

        // random shuffle the array
        shuffle(brothers);
        //bubble sort
        temp1.bubble(brothers);
        //print
        System.out.print("Sort by age: ");
        for (int i = 0; i < brothers.length; ++i)
            System.out.print(brothers[i] + " ");
        System.out.println();

        //random shuffle again
        shuffle(brothers);
        //quick sort
        temp.qs(brothers, 0, brothers.length - 1);
        System.out.print("Sort by color: ");
        for (int i = 0; i < brothers.length; ++i)
            System.out.print(brothers[i].costume + " ");
        System.out.println();
    }
}


class QuickSort {

    public static void qs(Calabash[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        qs(a, lo, j - 1);
        qs(a, j + 1, hi);
    }

    private static int partition(Calabash[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i].costume.compareTo(a[lo].costume) < 0)
                if (i == hi) break;
            while (a[--j].costume.compareTo(a[lo].costume) > 0)
                if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private static void swap(Calabash[] a, int lo, int hi) {
        System.out.println(a[lo] + ":" + lo + ">" + hi);
        Calabash temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }
}

class BubbleSort {
    private static void swap(Calabash[] a, int lo, int hi) {
        System.out.println(a[lo] + ":" + lo + ">" + hi);
        Calabash temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }

    public static void bubble(Calabash[] a) {
        Calabash temp;
        for (int i = a.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (a[j + 1].order < a[j].order) {
                    swap(a, j, j + 1);
                }
            }
        }
    }
}









