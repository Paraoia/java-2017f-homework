/**
 * Created by rajesh on 17-9-25.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Brother> list = new ArrayList<>();
        list.add(new Brother(Brother.Color.RED, Brother.Name.ONE));
        list.add(new Brother(Brother.Color.ORANGE, Brother.Name.TWO));
        list.add(new Brother(Brother.Color.YELLOW, Brother.Name.THREE));
        list.add(new Brother(Brother.Color.GREEN, Brother.Name.FOUR));
        list.add(new Brother(Brother.Color.CYAN, Brother.Name.FIVE));
        list.add(new Brother(Brother.Color.BLUE, Brother.Name.SIX));
        list.add(new Brother(Brother.Color.PURPLE, Brother.Name.SEVEN));

        Sort sort = new Sort();
        Collections.shuffle(list);
        sort.bubbleSort(list, new Comparator<Brother>() {
            @Override
            public int compare(Brother o1, Brother o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getColor() + " " + list.get(i).getName());
        }

        Collections.shuffle(list);
        sort.quickSort(list, new Comparator<Brother>() {
            @Override
            public int compare(Brother o1, Brother o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getColor() + " " + list.get(i).getName());
        }
    }
}
