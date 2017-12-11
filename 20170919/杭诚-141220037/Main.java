import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by joker on 17-9-26.
 */
public class Main {
    public static void main(String[] args){
        BroSort brosort = new BroSort();
        brosort.shuffle();
        brosort.bubbleSort();
        brosort.printName();
        brosort.shuffle();
        brosort.quickSort();
        brosort.printColor();
    }
}
