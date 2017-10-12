package hulu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hulubros {
    private List<Huluwa> bros;

    Hulubros(){
        bros = new ArrayList<Huluwa>();
        String[] names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
        String[] colors = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
        for (int i = 0; i < 7; i++){
            bros.add(new Huluwa(names[i], colors[i], i+1));
        }
        shuffle();
    }

    public void shuffle(){
        //printName();
        Collections.shuffle(bros);
        //printName();
    }


    public void swap(int index1, int index2){
        Huluwa h1 = bros.get(index1);
        Huluwa h2 = bros.get(index2);
        System.out.printf("%s: %d->%d ", h1.getName(), index1, index2);
        System.out.printf("%s: %d->%d\n", h2.getName(), index2, index1);
        Huluwa temp = h1;
        bros.set(index1, h2);
        bros.set(index2, temp);

    }

    public void bubbleSort(){
        int size = bros.size();
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-1-i; j++) {
                if (bros.get(j).getRank() > bros.get(j + 1).getRank()) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void quickSort(){
        int begin = 0;
        int end = bros.size() - 1;
        qsort(begin, end);
    }
    void qsort(int a, int b){
        if (b - a <= 0){
            return;
        }
        int index = partition(a, b);
        qsort(a, index-1);
        qsort(index+1, b);
    }

    int partition(int a, int b){
        int len = b - a + 1;
        int p = (int)(Math.random() * len + a);
        swap(p, b);
        int index = a - 1;
        for (int i = a; i <= b; i++){
            if (bros.get(i).getRank() < bros.get(b).getRank()){
                index += 1;
                swap(index, i);
            }
        }
        index += 1;
        swap(index, b);
        return index;
    }

    public void printName(){
        for (Huluwa x : bros){
            System.out.print(x.getName() + " ");
        }
        System.out.print("\n");
    }

    public void printColor() {
        for (Huluwa x : bros) {
            System.out.print(x.getColor() + " ");
        }
        System.out.print("\n");
    }

    public List<Huluwa> getBros() {
        return bros;
    }
}
