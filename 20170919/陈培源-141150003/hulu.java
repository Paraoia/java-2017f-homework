import java.util.Random;
enum Colour{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE}
enum Rank{FIRST,SECOND,THIRD,FORTH,FIFTH,SIXTH,SEVENTH}
class huluwa{
    private static String[] rankArray={"老大","老二","老三", "老四", "老五", "老六", "老七"};
    private static String[] colourArray={"红", "橙", "黄", "绿", "青", "蓝", "紫"};
    public Rank rank;
    public Colour colour;
    public huluwa(Rank rank,Colour colour){
        this.rank=rank;
        this.colour=colour;
    }
    public void getRank() {
        System.out.println(rankArray[rank.ordinal()]);
    }
    public void getColour() {
        System.out.println(colourArray[colour.ordinal()]);
    }
    public void getChange(int i,int j) {
        i++;j++;
        System.out.println(rankArray[rank.ordinal()] + ": " + i + "->" + j);
    }
}
public class hulu {

    public static void main(String[] args){
        huluwa[] p = {new huluwa(Rank.FIRST, Colour.RED), new huluwa(Rank.SECOND, Colour.ORANGE),
                new huluwa(Rank.THIRD, Colour.YELLOW), new huluwa(Rank.FORTH, Colour.GREEN),
                new huluwa(Rank.FIFTH, Colour.CYAN), new huluwa(Rank.SIXTH, Colour.BLUE),
                new huluwa(Rank.SEVENTH, Colour.PURPLE)
        };
        randomorder(p);
        bubblesort(p);
        randomorder(p);
        erfenSort(p, 0, p.length-1);
    }
    private static void bubblesort(huluwa[] p){
        int i,k;
        for(k=6;k>0;k--)
        {   for(i=0;i<k;i++)
            if (p[i].rank.ordinal()>p[i+1].rank.ordinal())
            {
                huluwa p0=p[i];
                p[i].getChange(i,i+1);
                p[i]=p[i+1];
                p[i+1].getChange(i+1,i);
                p[i+1]=p0;
            }
    }
    for (i=0;i<7;i++)
        p[i].getRank();
    }
    private static void erfenSort(huluwa []p,int left,int right){
        if(left>=right) return;
       huluwa p0=p[left];
       int t0=left;
       for(int i=left+1;i<=right;i++) {
           if (p[i].colour.ordinal() < p0.colour.ordinal()) {
               t0 = t0 + 1;
           } else continue;
           if (i > t0) {
               huluwa temp = p[i];
               p[i].getChange(i, t0);
               p[i] = p[t0];
               p[t0].getChange(t0, i);
               p[t0] = temp;
           }
       }
       if (left!=t0){
           p[left].getChange(left,t0);
           p[left]=p[t0];
           p[t0].getChange(t0,left);
           p[t0]=p0;
       }
    erfenSort(p,left,t0-1);
       erfenSort(p,t0+1,right);
       if(right-left==p.length-1) {
           for (int i = left; i<=right; i++)
               p[i].getColour();
       }
       }
    private static void randomorder(huluwa []p) {
        for (int i = 0; i < p.length; ++i) {
            Random r = new Random();
            int randomNum = r.nextInt(7) % 7;
            huluwa temp = p[randomNum];
            p[randomNum] = p[i];
            p[i]=temp;
        }
    }
    }
