public class HuluwaSort {
    // seven Huluwas
    private Huluwa []huluwas;

    // constructor
    HuluwaSort() {
        initHuluwas();
    }

    // init all Huluwas
    private void initHuluwas() {
        huluwas = new Huluwa[7];
        huluwas[0] = new Huluwa(0, "大娃", "赤");
        huluwas[1] = new Huluwa(1, "二娃", "橙");
        huluwas[2] = new Huluwa(2, "三娃", "黄");
        huluwas[3] = new Huluwa(3, "四娃", "绿");
        huluwas[4] = new Huluwa(4, "五娃", "青");
        huluwas[5] = new Huluwa(5, "六娃", "蓝");
        huluwas[6] = new Huluwa(6, "七娃", "紫");
    }

    // swap 2 Huluwas' position
    private void swap(int i, int j) {
        Huluwa tmp = huluwas[i];
        huluwas[i] = huluwas[j];
        huluwas[j] = tmp;
    }

    // report changes and swap
    private void swapReport(int i, int j) {
        if (i == j) return;
        System.out.println(huluwas[i].getName() + ": " + i + "->" + j);
        System.out.println(huluwas[j].getName() + ": " + j + "->" + i);
        swap(i, j);
    }

    // disorganize the order
    public void disorganize() {
        for (int i = 0; i < 7; ++i) {
            int j = (int)(Math.random() * 7);
            swap(i, j);
        }
    }

    // bubble sort
    public void bubbleSort() {
        Huluwa tmp;
        int i, j, len = huluwas.length;
        for (i = 0; i < len - 1; ++i) {
            for (j = 0; j < len - i - 1; ++j) {
                if (huluwas[j].getNo() > huluwas[j + 1].getNo()) {
                    swapReport(j, j + 1);
                }
            }
        }
    }

    // quick sort wrapper
    public void quickSort() {
        qsort(0, huluwas.length - 1);
    }

    // do quick sort recursion
    private void qsort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            qsort(p, q - 1);
            qsort(q + 1, r);
        }
    }

    // quick sort partition
    private int partition(int p, int r) {
        Huluwa tmp = huluwas[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (huluwas[j].getNo() <= tmp.getNo()) {
                ++i;
                swapReport(i, j);
            }
        }
        swapReport(i + 1, r);
        return i + 1;
    }

    // report each name
    public void reportName() {
        for (Huluwa tmp: huluwas) {
            System.out.println(tmp.getName());
        }
    }

    // report each color
    public void reportColor() {
        for (Huluwa tmp: huluwas) {
            System.out.println(tmp.getColor());
        }
    }
}
