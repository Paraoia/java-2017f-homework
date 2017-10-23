import java.util.Random;

public class Queue {
    Huluwa[] hlw;
    // 假设葫芦娃坐落在荷叶上, pos 存放荷叶
    Position[] pos;

    Queue() {
        hlw = new Huluwa[7];
        pos = new Position[8];
        for (int i = 0; i < 7; i++) {
            hlw[i] = new Huluwa(i);
            pos[i] = new Position(hlw[i], i + 1);
        }
        // pos7 作为缓存荷叶, 当两个葫芦娃进行交换时其一先跳到缓存荷叶上
        pos[7] = new Position(null, 8);
    }

    // randam queue 随机站队
    void random_queue() {
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int p = random.nextInt(7);
            Huluwa tmp = pos[i].handle;
            pos[i].handle = pos[p].handle;
            pos[p].handle = tmp;
        }
        random = null;
    }

    // bubble sort name 根据名字冒泡排序
    void bubble_sort() {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6 - i; j++)
                if (pos[j].handle.getName() > pos[j + 1].handle.getName())
                    // 调用 Position 方法, 借助缓存荷叶实现两个葫芦娃位置交换
                    pos[j].exchange(pos[j + 1], pos[7]);
    }

    // quick sort color 二分法(快速排序)
    private int partition(int left, int right) {
        // 使得位置为 left 上的葫芦娃先执行跳到缓存荷叶上的动作
        pos[7].handle = pos[left].handle;
        pos[left].handle.hop(pos[left].index, 8);
        int t_no = left + 1;
        while (left < right) {
            while (left < right && pos[right].handle.getColor() >= pos[7].handle.getColor())
                --right;
            if (left != right) {
                pos[left].handle = pos[right].handle;
                pos[right].handle.hop(pos[right].index, pos[left].index);
            }

            while (left < right && pos[left].handle.getColor() <= pos[7].handle.getColor())
                ++left;
            if (left != right) {
                pos[right].handle = pos[left].handle;
                pos[left].handle.hop(pos[left].index, pos[right].index);
            }
        }
        pos[left].handle = pos[7].handle;

        if (left != t_no)
            pos[7].handle.hop(t_no, pos[left].index);

        return left;
    }
    public void qsort(int left, int right) {
        if (left < right) {
            int index = partition(left, right);
            qsort(left, index - 1);
            qsort(index + 1, right);
        }
    }

    // 葫芦娃集体报数, 调用葫芦娃个体的报数方法
    void exclaim_name() {
        for (int i = 0; i < 7; i++) pos[i].handle.exclaim_name();
    }
    void exclaim_color() {
        for (int i = 0; i < 7; i++) pos[i].handle.exclaim_color();
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        // 随机站队
        q.random_queue();
        q.exclaim_name();
        System.out.println();
        System.out.println();

        // 冒泡排序, 报数报名称
        q.bubble_sort();
        q.exclaim_name();
        System.out.println();
        System.out.println();

        // 随机站队
        q.random_queue();
        q.exclaim_name();
        System.out.println();
        System.out.println();

        // 二分排序, 报数报颜色
        q.qsort(0, 6);
        q.exclaim_color();
    }
}

class Position {
    // index 作为位置下标, 开始为 1
    int index;
    Huluwa handle;

    // 构造函数
    Position(Huluwa hlw, int x) {
        this.handle = hlw; this.index = x;
    }

    // 借助 tmp 完成 this 和 change_with 位置上葫芦娃的交换
    // 调用 Huluwa 类的 hop 方法执行交换时的单体跳跃动作
    void exchange(Position change_with, Position tmp) {
        tmp.handle = this.handle;
        this.handle.hop(this.index, tmp.index);
        this.handle = change_with.handle;
        change_with.handle.hop(change_with.index, this.index);
        change_with.handle = tmp.handle;
        tmp.handle.hop(tmp.index, change_with.index);
    }
}