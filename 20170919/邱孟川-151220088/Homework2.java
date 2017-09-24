package Homework2;
import java.util.Random;

enum Color{RED, ORIGIN, YELLOW, GREEN, CYAN, BLUE, PURPLE};
enum Rank{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN};

class CalabashBrother{
    private static String[] rankArray = {"老大","老二", "老三", "老四", "老五", "老六", "老七"};
    private static String[] colorArray = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
    public Rank rank;
    public Color color;

    public CalabashBrother(Rank rank, Color color){
        this.rank = rank;
        this.color = color;
    }
    public void reportRank(){
        System.out.println(rankArray[rank.ordinal()]);
    }
    public void reportColor(){
        System.out.println(colorArray[color.ordinal()]);
    }
    public void reportExchange(int src, int dst){
        System.out.println(rankArray[rank.ordinal()] + ": " + src + "->" + dst);
    }
}

public class Homework2 {
    public static void main(String[] args){
        CalabashBrother[] brothers = {
                new CalabashBrother(Rank.ONE, Color.RED), new CalabashBrother(Rank.TWO, Color.ORIGIN),
                new CalabashBrother(Rank.THREE, Color.YELLOW), new CalabashBrother(Rank.FOUR, Color.GREEN),
                new CalabashBrother(Rank.FIVE, Color.CYAN), new CalabashBrother(Rank.SIX, Color.BLUE),
                new CalabashBrother(Rank.SEVEN, Color.PURPLE)
        };

        randomArrange(brothers);
        bubbleSort(brothers);
        randomArrange(brothers);
        quickSort(brothers, 0,brothers.length-1);
    }

    private static void bubbleSort(CalabashBrother[] brothers){
        for(int i = brothers.length-1; i > 0; --i){
            for(int j = brothers.length-1; j >= brothers.length-i; --j){
                if(brothers[j].rank.ordinal() < brothers[j-1].rank.ordinal()){
                    CalabashBrother temp = brothers[j];
                    brothers[j].reportExchange(j, j-1);
                    brothers[j] = brothers[j-1];
                    brothers[j-1].reportExchange(j-1,j);
                    brothers[j-1] = temp;
                }
            }
        }

        for(int i = 0; i < brothers.length; ++i)
            brothers[i].reportRank();
    }
    private static void quickSort(CalabashBrother[] brothers, int begin, int end){
        if(begin >= end) return;

        CalabashBrother pivot = brothers[begin];
        int pivotPosition = begin;
        for(int i = begin+1; i <= end; ++i){
            if(brothers[i].color.ordinal() < pivot.color.ordinal()) ++pivotPosition;
            else continue;

            if(i > pivotPosition){
                CalabashBrother temp = brothers[i];
                brothers[i].reportExchange(i, pivotPosition);
                brothers[i] = brothers[pivotPosition];
                brothers[pivotPosition].reportExchange(pivotPosition, i);
                brothers[pivotPosition] = temp;
            }
        }

        if(begin != pivotPosition) {
            brothers[begin].reportExchange(begin, pivotPosition);
            brothers[begin] = brothers[pivotPosition];
            brothers[pivotPosition].reportExchange(pivotPosition, begin);
            brothers[pivotPosition] = pivot;
        }

        quickSort(brothers, begin, pivotPosition-1);
        quickSort(brothers, pivotPosition+1, end);

        if(end-begin == brothers.length-1){
            for(int i = begin; i <= end; ++i)
                brothers[i].reportColor();
        }
    }

    private static void randomArrange(CalabashBrother[] brothers){
        for(int i = 0; i < brothers.length; ++i){
            Random r = new Random();
            int randomNum = r.nextInt(7) % 7;
            CalabashBrother temp = brothers[randomNum];
            brothers[randomNum] = brothers[i];
            brothers[i] = temp;
        }
    }
}
