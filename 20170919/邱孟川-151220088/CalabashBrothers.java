package Homework2;
import java.util.*;

public class CalabashBrothers {
    private int numbers = 7;
    private ArrayList<Calabash> brothers;
    public CalabashBrothers(){
        brothers = new ArrayList<Calabash>();
        for(int i = 0; i < numbers; ++i)
            brothers.add(new Calabash(i));
        output();
    }

    /*输出数组中葫芦娃的排行和颜色*/
    private void output(){
        for(int i = 0; i < numbers; ++i)
            System.out.print(brothers.get(i).reportRank() + "(" + brothers.get(i).reportColor() +")" + " ");
        System.out.print("\n");
    }

    /*随机交换数组中两个元素的位置*/
    public void randomArrange(){
        for(int i = 0; i < brothers.size(); ++i){
            Random r = new Random();
            int randomNum = r.nextInt(numbers) % numbers;
            Calabash temp = brothers.get(i);
            brothers.set(i, brothers.get(randomNum));
            brothers.set(randomNum, temp);
        }
        output();
    }

    /*根据排行进行冒泡排序*/
    public void bubbleSort() {
        for (int i = brothers.size()-1; i > 0; --i) {
            for (int j = brothers.size() - 1; j >= brothers.size() - i; --j) {
                if (brothers.get(j).rankLessThan(brothers.get(j-1))) {
                    Calabash temp = brothers.get(j);
                    System.out.println(brothers.get(j).reportExchange(j, j - 1));
                    brothers.set(j, brothers.get(j - 1));
                    System.out.println(brothers.get(j - 1).reportExchange(j - 1, j));
                    brothers.set(j - 1, temp);
                }
            }
        }
        output();
    }

    /*根据颜色进行快排*/
    public void quickSort(){
        quickSortSub(0, brothers.size()-1);
    }

    private void quickSortSub(int begin, int end){
        if(begin >= end) return;

        Calabash pivot = brothers.get(begin);
        int pivotPosition = begin;
        for(int i = begin+1; i <= end; ++i){
            if(brothers.get(i).colorLessThan(pivot)) ++pivotPosition;
            else continue;

            if(i > pivotPosition){
                Calabash temp = brothers.get(i);
                System.out.println(brothers.get(i).reportExchange(i, pivotPosition));
                brothers.set(i, brothers.get(pivotPosition));
                System.out.println(brothers.get(pivotPosition).reportExchange(pivotPosition, i));
                brothers.set(pivotPosition, temp);
            }
        }

        if(begin != pivotPosition) {
            System.out.println(brothers.get(begin).reportExchange(begin, pivotPosition));
            brothers.set(begin, brothers.get(pivotPosition));
            System.out.println(brothers.get(pivotPosition).reportExchange(pivotPosition, begin));
            brothers.set(pivotPosition, pivot);
        }

        quickSortSub(begin, pivotPosition-1);
        quickSortSub(pivotPosition+1, end);

        if(end-begin == brothers.size()-1)
            output();
    }
}
