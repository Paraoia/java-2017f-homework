package HuluWaSort;

import java.util.ArrayList;
import java.util.Random;

public abstract class HuluWaGeneralSorter {
    protected ArrayList<HuluWa> huluWaList;

    abstract void sort();

    HuluWaGeneralSorter(ArrayList<HuluWa> huluWaList){
        this.huluWaList = huluWaList;
    }

    public void chaos(){
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            int index1 = random.nextInt(huluWaList.size());
            int index2 = random.nextInt(huluWaList.size());
            swap(index1, index2, false);
        }
    }

    protected int compare(int i, int j){
        return huluWaList.get(i).getColor().compareTo(
                huluWaList.get(j).getColor()
        );
    }

    protected void swap(int h1, int h2, boolean isReport){
        if(h1 == h2) return;

        if(isReport) {
            huluWaList.get(h1).report(h1, h2);
            huluWaList.get(h2).report(h2, h1);
        }

        HuluWa tmp = huluWaList.get(h1);
        huluWaList.set(h1, huluWaList.get(h2));
        huluWaList.set(h2, tmp);

    }
}
