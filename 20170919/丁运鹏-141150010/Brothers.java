import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Brothers {
    Calabash_Bro[] bros = new Calabash_Bro[7];
    Brothers() {
        for(int i = 0; i < bros.length; i++) {
            bros[i] = new Calabash_Bro();
        }
    }
    public void random_posi() {
        Scanner sc = new Scanner(System.in);
        System.out.print("随机次序：");
        boolean[] flag = new boolean[7];
        for(int i = 0; i < flag.length; i++)
            flag[i] = false;
        for(int i = 0; i < bros.length; i++) {
//            int rank = sc.nextInt();
            Random rand = new Random();
            int rank = 0;
            do {
                rank = Math.abs(rand.nextInt()) % 7;
            }while(flag[rank]);
            flag[rank] = true;
            bros[i].Set_posi(rank + 1, i);
        }
    }
    public void All_sounding(int type) {
        System.out.print("报数：");
        if(type == 0)
            for(int i = 0; i < bros.length; i++)
                bros[i].Sounding();
        else
            for(int i = 0; i < bros.length; i++)
                bros[i].Sounding_Colour();
        System.out.println();
    }
    public void BubbleSort() {
        for(int i = 0; i < bros.length; i++)
            for(int j = 0; j < bros.length - i - 1; j++) {
                if(bros[j].rank > bros[j+1].rank) {
                    Calabash_Bro temp = bros[j];
                    int temp_p = temp.posi;
                    bros[j].Change_pos(bros[j+1].posi);
                    bros[j+1].Change_pos(temp_p);
                    bros[j] = bros[j+1];
                    bros[j+1] = temp;
                }
            }
    }
    private int Partition(Calabash_Bro[] A, int first, int last) {
        int pivot = A[last].rank;
        int i = first - 1, j = 0;
        for(j = first; j < last; j++)
            if(A[j].rank < pivot) {
                i++;
                if(i != j) {
                    Calabash_Bro temp = A[j];
                    int temp_p = temp.posi;
                    A[j].Change_pos(A[i].posi);
                    A[i].Change_pos(temp_p);
                    A[j] = A[i];
                    A[i] = temp;
                }
            }
        if(last == i+1)
            return i+1;
        Calabash_Bro temp = A[last];
        int temp_p = temp.posi;
        A[last].Change_pos(A[i+1].posi);
        A[i+1].Change_pos(temp_p);
        A[last] = A[i+1];
        A[i+1] = temp;
        return i+1;
    }

    public void BinarySort(Calabash_Bro[] A, int first, int last) {
        if(first < last) {
            int pivot_pos = Partition(A, first, last);
            BinarySort(A, first, pivot_pos - 1);
            BinarySort(A, pivot_pos + 1, last);
        }
    }
}
