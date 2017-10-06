import java.util.Random;

public class StandList {
    CalabashBro[] list;
    int[] before_seq;
    int list_length;
    StandList(){
        list = new CalabashBro[7];
        before_seq = new int[7];
        for(int i = 0; i < list.length; i++)
            list[i] = new CalabashBro(i);
        list_length = list.length;
        RandomList();
    }
    void RandomList(){
        int alreadyCount = 0;
        for(int i = 0; i < before_seq.length; i++)
            before_seq[i] = list_length;
        while(alreadyCount < list_length){
            int RNG = new Random().nextInt();
            RNG = Math.abs(RNG) % list_length;
            if(before_seq[RNG] == list_length){
                before_seq[RNG] = alreadyCount;
                alreadyCount++;
            }
        }
    }
    void PrintList(int signature){
        if(signature == 0) {
            for (int i = 0; i < before_seq.length; i++) {
                System.out.println(list[before_seq[i]].getName());
            }
        }
        else if(signature == 1){
            for (int i = 0; i < before_seq.length; i++) {
                System.out.println(list[before_seq[i]].getColor());
            }
        }
    }
    void bubbleSort(){
        for(int i = 0; i < before_seq.length - 1; i++){
            for(int j = 0; j < before_seq.length - i - 1; j++){
                if(CalabashBro.isGreater(list[before_seq[j]], list[before_seq[j+1]], 0)){
                    int temp = before_seq[j];
                    before_seq[j] = before_seq[j+1];
                    before_seq[j+1] = temp;
                    System.out.println(list[before_seq[j]].getName() + ": " + j + "->" + (j+1));
                    System.out.println(list[before_seq[j+1]].getName() + ": " + (j+1) + "->" + j);
                }
            }
        }
    }
    void dichotomySort(int beg, int end){
        if(beg >= end - 1)  return;
        int mid = (beg + end) / 2;
        dichotomySort(beg, mid);
        dichotomySort(mid, end);
        int[] templist = new int[end - beg];
        int former = beg;
        int latter = mid;
        for(int i = 0; i < end - beg; i++){
            if(latter >= end){
                for(; former < mid; former++){
                    templist[i] = before_seq[former];
                    if(former != i+beg)
                        System.out.println(list[templist[i]].getName() + ": " + former + "->" + (i+beg));
                    i++;
                }
            }
            else if(former >= mid){
                for(; latter < end; latter++){
                    templist[i] = before_seq[latter];
                    if(latter != i+beg)
                        System.out.println(list[templist[i]].getName() + ": " + latter + "->" + (i+beg));
                    i++;
                }
            }
            else if(CalabashBro.isGreater(list[before_seq[former]], list[before_seq[latter]], 1)){
                templist[i] = before_seq[latter];
                if(latter != i+beg)
                    System.out.println(list[templist[i]].getName() + ": " + latter + "->" + (i+beg));
                latter++;
            }
            else{
                templist[i] = before_seq[former];
                if(former != i+beg)
                    System.out.println(list[templist[i]].getName() + ": " + former + "->" + (i+beg));
                former++;
            }
        }
        for(int i = 0; i < end - beg; i++)
            before_seq[i + beg] = templist[i];
    }
    public static void main(String[] args){
        StandList list = new StandList();
        list.PrintList(0);
        list.bubbleSort();
        list.PrintList(0);
        System.out.println();
        list.RandomList();
        list.PrintList(0);
        list.dichotomySort(0,list.list_length);
        list.PrintList(1);
    }
}
