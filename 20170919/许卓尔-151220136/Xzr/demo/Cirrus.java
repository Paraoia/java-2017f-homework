package Xzr.demo;

import java.util.Random;

// 这是藤蔓，上面长了七个葫芦娃
public class Cirrus {
    CalabashDoll[] calabashDolls;
    int[] position;

    // 藤蔓的生长函数，附带一次随机排列
    public void initialize(){
        calabashDolls = new CalabashDoll[CalabashDoll.allNum];
        position = new int[CalabashDoll.allNum];
        for(int i=0;i<CalabashDoll.allNum;i++){
            calabashDolls[i] = new CalabashDoll();
            position[i] = i;
        }
        randomSort();
    }
    public void randomSort(){
        boolean[] beOccupied = new boolean[CalabashDoll.allNum];
        Random random = new Random();
        for(int i=0;i<7;i++){
            int sel = random.nextInt(CalabashDoll.allNum);
            while (beOccupied[sel])
                sel = random.nextInt(CalabashDoll.allNum);
            beOccupied[sel] = true;
            position[i] = sel;
            calabashDolls[sel].changePos(i,false);
        }
    }

    public void bubbleSort(){
        for(int i=CalabashDoll.allNum-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(calabashDolls[position[j]].getNum()>calabashDolls[position[j+1]].getNum()){
                    calabashDolls[position[j]].changePos(j+1,true);
                    calabashDolls[position[j+1]].changePos(j,true);
                    int temp= position[j];
                    position[j] = position[j+1];
                    position[j+1] = temp;
                }
            }
        }
    }
    private int getPartition(int l,int r){
        int key = position[l];
        int pivot = calabashDolls[key].getColor().getPri();
        while(l<r){
            while(l<r && calabashDolls[position[r]].getColor().getPri()>= pivot)
                --r;
            calabashDolls[position[r]].changePos(l,true);
            position[l] = position[r];
            while(l<r && calabashDolls[position[l]].getColor().getPri()<=pivot)
                ++l;
            calabashDolls[position[l]].changePos(r,true);
            position[r]=position[l];
        }
        calabashDolls[key].changePos(l,true);
        position[l]=key;
        return l;
    }
    public void quickSort(int l,int r){
        if(l<r) {
            int partition=getPartition(l,r);
            quickSort(l,partition-1);
            quickSort(partition+1,r);
        }
    }

    public void quickSort() {
        quickSort(0,CalabashDoll.allNum-1);
    }
}
