import java.util.*;

public class CalabashSort{
    final String[] names = {"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
    final String[] color = {"赤","橙","黄","绿","青","蓝","紫"};
    private CalabashBrother[] brothers;
    public CalabashSort(){
        this.brothers = new CalabashBrother[7];
        for(int i=0;i<7;i++)
            brothers[i] = new CalabashBrother(names[i],color[i],i+1);

        /* In the beginning, the 7 brothers are placed randomly */
        Randomize();

        displayOrder(0);
        /*display the order*/
    }

    public void Randomize(){
        /*Randomize the order of the 7 brothers*/
        Random random = new Random();
        for(int i=0;i<7;i++) {
            int p = random.nextInt(7);
            CalabashBrother tmp = brothers[i];
            brothers[i] = brothers[p];
            brothers[p] = tmp;
        }
    }

    /**
     * according to the type, output different information
     * @param type 0 for all, 1 for name, 2 for color
     */
    public void displayOrder(int type){
        switch (type){
            case 0:
                for(CalabashBrother tmp : brothers) {
                    System.out.println(tmp.getName() + " " + tmp.getColor() + " " + Integer.toString(tmp.getNo()));
                }
                break;
            case 1:
                for(CalabashBrother tmp : brothers)
                    System.out.println(tmp.getName());
                break;
            case 2:
                for(CalabashBrother tmp : brothers)
                    System.out.println(tmp.getColor());
                break;
        }
    }

    private void exchangePosition(int a,int b){
        System.out.println(brothers[a].getName() + " : " + Integer.toString(a) + " -> " + Integer.toString(b));
        System.out.println(brothers[b].getName() + " : " + Integer.toString(b) + " -> " + Integer.toString(a));
        CalabashBrother tmp = brothers[a];
        brothers[a] = brothers[b];
        brothers[b] = tmp;
    }

    public void BubbleSort(){
        for(int i=brothers.length-1; i>0; i--){
            for(int j=0; j<i;j++)
                if(brothers[j].getNo() > brothers[j+1].getNo())
                    exchangePosition(j,j+1);
        }
    }

    public void quickSort(int p,int q){
        if(p >= q)
            return;
        int r = partition(p,q);
        quickSort(p,r-1);
        quickSort(r+1,q);
    }

    private int partition(int p,int q){
        int key = brothers[p].getNo();
        int i = p;
        int j = q;
        while(true){
            for(;j > p && brothers[j].getNo() > key;j--)
                continue;
            for(;i < q && brothers[i].getNo() < key;i++)
                continue;
            if(i < j)
                exchangePosition(i,j);
            else
                return j;
        }
    }
}