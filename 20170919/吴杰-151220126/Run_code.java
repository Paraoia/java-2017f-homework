/**
 * Created by jar on 2017/9/20.
 */
public class Run_code {
    public static void main(String[] args) {
        Huluqueue queue_b = new Huluqueue();
        queue_b.bubblesort();
        queue_b.tell_name();

        Huluqueue queue_q = new Huluqueue();
        queue_q.quicksort(0, 6);
        queue_q.tell_colour();
    }
}
