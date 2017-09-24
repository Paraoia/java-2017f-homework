import java.awt.*;
import java.util.Random;

public class HuLuWa {
    private enum color{
        红娃, 橙娃, 黄娃, 绿娃, 青娃, 蓝娃, 紫娃;
        public static color valueOfcolor(int value) {
            switch (value) {
                case 0:return color.红娃;
                case 1:return color.橙娃;
                case 2:return color.黄娃;
                case 3:return color.绿娃;
                case 4:return color.青娃;
                case 5:return color.蓝娃;
                case 6:return color.紫娃;
                default: return null;
            }
        }
    }

    private enum ranklist{
        老大, 老二, 老三, 老四, 老五, 老六, 老七;
        public static ranklist valueOfrank(int value) {
            switch (value) {
                case 0:return ranklist.老大;
                case 1:return ranklist.老二;
                case 2:return ranklist.老三;
                case 3:return ranklist.老四;
                case 4:return ranklist.老五;
                case 5:return ranklist.老六;
                case 6:return ranklist.老七;
                default: return null;
            }
        }
    }

    private class baby{
        public color Color;
        public ranklist Ranklist;
        public int Index;
    }
    private static final int MAX = 7;
    private static baby []brothers = new baby[MAX];

    private static void talk(baby bro, int from, int to, boolean mode){
        if(mode == true) {
            System.out.print(bro.Ranklist);
            System.out.print(':');
            System.out.println(Integer.toString(from) + "->" + Integer.toString(to));
        }
        else if(mode == false) {
            System.out.print(bro.Color);
            System.out.print(':');
            System.out.println(Integer.toString(from) + "->" + Integer.toString(to));
        }
    }

    public void bubbleSort(){
        for(int i = 0; i < MAX; ++i){
            for(int j = 1; j < MAX; ++j){
                if(brothers[j].Ranklist.compareTo(brothers[j-1].Ranklist) < 0){
                    baby temp = brothers[j];
                    brothers[j] = brothers[j-1];
                    brothers[j-1] = temp;
                    talk(brothers[j], j-1, j, true);
                }
            }
        }
        displayRank(true);
    }

    private static class dichotomySort{
        public static int partition(baby []array,int lo,int hi){
            baby key = array[lo];
            int startPosition = lo;
            while(lo < hi){
                while(array[hi].Color.compareTo(key.Color) > 0 && hi>lo)
                    hi--;
                array[lo] = array[hi];
                if(lo != hi)
                    talk(array[lo], hi, lo, false);
                while(array[lo].Color.compareTo(key.Color) < 0 && hi>lo)
                    lo++;
                array[hi] = array[lo];
                if(lo != hi)
                    talk(array[hi], lo, hi, false);
            }
            array[hi] = key;
            int endPosition = hi;
            if(startPosition != endPosition)
                talk(key, startPosition, endPosition, false);
            return hi;
        }

        public static void Sort(baby[] array,int lo ,int hi){
            if(lo >= hi){
                return;
            }
            int index = partition(array,lo,hi);
            Sort(array,lo,index-1);
            Sort(array,index+1,hi);
        }
    }

    public void quickSort(){
        dichotomySort.Sort(brothers, 0 , MAX - 1);
        displayRank(false);
    }

    public void randStand(boolean mode){
        for(int i = 0; i < MAX; ++i){
            brothers[i] = new baby();
        }
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
            brothers[i].Index = temp[i];
        }
        System.out.println("=====重新排列=====");
        displayRank(mode);
    }

    private static void displayRank(boolean mode){
        if(mode == true) {
            for (baby i : brothers) {
                System.out.print(i.Ranklist);
                System.out.print(" ");
            }
            System.out.println();
        }
        else{
            for (baby i : brothers) {
                System.out.print(i.Color);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
