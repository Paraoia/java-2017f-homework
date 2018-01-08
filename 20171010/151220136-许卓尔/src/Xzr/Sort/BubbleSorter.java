package Xzr.Sort;

import Xzr.Creature.Comparable;
import Xzr.Creature.Creature;
import Xzr.Position.Pit;
import Xzr.demo.Queue;

public class BubbleSorter implements Sorter {
    @Override
    public void sort(Queue queue, Comparable comparable){
        Pit[] pits = queue.getPits();
        Creature creature = null;
        for(int i=pits.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(comparable.compare(pits[j].getHolder(),pits[j+1].getHolder())){
                    creature = pits[j].getHolder();
                    pits[j].setHolder(pits[j+1].getHolder());
                    pits[j+1].setHolder(creature);
                }
            }
        }
    }
}
