import java.util.ArrayList;
import java.util.Random;

public class Operation {

    public Color color(int i){
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
    public Rank rank(int i){
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
    static ArrayList<HuLuWa> baby=new ArrayList<HuLuWa>();

    static ArrayList<Position> queue = new ArrayList<Position>();

    public Operation(){
        for (int i=0;i<7;i++) {
            baby.add(new HuLuWa(color(i), rank(i), i));
            queue.add(i,new Position(baby.get(i)));
        }
    }

    public void randomQueue (){
        Random random=new Random();
        for (int i=0;i<7;i++){
            int p=random.nextInt(7);
            HuLuWa tmp = baby.get(i);
            baby.set(i,baby.get(p));
            baby.set(p,tmp);
        }
        for (int i=0;i<7;i++)
            queue.set(i,new Position(baby.get(i)));
        random=null;
    }

    public void display(int flag){
        for (int i=0;i<7;i++) {
            if (flag == 1)
                queue.get(i).show();
            else
                baby.get(i).showcolor();
        }
        System.out.println();
    }
    public void BubbleSort(){      //以位置为对象进行操作
        for (int i=0;i<7;i++)
            for (int j=i+1;j<7;j++)
            {
                if(queue.get(i).larger(queue.get(j))){   //i.index>j.index
                    queue.get(i).show();
                    System.out.println(i+"->"+j+" ");
                    Position tmp= queue.get(i);
                    queue.set(i,queue.get(j));
                    queue.set(j,tmp);

                    HuLuWa tmp1 = baby.get(i);
                    baby.set(i,baby.get(j));
                    baby.set(j,tmp1);
                }
            }
        System.out.println();
    }
    public  void QuickSort(){          //以葫芦娃为对象进行排序
        quicksort(0,6);
    }
    public  void quicksort(int l ,int r){
        if( l>=r )    //l >=  r
            return;
        HuLuWa key = baby.get(l);
        Position keytmp = queue.get(l);
        int low=l , high=r;
        while(low<high){
            while(low<high&&  baby.get(high).cmp2(key)  ){     //high>key
                high--;
            }
            baby.set(low,baby.get(high));
            queue.set(low,queue.get(high));
            if(low!=high) {
                baby.get(high).showcolor();
                System.out.println(high + "->" + low + " ");
            }
            while(low<high&& !baby.get(low).cmp2(key) ){     //low<key
                low++;
            }
            baby.set(high,baby.get(low));
            queue.set(high,queue.get(low));
            if(low!=high) {
                baby.get(low).showcolor();
                System.out.println(low + "->" + high + " ");
            }
        }
        baby.set(low,key);
        queue.set(low,keytmp);
        if(low!=l) {
            key.showcolor();
            System.out.println(l + "->" + low + " ");
        }
        quicksort(l,low-1);
        quicksort(low+1,r);
    }
}
