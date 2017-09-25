public class HuluBrothers {
    Huluwa[] brothers = new Huluwa[7];
    void initialize(){
        brothers[0] = new Huluwa(4);
        brothers[1] = new Huluwa(6);
        brothers[2] = new Huluwa(0);
        brothers[3] = new Huluwa(3);
        brothers[4] = new Huluwa(1);
        brothers[5] = new Huluwa(5);
        brothers[6] = new Huluwa(2);
    }

    public void BubbleSort(){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6-i; j++) {
                if (brothers[j].order.compareTo(brothers[j + 1].order) > 0) {
                    Huluwa tmp = brothers[j];
                    System.out.println(brothers[j].order + ":" + (j+1) +"->" + (j+2));
                    System.out.println(brothers[j+1].order + ":" + (j+2) +"->" + (j+1));
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
            if (first != last)
                System.out.println(brothers[last].order + ":" + (last+1) + "->" + (first+1));

            while (first < last && a[first].color.compareTo(key.color) < 0)
                ++first;
            a[last] = a[first];
            if (first != last)
                System.out.println(brothers[first].order + ":" + (first+1) + "->" + (last+1));
        }
        a[first] = key;
        if (first != low)
            System.out.println(key.order + ":" + (low+1) + "->" + (first+1));
        QuickSort(a, low, first - 1);
        QuickSort(a, first + 1, high);
    }

    public static void main(String[] args){
        HuluBrothers bro = new HuluBrothers();
        bro.initialize();
        bro.BubbleSort();
        for(int i = 0; i < 7; i++)
            System.out.print(bro.brothers[i].order + " ");
        System.out.print("\n");
        bro.initialize();
        bro.QuickSort(bro.brothers, 0, 6);
        for(int i = 0; i < 7; i++)
            System.out.print(bro.brothers[i].color + " ");
        System.out.print("\n");
    }
}
