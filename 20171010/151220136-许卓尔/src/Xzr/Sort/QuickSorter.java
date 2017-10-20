package Xzr.Sort;

import Xzr.Creature.Comparable;
import Xzr.Creature.Creature;
import Xzr.Position.Pit;
import Xzr.demo.Queue;

public class QuickSorter implements Sorter {
    private Pit[] pits;
    @Override
    public void sort(Queue queue, Comparable comparable) {
        pits = queue.getPits();
        quickSort(0,pits.length-1,comparable);
    }

    private int getPartition(int l,int r,Comparable comparable){
        Creature key = pits[l].getHolder();
        int tmpHolderNum = l;
        while(l<r){
            while(l<r && comparable.compare(pits[r].getHolder(),key))
                --r;
            pits[l].setHolder(pits[r].getHolder());
            while(l<r && comparable.compare(key,pits[l].getHolder()))
                ++l;
            pits[r].setHolder(pits[l].getHolder());
        }
        pits[l].setHolder(key);
        return l;
    }

    public void quickSort(int l,int r,Comparable comparable){
        if(l<r) {
            int partition=getPartition(l,r,comparable);
            quickSort(l,partition-1,comparable);
            quickSort(partition+1,r,comparable);
        }
    }
}
