package HuluWaSort;
import java.util.Random;

public class Main {
    public static void main(String args[]){
        HuluWa[] huluWas = new HuluWa[7];
        huluWas[0] = new HuluWa(0,"老大","红色");
        huluWas[1] = new HuluWa(1,"老二","橙色");
        huluWas[2] = new HuluWa(2,"老三","黄色");
        huluWas[3] = new HuluWa(3,"老四","绿色");
        huluWas[4] = new HuluWa(4,"老五","青色");
        huluWas[5] = new HuluWa(5,"老六","蓝色");
        huluWas[6] = new HuluWa(6,"老七","紫色");

        chaos(huluWas, 7);

        bubbleSort(huluWas, 7);
        System.out.println();

        for(int i = 0; i < 7; i++)
            huluWas[i].sayOrderName();
        System.out.println();

        chaos(huluWas, 7);

        quickSort(huluWas,0,6);
        System.out.println();
        for(int i = 0; i < 7; i++)
            huluWas[i].sayColorName();
    }
    public static void chaos(HuluWa[] arr, int len){
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            int index1 = random.nextInt(len - 1);
            int index2 = random.nextInt(len - 1);
            HuluWa tmp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = tmp;
        }
    }
    public static void swap(HuluWa[] arr, int h1, int h2){
        if(h1 == h2) return;

        arr[h1].report(h1,h2);
        arr[h2].report(h2,h1);

        HuluWa tmp = arr[h1];
        arr[h1] = arr[h2];
        arr[h2] = tmp;

    }
    public static void bubbleSort(HuluWa[] arr, int len){
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - 1; j++){
                if(arr[j].value > arr[j + 1].value){
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    public static void quickSort(HuluWa[] arr, int l, int r) {
        if (l >= r) return;

        int middle = l;
        int split = l;
        for (int i = middle + 1; i <= r; i++) {
            if (arr[middle].value > arr[i].value) {
                split++;
                swap(arr, split, i);
            }
        }

        swap(arr, split, middle);
        middle = split;

        quickSort(arr, l, middle - 1);
        quickSort(arr, middle + 1, r);
    }
}
