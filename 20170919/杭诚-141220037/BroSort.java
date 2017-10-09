import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by joker on 17-9-26.
 */
public class BroSort {
    private List<Brother> list= new ArrayList<>();
    BroSort(){
        for(int i = 0; i < 7; i ++)
            list.add(new Brother(i+1));
    }

    public void shuffle(){
        Collections.shuffle(list);
    }
    public void printColor(){
        for(int i = 0; i < 7; i++)
            System.out.println(list.get(i).getColor());
    }
    public void printName(){
        for(int i = 0; i < 7; i++)
            System.out.println(list.get(i).getName());
    }
    public void bubbleSort(){
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = 0; j < list.size() - i - 1; j ++){
                if(list.get(j).getNum() > list.get(j+1).getNum()){
                    System.out.print(list.get(j).getName() + ":" + j + "->" + (j + 1)+"  ");
                    System.out.println( list.get(j + 1).getName() + ":" + (j + 1) + "->" + j);
                    Brother temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    private int partition(int low, int high) {
        Brother pivot = list.get(low);
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && list.get(right).getNum()>= pivot.getNum()) {
                right--;
            }
            while (left < right && list.get(left).getNum() <= pivot.getNum()) {
                left++;
            }
            if (left < right) {
                Brother tmp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, tmp);
                System.out.println("Brother " + list.get(left).getName() + ":" + left + "->" + right);
                System.out.println("Brother " + list.get(right).getName() + ":" + right + "->" + left);
            }
        }
        list.set(low, list.get(left));
        list.set(left, pivot);
        return left;

    }
    public void sort(int low, int high) {
        if (low < high) {
            int p = partition( low, high);
            sort(  low, p - 1);
            sort( p + 1, high);
        }
    }

    public  void quickSort() {
        sort( 0, list.size() - 1);
    }
 }

