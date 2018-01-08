package sorters;

import creatures.Creature;
import maps.queues.Queue;
import positions.*;

public class QuickSorter implements Sorter {

    public void sort(Queue queue){

        Position[] positions = queue.getPositions();
        QuickSortQueue(0,positions.length-1,positions);
    }

    public void QuickSortQueue(int low, int high, Position[] positions){

        if(low > high)
            return;

        Creature temp = positions[low].getHolder();
        int i=low;
        int j=high;

        while(i!=j){
            while(((Comparable)(positions[i].getHolder())).biggerThan((Comparable)temp)&&i<j)
                j--;
            while(!((Comparable)(positions[i].getHolder())).biggerThan((Comparable)temp)&&i<j)
                i++;
            if(i<j){
                Creature t = positions[i].getHolder();
                positions[i].setHolder(positions[j].getHolder());
                positions[j].setHolder(temp);
            }
        }
        if(i!=low){
            Creature t = positions[i].getHolder();
            positions[i].setHolder(positions[low].getHolder());
            positions[low].setHolder(temp);
        }

        QuickSortQueue(low,i-1,positions);
        QuickSortQueue(i+1,high,positions);
    }
}
