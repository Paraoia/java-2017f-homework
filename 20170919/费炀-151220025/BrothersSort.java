public class BrothersSort {
    Calabash[] brothers = new Calabash[8];
    void initialize() {
        int[] a = {3, 4, 6, 1, 7, 2, 5};
/*        System.out.println("请输入初始排序：");
        for (int i = 0; i < 7; i++) {
            a[i] = 0;
            try {
                a[i] = System.in.read();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
*/
        for (int i = 1; i <= 7; i++) {
            brothers[i] = new Calabash(a[i-1], i);
//            System.out.println(brothers[i].get_name());
        }
    }
    void bubblesort() {
        for(int i = 1; i <= 6; i++) {
            for(int j = 1; j <= 7-i; j++) {
                if (brothers[j].get_name() > brothers[j + 1].get_name()) {
                    brothers[j].move(j + 1);
                    brothers[j + 1].move(j);
                    Calabash temp = brothers[j];
                    brothers[j] = brothers[j + 1];
                    brothers[j + 1] = temp;
                }
            }
        }
    }
    void quicksort(int first, int last) {
        if(first >= last)
            return;
        Calabash pivot = brothers[first];
        int pos = first;
        Calabash temp;
        for (int i = first + 1; i <= last; i++) {
            if(brothers[i].get_name() < pivot.get_name()) {
                if(i != pos + 1) {
                    brothers[i].move(pos + 1);
                    brothers[pos + 1].move(i);
                    temp = brothers[i];
                    brothers[i] = brothers[pos + 1];
                    brothers[pos + 1] = temp;
                }
                pos++;
            }
        }
        if(pos != first) {
            brothers[first].move(pos);
            brothers[pos].move(first);
            brothers[first] = brothers[pos];
            brothers[pos] = pivot;
        }
        quicksort(first, pos - 1);
        quicksort(pos + 1, last);
    }
    void print() {
        for(int i = 1; i <= 7; i++) {
            brothers[i].print_name();
        }
        System.out.println();
    }
    public static void main(String args[]) {
        BrothersSort brother = new BrothersSort();
        brother.initialize();
        brother.bubblesort();
        brother.print();
        brother.initialize();
        brother.quicksort(1,7);
        brother.print();
    }
}
