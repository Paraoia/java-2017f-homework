package hlw;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class Queue {
    private Position[] space;
    private Creature[] creatures;

    public static void main(String args[]){
        HuLuWa[] brothers = new HuLuWa[7];
        for(int i = 0; i<brothers.length; i++){
            brothers[i] = new HuLuWa(RANK.values()[i], COLOR.values()[i]);
        }
        Queue queue = new Queue(brothers);
        System.out.println("初始化：");
        queue.roll_call();
        System.out.println("打乱顺序：");
        queue.shuffle();
        queue.roll_call();
        System.out.println("冒泡排序：");
        Sorter b_sorter = new BubbleSorter();
        b_sorter.Sort(queue);
        queue.roll_call();
        System.out.println("打乱顺序：");
        queue.shuffle();
        queue.roll_call();
        System.out.println("快速排序：");
        Sorter q_sorter = new QuickSorter();
        q_sorter.Sort(queue);
        queue.roll_call();
    }

    Queue(HuLuWa[] brothers){
        space = new Position[brothers.length + 1];
        creatures = brothers;
        for(int i = 0; i< creatures.length; i++){
            space[i] = new Position(i);
            creatures[i].set_pos(space[i]);
            space[i].put_in(creatures[i]);
        }
        space[brothers.length] = new Position(brothers.length);
    }

    public Position[] get_space(){
        return space;
    }


    //put brothers in  position randomly
    public void shuffle() {
        //generate a random series
        List num_list = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            num_list.add(i);
        }
        Collections.shuffle(num_list);
        //put brothers in position according to the random series
        for (int i = 0; i < space.length - 1; i++) {
            int rand_num = new Integer(num_list.get(i).toString());
            creatures[rand_num].set_pos(space[i]);
        }
    }

    public void roll_call(){
        for (int i = 0; i < 7; i++) {
            Creature c_baby = space[i].get_holder();
            System.out.println(c_baby.show());
            //System.out.println(((HuLuWa)c_baby).get_rank().toString() + ((HuLuWa)c_baby).get_rank().ordinal());
        }
        System.out.println("-------------------------------------");
    }

    public void report_colour(){
        for (int i = 0; i < 8; i++) {
            Creature c_baby = space[i].get_holder();
            // c_baby.echo_color();
        }
    }

}
