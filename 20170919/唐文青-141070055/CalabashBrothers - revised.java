import java.util.Random;

public class CalabashBrothers {
    public static final int num = 7;

    public static void main(String[] args) {
        World calabashworld = new World();
        calabashworld.buildfamily();
        calabashworld.mixnumbertags();
        calabashworld.givenumbertag();
        calabashworld.getinqueue();
        calabashworld.queueclaim();
        calabashworld.bubblesort();
        calabashworld.queueclaim();
        calabashworld.mixnumbertags();
        calabashworld.givenumbertag();
        calabashworld.getinqueue();
        calabashworld.queueclaim();
        System.out.print("\r" + "---------快速排序---------");
        calabashworld.quicksort(0, num - 1);
        calabashworld.queueclaim();
    }
}

class World {
    CalabashBro[] members;
    CalabashBro[] queue;
    int[] tagbox = new int[7];

    World() {
        for (int i = 0; i < 7; i++) {
            tagbox[i] = -1;
        }
        queue = new CalabashBro[7];
    }

    void buildfamily() {
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

    void mixnumbertags() {
        System.out.print("\n" + "---------随机站队---------");
        Random r = new Random();
        int i, j, temp;
        for (i = 0; i < 7; i++) {
            tagbox[i] = -1;
        }
        i = 0;
        while (i < 7) {
            boolean flag = true;
            temp = r.nextInt(7);
            for (j = 0; j < i; j++) {
                if (temp == tagbox[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                tagbox[i] = temp;
                i++;
            }
        }
    }

    void givenumbertag() {
        for (int i = 0; i < 7; i++) {
            members[i].getnumbertag(tagbox[i]);
        }
    }

    void getinqueue() {
        for (int i = 0; i < 7; i++) {
            queue[members[i].numbertag] = members[i];
        }
    }

    void queueclaim() {
        System.out.print("\n" + "葫芦娃进行了排队，当前葫芦娃队列为：");
        System.out.print("\n" + "排行顺序：");
        int i;
        for (i = 0; i < 7; i++) {
            queue[i].showrank();
        }
        System.out.print("\n" + "颜色顺序：");
        for (i = 0; i < 7; i++) {
            queue[i].showcolor();
        }
    }

    void bubblesort() {
        System.out.print("\n" + "---------冒泡排序---------");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6 - i; j++) {
                if (members[j].numbertag > members[j + 1].numbertag) {
                    int temp = members[j].exchangetag(members[j + 1].numbertag);
                    members[j + 1].exchangetag(temp);
                }
            }
        }
        getinqueue();
    }

    void quicksort(int top, int bottom) {
        int low = top;
        int high = bottom;
        int key = members[low].numbertag;
        while (low < high) {
            while (low < high && members[high].numbertag >= key) {
                high--;
            }
            if (members[high].numbertag < key) {
                int temp = members[high].exchangetag(members[low].numbertag);
                members[low].exchangetag(temp);
            }
            while (low < high && members[low].numbertag <= key) {
                low++;
            }
            if (members[low].numbertag > key) {
                int temp = members[low].exchangetag(members[high].numbertag);
                members[high].exchangetag(temp);
            }
        }
        if (low > top) {
            quicksort(top, low - 1);
        }
        if (high < bottom) {
            quicksort(high + 1, bottom);
        }
        if (low <= top && high >= bottom) {
            getinqueue();
        }
    }
}

class CalabashBro {
    String color;
    String rank;
    int age;
    boolean isalive;
    boolean ismale;
    int numbertag;

    CalabashBro() {
        age = 0;
        isalive = true;
        ismale = true;
        numbertag = -1;
    }

    void showcolor() {
        System.out.print(color + " ");
    }

    void showrank() {
        System.out.print(rank + " ");
    }

    void getnumbertag(int n) {
        numbertag = n;
    }

    int exchangetag(int tag) {
        int t;
        t = numbertag;
        numbertag = tag;
        tag = t;
        return tag;
    }
}