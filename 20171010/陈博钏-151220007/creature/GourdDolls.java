package creature;

import java.util.ArrayList;
/**
 * Created by cbcwe on 2017/10/16.
 */

/* singleton GourdDolls */
public class GourdDolls {

    private ArrayList<GourdDoll> gourdDolls = null;
    private static GourdDolls single = null;
    public static final int NUM = 7;
    private GourdDolls(){
        gourdDolls = new ArrayList<GourdDoll>();
        for(int i = 0 ; i < NUM ; ++ i)
            gourdDolls.add(new GourdDoll(GourdDollType.values()[i]));
    }

    public static GourdDolls getGourdDolls(){
        if( single == null ){
            single = new GourdDolls();
        }
        return single;
    }

    public String toString(){
        String result = "";
        for(GourdDoll g : gourdDolls)
            result += g+" " ;
        return result;
    }

    public void printGourdDolls(String arg){
        System.out.println(arg + toString());
    }

    public void getARandomSeq(){
        for (int i = 0 ; i < NUM ; ++ i) {
            int j = (int) (System.currentTimeMillis() % 7);
            GourdDoll temp = gourdDolls.get(i);
            gourdDolls.set(i,gourdDolls.get(j));
            gourdDolls.set(j,temp);
        }
    }

    public void sort(){
        for(int i = 0 ; i < NUM-1 ; ++ i) {
            int swap = i;
            for (int j = i; j < NUM; ++j)
                if (gourdDolls.get(j).olderThan(gourdDolls.get(swap)))
                    swap = j;
            if( swap != i  ){
                GourdDoll temp = gourdDolls.get(i);
                gourdDolls.set(i,gourdDolls.get(swap));
                gourdDolls.set(swap,temp);
            }
        }
    }

    public final void moveTo(int i , final int dest_x, final int dest_y){
        System.out.println(gourdDolls.get(i).toString()
                +" moves from ( "+gourdDolls.get(i).getX()+" , "+gourdDolls.get(i).getY()
                +" ) to ( " + dest_x+" , "+dest_y+" ) ");
        gourdDolls.get(i).setX(dest_x);
        gourdDolls.get(i).setY(dest_y);
    }

    public GourdDoll getGourdDoll(int i){
        return gourdDolls.get(i%NUM);
    }
    public int getGourdDollX(int i){return gourdDolls.get(i%NUM).getX();};
    public int getGourdDollY(int i){return gourdDolls.get(i%NUM).getY();};

    public final void swapPoi( int a, int b ){
        int temp_x = gourdDolls.get(b).getX();
        int temp_y = gourdDolls.get(b).getY();
        gourdDolls.get(b).moveTo(gourdDolls.get(a).getX(),gourdDolls.get(a).getY());
        gourdDolls.get(a).moveTo(temp_x,temp_y);
    }

    // For unit test
    public static void main(String[] argv){
        GourdDolls gourdDolls = new GourdDolls();
        System.out.println(gourdDolls);
        gourdDolls.getARandomSeq();
        System.out.println(gourdDolls);
        gourdDolls.sort();
        System.out.println(gourdDolls);
    }

    private class GourdDoll extends Creature implements Comparable {

        private final GourdDollType type;

        public GourdDoll(GourdDollType type) {
            this.type = type;
        }

        public String toString() {// report name with color
            return type.name();
        }

        public boolean olderThan(final Comparable another) {
            if (another instanceof GourdDoll)
                return type.ordinal() < ((GourdDoll) another).type.ordinal();
            else {
                System.out.println("Uncomparable");
                return false;
            }
        }

        // For unit test
        /*
        public static void main(String[] argv) {
            GourdDoll test1 = new GourdDoll(GourdDollType.values()[0]);
            System.out.println(test1);
            GourdDoll test2 = new GourdDoll(GourdDollType.values()[1]);
            System.out.println(test1.olderThan(test2));
            test1.moveTo(1, 2);
            test2.moveTo(3, 4);
            test1.swapPoi(test2);
            System.out.println(test1.getX() + " " + test1.getY() + " " + test2.getX() + " " + test2.getY());
        }
        */
    }
}

enum GourdDollType{
    大娃,二娃,三娃,四娃,五娃,六娃,七娃;
}