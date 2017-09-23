import java.util.Random;


public class CalabashBros {
    private static Calabash[] bros = {
            new Calabash(Color.红色, Name.老大),
            new Calabash(Color.橙色, Name.老二),
            new Calabash(Color.黄色, Name.老三),
            new Calabash(Color.绿色, Name.老四),
            new Calabash(Color.青色, Name.老五),
            new Calabash(Color.蓝色, Name.老六),
            new Calabash(Color.紫色, Name.老七)
    };

    private static void swap(Calabash[] a, int lo, int hi, int print/*0:print, other:no print*/) {
        if (print == 0) System.out.println(a[lo].name + ":" + lo + ">" + hi);
        Calabash temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }

    private static void shuffle(Calabash[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; ++i) {
            int p = random.nextInt(i + 1);
            swap(a, i, p, 1);
        }
        print("Random shuffle: ", 0);
    }

    public static void bubble(Calabash[] a) {
        Calabash temp;
        for (int i = a.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (a[j + 1].name.compareTo(a[j].name) < 0) {
                    swap(a, j, j + 1, 0);
                }
            }
        }
    }

    public static void qs(Calabash[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        qs(a, lo, j - 1);
        qs(a, j + 1, hi);
    }

    private static int partition(Calabash[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i].color.compareTo(a[lo].color) < 0)
                if (i == hi) break;
            while (a[--j].color.compareTo(a[lo].color) > 0)
                if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j, 0);
        }
        swap(a, lo, j, 0);
        return j;
    }

    public static void print(String comments, int flags/*0:name, other:color*/) {
        System.out.print(comments);
        for (int i = 0; i < bros.length; ++i)
            System.out.print((flags == 0 ? bros[i].name : bros[i].color) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        shuffle(bros);
        bubble(bros);
        print("Sort by age: ", 0);
        shuffle(bros);
        qs(bros, 0, bros.length - 1);
        print("Sort by color: ", 1);
    }
}

enum Color {
    红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色;
};

enum Name {
    老大, 老二, 老三, 老四, 老五, 老六, 老七;
}

class Calabash {

    Name name;
    Color color;

    Calabash(Color color, Name name) {
        this.color = color;
        this.name = name;
    }

    @Override
    public String toString() {
        return name.name();
    }
}