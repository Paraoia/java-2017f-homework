import java.util.Random;
public class HuLuWa {
    public enum Color{
       RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE
    }
    public enum Rank{
        老大,老二,老三,老四,老五,老六,老七
    }

    private Color c;
    private Rank r;
    private int index;
    public HuLuWa (Color c1,Rank r2,int i3){
        c=c1;
        r=r2;
        index=i3;
    }

    final static int MAX=7;

    public static HuLuWa []baby = new HuLuWa[MAX];

    public static Color color(int i){
        switch(i){
            case 0:return Color.RED;
            case 1:return Color.ORANGE;
            case 2:return Color.YELLOW;
            case 3:return Color.GREEN;
            case 4:return Color.CYAN;
            case 5:return Color.BLUE;
            case 6:return Color.PURPLE;
            default:return Color.RED;
        }
    }
    public static  Rank rank(int i){
        switch(i){
            case 0:return Rank.老大;
            case 1:return Rank.老二;
            case 2:return Rank.老三;
            case 3:return Rank.老四;
            case 4:return Rank.老五;
            case 5:return Rank.老六;
            case 6:return Rank.老七;
            default:return null;
        }
    }
    public static void randomQueue (){
        for (int i=0;i<MAX;i++) {
            baby[i]=new HuLuWa(color(i),rank(i),i);
        }
        Random random=new Random();
        for (int i=0;i<MAX;i++){
            int p=random.nextInt(MAX);
            HuLuWa tmp = baby[i];
            baby[i]=baby[p];
            baby[p]=tmp;
        }
        random=null;
    }

    public static void display(int flag){
        for (int i=0;i<MAX;i++) {
            if (flag == 1)
                System.out.print(baby[i].r + " ");
            else
                System.out.print(baby[i].c + " ");
        }
        System.out.println();
    }
    public static void BubbleSort(){
        for (int i=0;i<MAX;i++)
            for (int j=i+1;j<MAX;j++)
            {
                if(baby[i].index>baby[j].index) {
                    System.out.print(baby[i].r+" "+i+"->"+j+" ");
                    HuLuWa tmp = baby[i];
                    baby[i]=baby[j];
                    baby[j]=tmp;
                }
            }
        System.out.println();
    }
    public static void QuickSort(){
        quicksort(0,MAX-1);
    }
    public static void quicksort(int l ,int r){
        if( l>=r )    //l >=  r
            return;
        HuLuWa key = baby[l];
        int low=l , high=r;
        while(low<high){
            while(low<high&&( baby[high].c.compareTo(key.c)>0 ) ){     //high>key
                high--;
            }
            baby[low]=baby[high];
            if(low!=high)
                System.out.print(baby[high].c+" "+high+"->"+low+" ");
            while(low<high&&( baby[low].c.compareTo(key.c)<0 ) ){     //low<key
                low++;
            }
            baby[high]=baby[low];
            if(low!=high)
                System.out.print(baby[low].c+" "+low+"->"+high+" ");
        }
        baby[low]=key;
        if(low!=l)
            System.out.print(key.c+" "+l+"->"+low+" ");
        quicksort(l,low-1);
        quicksort(low+1,r);

    }
    public static void main (String[] argc) {
        randomQueue();
        display(1);
        BubbleSort();
        display(1);

        System.out.println();

        randomQueue();
        display(2);
        QuickSort();
        System.out.println();
        display(2);
    }
}
