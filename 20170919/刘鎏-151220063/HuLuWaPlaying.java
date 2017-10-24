import java.util.Random;

public class HuLuWaPlaying{

    public static final int MAX = 7; //规定最多7个葫芦娃
    public static HuLuWa []brothers; //全局变量 7兄弟

    public HuLuWaPlaying(){ //构造函数 分配空间
        brothers = new HuLuWa[MAX];
        for(int i = 0; i < MAX; ++i){
            brothers[i] = new HuLuWa();
        }
    }

    public void bubbleSort(){ //冒泡排序
        for(int i = 0; i < MAX; ++i){
            for(int j = 1; j < MAX; ++j){
                if(brothers[j].Ranklist.compareTo(brothers[j-1].Ranklist) < 0){
                    HuLuWa temp = brothers[j];
                    brothers[j] = brothers[j-1];
                    brothers[j-1] = temp;
                    HuLuWa.talk(brothers[j], j-1, j, true);
                }
            }
        }
    }

    private static class dichotomySort{//快速排序类
        public static int partition(HuLuWa[]array, int lo, int hi){
            HuLuWa key = array[lo];
            int startPosition = lo;
            while(lo < hi){
                while(array[hi].Color.compareTo(key.Color) > 0 && hi>lo)
                    hi--;
                array[lo] = array[hi];
                if(lo != hi)
                    HuLuWa.talk(array[lo], hi, lo, false);
                while(array[lo].Color.compareTo(key.Color) < 0 && hi>lo)
                    lo++;
                array[hi] = array[lo];
                if(lo != hi)
                    HuLuWa.talk(array[hi], lo, hi, false);
            }
            array[hi] = key;
            int endPosition = hi;
            if(startPosition != endPosition)
                HuLuWa.talk(key, startPosition, endPosition, false);
            return hi;
        }
        public static void Sort(HuLuWa[] array, int lo , int hi){
            if(lo >= hi){
                return;
            }
            int index = partition(array,lo,hi);
            Sort(array,lo,index-1);
            Sort(array,index+1,hi);
        }
    }

    public void quickSort(){//快速排序入口
        dichotomySort.Sort(brothers, 0 , MAX - 1);
    }

    public void randStand(boolean mode){//随机站队
        int[] temp = new int[MAX];
        for (int i = 0; i < MAX; i++)
            temp[i] = i;
        Random rand = new Random();
        for (int i = 0; i < MAX; i++) {
            int w = rand.nextInt(MAX - i) + i;
            int t = temp[i];
            temp[i] = temp[w];
            temp[w] = t;
            brothers[i].Ranklist = ranklist.valueOfrank(temp[i]);
            brothers[i].Color = color.valueOfcolor(temp[i]);
        }
        System.out.println("=====重新排列=====");
        displayRank(mode);
    }

    public void displayRank(boolean mode){//开始和结束时说明位置
        if(mode == true) {
            for (HuLuWa i : brothers) {
                System.out.print(i.Ranklist);
                System.out.print(" ");
            }
            System.out.println();
        }
        else{
            for (HuLuWa i : brothers) {
                System.out.print(i.Color);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}