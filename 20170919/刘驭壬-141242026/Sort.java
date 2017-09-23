import java.util.List;

public class Sort {
    public void bubbleSort(Hulubros h){
        List<Huluwa> bros = h.getBros();
        int size = bros.size();
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-1-i; j++) {
                if (bros.get(j).getRank() > bros.get(j + 1).getRank()) {
                    h.swap(j, j + 1);
                }
            }
        }
    }

    public void quickSort(Hulubros h){
        List<Huluwa> bros = h.getBros();
        int begin = 0;
        int end = bros.size() - 1;
        qsort(h, begin, end);
    }
    void qsort(Hulubros h, int a, int b){
        List<Huluwa> bros = h.getBros();
        if (b - a <= 0){
            return;
        }
        int index = partition(h, a, b);
        qsort(h, a, index-1);
        qsort(h, index+1, b);
    }

    int partition(Hulubros h, int a, int b){
        List<Huluwa> bros = h.getBros();
        int len = b - a + 1;
        int p = (int)(Math.random() * len + a);
        h.swap(p, b);
        int index = a - 1;
        for (int i = a; i <= b; i++){
            if (bros.get(i).getRank() < bros.get(b).getRank()){
                index += 1;
                h.swap(index, i);
            }
        }
        index += 1;
        h.swap(index, b);
        return index;
    }
}
