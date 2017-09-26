import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by joker on 17-9-26.
 */
public class Main {
    public static void main(String[] args){
        List<Brother> list = new ArrayList<>();
        for(int i = 1; i <= 7; i++)
            list.add(new Brother(i));
        Collections.shuffle(list);
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getColor());
        Sort.bubbleSort(list);
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getColor());

        Collections.shuffle(list);
        Sort.quickSort(list);
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).getColor());
    }
}
