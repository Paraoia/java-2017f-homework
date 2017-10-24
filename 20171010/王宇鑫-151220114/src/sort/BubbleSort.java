package sort;

import field.Position;
import unit.Unit;

public class BubbleSort implements Sorter {
    @Override
    public void sort(Sortable list) {
        System.out.println("--- Bubble Sort ---");
        for (int i = 0; i < list.length(); i++)
        {
            boolean noChange = true;
            for (int j = list.length() - 1; j > i; j--)
            {
                Position ll = list.get(j - 1), rr = list.get(j);
                if (ll.getSeat().compareTo(rr.getSeat()) > 0)
                {
                    ll.getSeat().moveTo(rr);
                    noChange = false;
                }
            }
            if (noChange)
                break;
        }
        System.out.println("------- End -------");
    }
}
