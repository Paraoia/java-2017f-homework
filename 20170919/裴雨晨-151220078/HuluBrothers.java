import java.util.Random;
public class HuluBrothers {
    Huluwa[] brothers = new Huluwa[7];

    //葫芦兄弟构造函数
    void initialize(){
        //随机排序
        int[] a = new int[7];
        for(int i = 0; i < 7; i++)
            a[i] = i;
        Random random = new Random();
        for(int i = 0; i < 7; i++){
            int j = random.nextInt(7);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        for(int i = 0; i < 7; i++)
            brothers[i] = new Huluwa(a[i]);
    }
    /*
    void initialize(){
        brothers[0] = new Huluwa(4);
        brothers[1] = new Huluwa(6);
        brothers[2] = new Huluwa(0);
        brothers[3] = new Huluwa(3);
        brothers[4] = new Huluwa(1);
        brothers[5] = new Huluwa(5);
        brothers[6] = new Huluwa(2);
    }
    */

    public void BubbleSort(){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6-i; j++) {
                if (brothers[j].order.compareTo(brothers[j + 1].order) > 0) {
                    Huluwa tmp = brothers[j];
                    //报告交换
                    brothers[j].getOrder();
                    brothers[j].changePos(j, j+1);
                    brothers[j+1].getOrder();
                    brothers[j+1].changePos(j+1, j);
                    //交换位置
                    brothers[j] = brothers[j+1];
                    brothers[j+1] = tmp;
                }
            }
        }

    }

    public void QuickSort(Huluwa[] a, int low, int high) {
        if (low >= high)
            return;
        int first = low;
        int last = high;
        Huluwa key = a[first];

        while (first < last) {
            while (first < last && a[last].color.compareTo(key.color) > 0)
                --last;
            a[first] = a[last];
            if (first != last){
                brothers[last].getOrder();
                brothers[last].changePos(last, first);
            }
                //System.out.println(brothers[last].order + ":" + last + "->" + first);

            while (first < last && a[first].color.compareTo(key.color) < 0)
                ++first;
            a[last] = a[first];
            if (first != last){
                brothers[first].getOrder();
                brothers[first].changePos(first,last);
            }
                //System.out.println(brothers[first].order + ":" + first + "->" + last);
        }
        a[first] = key;
        if (first != low){
            key.getOrder();
            key.changePos(low, first);
        }
            //System.out.println(key.order + ":" + low + "->" + first);
        QuickSort(a, low, first - 1);
        QuickSort(a, first + 1, high);
    }

    void printColor(){
        for(int i = 0; i < 7; i++)
            brothers[i].getColor();
        System.out.print("\n");
    }

    void printOrder(){
        for(int i = 0; i < 7; i++)
            brothers[i].getOrder();
        System.out.print("\n");
    }

    public static void main(String[] args){
        HuluBrothers bro = new HuluBrothers();
        //随机排序
        bro.initialize();
        bro.printOrder();

        //冒泡排序
        bro.BubbleSort();
        bro.printOrder();

        //随机排序
        bro.initialize();
        bro.printColor();

        //快速排序
        bro.QuickSort(bro.brothers, 0, 6);
        bro.printColor();
    }
}
