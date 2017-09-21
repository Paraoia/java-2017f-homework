import java.util.Random;

public class Array {
    Huluwa[] arr;           // 类型为基类的葫芦娃数组

    Array() {               // 初始化创建Array类时创建七兄弟并存于数组中
        First one = new First();
        Second two = new Second();
        Third three = new Third();
        Fourth four = new Fourth();
        Fifth five = new Fifth();
        Sixth six = new Sixth();
        Seventh seven = new Seventh();
        arr = new Huluwa[] {one, two, three, four, five, six, seven};
    }

    /* 七兄弟随意站队 */
    void random_queue() {
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int p = random.nextInt(7);
            Huluwa tmp = arr[i];
            arr[i] = arr[p];
            arr[p] = tmp;
        }
        random = null;
    }

    /* 冒泡排序 */
    void bubble_sort() {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6 - i; j++)
                if (arr[j].getNO() > arr[j + 1].getNO()) {
                    Huluwa tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    arr[j + 1].exclaim_no();
                    System.out.println(": " + (j + 1) + "->" + (j + 2));
                    arr[j].exclaim_no();
                    System.out.println(": " + (j + 2) + "->" + (j + 1));
                }
    }

    /* 快速(二分)排序 */
    private int partition(int left, int right) {
        Huluwa key = arr[left];
        int t_no = left;
        while (left < right) {
            while (left < right && arr[right].getNO() >= key.getNO()) --right;
            arr[left] = arr[right];

            if (left != right) {        // 如果排序前后位置不变, 不用报告动作交换
                arr[left].exclaim_no();
                System.out.println(": " + (right + 1) + "->" + (left + 1));
            }

            while (left < right && arr[left].getNO() <= key.getNO()) ++left;
            arr[right] = arr[left];

            if (left != right) {
                arr[right].exclaim_no();
                System.out.println(": " + (left + 1) + "->" + (right + 1));
            }
        }
        arr[left] = key;

        if (left != right) {
            key.exclaim_no();
            System.out.println(": " + (t_no + 1) + "->" + (left + 1));
        }
        return left;
    }

    public void qsort(int left, int right) {
        if (left < right) {
            int index = partition(left, right);
            qsort(left, index - 1);
            qsort(index + 1, right);
        }
    }

    /* 调用每个葫芦娃重载的报数函数报数 */
    void exclaim_no() {

        for (int i = 0; i < 7; i++) arr[i].exclaim_no();
    }

    /* 调用每个葫芦娃重载的报颜色函数报数 */
    void exclaim_color() {
        for (int i = 0; i < 7; i++) arr[i].exclaim_color();
    }

    public static void main(String[] args) {
        Array hlw = new Array();

        hlw.random_queue();
        // 消去注释可查看随机站位
//        hlw.exclaim_no();
//        System.out.println();
        hlw.bubble_sort();
        hlw.exclaim_no();
        System.out.println();
        System.out.println();
        hlw.random_queue();
//        hlw.exclaim_no();
//        System.out.println();
        hlw.qsort(0, 6);
        hlw.exclaim_color();
    }
}
