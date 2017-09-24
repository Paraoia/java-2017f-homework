import java.util.Random;

public class CalabashBrothers {
    public static void main(String[] args) {
        Calabashfamily calabashfamily1 = new Calabashfamily();
        calabashfamily1.initialize();
        calabashfamily1.getinline();
        calabashfamily1.bubblesort();
        Calabashfamily calabashfamily2 = new Calabashfamily();
        calabashfamily2.initialize();
        calabashfamily2.getinline();
        calabashfamily2.quicksort(0, 6);
    }
}

class Calabashfamily {
    CalabashBro[] members;
    int[] line = new int[7];

    void initialize() {
        CalabashBro Redbro = new CalabashBro();
        Redbro.color = "红色";
        Redbro.rank = "老大";
        CalabashBro Orangebro = new CalabashBro();
        Orangebro.color = "橙色";
        Orangebro.rank = "老二";
        CalabashBro Yellowbro = new CalabashBro();
        Yellowbro.color = "黄色";
        Yellowbro.rank = "老三";
        CalabashBro Greenbro = new CalabashBro();
        Greenbro.color = "绿色";
        Greenbro.rank = "老四";
        CalabashBro Cyanbro = new CalabashBro();
        Cyanbro.color = "青色";
        Cyanbro.rank = "老五";
        CalabashBro Bluebro = new CalabashBro();
        Bluebro.color = "蓝色";
        Bluebro.rank = "老六";
        CalabashBro Purplebro = new CalabashBro();
        Purplebro.color = "紫色";
        Purplebro.rank = "老七";
        members = new CalabashBro[7];
        members[0] = Redbro;
        members[1] = Orangebro;
        members[2] = Yellowbro;
        members[3] = Greenbro;
        members[4] = Cyanbro;
        members[5] = Bluebro;
        members[6] = Purplebro;
    }

    void getinline() {
        Random r = new Random();
        int i, j, t;
        i = 0;
        while (i < 7) {
            boolean flag = true;
            t = r.nextInt(7);
            for (j = 0; j < i; j++) {
                if (t == line[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                line[i] = t;
                i++;
            }
        }
        System.out.println("随机站队的葫芦娃队列：");
        for (i = 0; i < 7; i++) {
            members[line[i]].showrank();
        }
    }

    void bubblesort() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if (line[j] > line[j + 1]) {
                    int temp = line[j];
                    line[j] = line[j + 1];
                    line[j + 1] = temp;
                }
            }
        }
        System.out.println("经过冒泡排序后的葫芦娃队列：");
        for (int i = 0; i < 7; i++) {
            members[line[i]].showrank();
        }
    }

    void quicksort(int top, int bottom) {
        int low = top;
        int high = bottom;
        int key = line[low];
        while (low < high) {
            while (low < high && line[high] >= key) {
                high--;
            }
            if (line[high] <= key) {
                int temp = line[high];
                line[high] = line[low];
                line[low] = temp;
            }
            while (low < high && line[low] <= key) {
                low++;
            }
            if (line[low] >= key) {
                int temp = line[low];
                line[low] = line[high];
                line[high] = temp;
            }
        }
        if (low > top) {
            quicksort(top, low - 1);
        }
        if (high < bottom) {
            quicksort(high + 1, bottom);
        }
        if (low <= top && high >= bottom) {
            System.out.println("经过快速排序后的葫芦娃队列：");
            for (int i = 0; i < 7; i++) {
                members[line[i]].showcolor();
            }
        }
    }
}

class CalabashBro {
    String color;
    String rank;

    void showcolor() {
        System.out.println(color);
    }

    void showrank() {
        System.out.println(rank);
    }
}