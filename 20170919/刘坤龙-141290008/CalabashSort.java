import java.util.*;

public class CalabashSort{
    final String[] names = {"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
    final String[] color = {"赤","橙","黄","绿","青","蓝","紫"};

    private CalabashBrother[] brothers;
    private Position[] lotus;

    public CalabashSort(){
        //suppose we have 7 empty lotus in the beginning
        lotus = new Position[7];
        for(int i=0;i<7;i++) {
            lotus[i] = new Position();
            lotus[i].index = i;
            lotus[i].holder = null;
        }

        //and also we have 7 Calabash brothers by the side
        brothers = new CalabashBrother[7];
        for(int i=0;i<brothers.length;i++){
            brothers[i] = new CalabashBrother(names[i],color[i],i);
        }
    }

    public void Randomize(){
        //the seven brothers step onto the lotus randomly
        for(int i=0;i<brothers.length;i++)
            lotus[i].holder = brothers[i];
        Random random = new Random();
        for(int i=0;i<brothers.length;i++) {
            int p = random.nextInt(7);
            CalabashBrother tmp = lotus[i].holder;
            lotus[i].holder = lotus[p].holder;
            lotus[p].holder = tmp;
        }
    }


    private void exchangePosition(int a,int b){
        //exchange the Calabash Brother on Lotus A with that on B

        //Brother A jump to b while Brother B jump to a
        lotus[a].holder.moveTo(a,b);
        lotus[b].holder.moveTo(b,a);

        CalabashBrother tmp = lotus[a].holder;
        lotus[a].holder = lotus[b].holder;
        lotus[b].holder = tmp;
    }

    public void BubbleSort(){
        for(int i=lotus.length-1; i>0; i--){
            for(int j=0; j<i;j++)
                if(lotus[j].holder.getSeniority() > lotus[j+1].holder.getSeniority())
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
        int key = lotus[p].holder.getSeniority();
        int i = p;
        int j = q;
        while(true){
            for(;j > p && lotus[j].holder.getSeniority() > key;j--)
                continue;
            for(;i < q && lotus[i].holder.getSeniority() < key;i++)
                continue;
            if(i < j)
                exchangePosition(i,j);
            else
                return j;
        }
    }

    public void displayByName(){
        for(int i=0;i<lotus.length;i++)
            lotus[i].holder.getName();
    }
    public void displayByColor(){
        for(int i=0;i<lotus.length;i++)
            lotus[i].holder.getColor();
    }
}

class Position {
    public int index;
    public CalabashBrother holder;
}