import java.util.Random;

public class CalabashGrandpa {   /*gourd grandpa*/

    public static void main(String[] args) {
        CalabashBros demo = new CalabashBros();
        demo.shuffle(0);    /* 0: print name, 1: print color */
        demo.bubble();
        demo.report(0);  /* 0:report name, 1:report color */
        demo.shuffle(1);
        demo.qs(0, 6);
        demo.report(1);
    }
}


class CalabashBros {
    private static Calabash[] bros = {
            new Calabash(Color.红色, Name.老大),
            new Calabash(Color.橙色, Name.老二),
            new Calabash(Color.黄色, Name.老三),
            new Calabash(Color.绿色, Name.老四),
            new Calabash(Color.青色, Name.老五),
            new Calabash(Color.蓝色, Name.老六),
            new Calabash(Color.紫色, Name.老七)
    };

    private  Calabash[] holders = new Calabash[7];

    CalabashBros(){
        for(int i=0;i<7;++i) holders[i] = bros[i];
    }


    public void shuffle(int flags/*0 print name, 1 print color*/) {
        Random random = new Random();
        for (int i = 0; i < holders.length; ++i) {
            int p = random.nextInt(i + 1);
            Calabash.hop(holders,i,p,1);
        }
        report(flags*3 - 1);
    }

    public void bubble() {
        for (int i = holders.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (holders[j + 1].getnameID() < holders[j].getnameID()) {
                    Calabash.hop(holders,j,j+1,0);
                }
            }
        }
    }

    public void qs(int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(lo, hi);
        qs(lo, j - 1);
        qs(j + 1, hi);
    }

    private int partition(int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (holders[++i].getcolorID() < holders[lo].getcolorID())
                if (i == hi) break;
            while (holders[--j].getcolorID() > holders[lo].getcolorID())
                if (j == lo) break;
            if (i >= j) break;
            Calabash.hop(holders,i,j,0);
        }
        Calabash.hop(holders,lo,j,0);
        return j;
    }

    public void report(int flags/*0:name, 1:color*/) {
        if (flags == 0) System.out.print("Sort by age: ");
        else if (flags == 1) System.out.print("Sort by color: ");
        else System.out.print("Random shuffle: ");      //report after shuffle

        for (int i = 0; i < holders.length; ++i)
            System.out.print((flags < 1 ? holders[i].sayName() : holders[i].sayColor()) + " ");
        System.out.println();
    }
}
