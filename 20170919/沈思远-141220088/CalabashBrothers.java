/**
 * Created by NJU on 2017/9/20.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
enum Rank{老大, 老二, 老三, 老四, 老五, 老六, 老七};
enum Color{红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色};
class Calabash{
    Rank rank;
    Color color;
    Calabash(Rank rank, Color color){
        this.rank = rank;
        this.color = color;
    }
    Rank getRank(){return rank;}
    Color getColor(){return color;}
    int compareByRank(Calabash c){
        return rank.compareTo(c.rank);
    }
    int compareByColor(Calabash c){
        return color.compareTo(c.color);
    }
}
public class CalabashBrothers {
    Calabash[] brothers;
    CalabashBrothers(){
        brothers = new Calabash[7];
        brothers[0] = new Calabash(Rank.老大, Color.红色);
        brothers[1] = new Calabash(Rank.老二, Color.橙色);
        brothers[2] = new Calabash(Rank.老三, Color.黄色);
        brothers[3] = new Calabash(Rank.老四, Color.绿色);
        brothers[4] = new Calabash(Rank.老五, Color.青色);
        brothers[5] = new Calabash(Rank.老六, Color.蓝色);
        brothers[6] = new Calabash(Rank.老七, Color.紫色);
    }
    void initialize(){
        List l = Arrays.asList(brothers);
        Collections.shuffle(l);
        brothers = (Calabash[])l.toArray();
    }
    void declareRanks(){
        for(int i = 0;i < brothers.length;i++)
            System.out.print(brothers[i].getRank() + " ");
        System.out.println();
    }
    void declareColors(){
        for(int i = 0;i < brothers.length;i++)
            System.out.print(brothers[i].getColor() + " ");
        System.out.println();
    }
    void displaySwapInfo(int begin,int end){
        System.out.print(brothers[begin].getRank() + ": " + begin + "->" + end);
    }
    void swap(int i, int j){
        displaySwapInfo(i,j);
        System.out.print("\t");
        displaySwapInfo(j,i);
        System.out.println();
        Calabash temp = brothers[i];
        brothers[i] = brothers[j];
        brothers[j] = temp;
    }
    void bubbleSortByRank(){
        for(int i = 0;i < brothers.length;i++)
            for(int j = 0;j < brothers.length - i - 1;j++)
                if(brothers[j].compareByRank(brothers[j + 1]) > 0){
                    swap(j,j + 1);
                }
    }
    void binarySortByColor(){
        for(int i = 1;i < brothers.length;i++){
            int low = 0;
            int high = i - 1;
            int middle;
            while(low<=high){
                middle = (low + high)/2;
                if(brothers[i].compareByColor(brothers[middle]) > 0)
                    low = middle + 1;
                else
                    high = middle - 1;

            }
            for(int j = i;j > low;j--)
                swap(j - 1,j);
        }
    }
    public static void main(String[] args){
        CalabashBrothers c = new CalabashBrothers();

        c.initialize();
        //c.declareRanks();
        c.bubbleSortByRank();
        //c.binarySortByColor();
        c.declareRanks();

        c.initialize();
        //c.declareRanks();
        c.binarySortByColor();
        c.declareColors();
    }


}
