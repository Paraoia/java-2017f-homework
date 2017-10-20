package Xzr.demo;

import java.util.Random;

// 藤蔓，用来挂葫芦娃；
public class Cirrus {
    CalabashDoll[] calabashDolls;       // 藤蔓上挂了葫芦娃；
    CalabashDoll tmpHolder;             // 藤蔓暂时挂要交换葫芦娃的地方；

    // 藤蔓的构造函数
    Cirrus(){
        calabashDolls = new CalabashDoll[CalabashDoll.allNum];
    }

    public void enqueue(CalabashDoll[] calabashDolls){
        if(this.calabashDolls.length != calabashDolls.length)
            return;

        boolean[] beOccupied = new boolean[CalabashDoll.allNum];
        Random random = new Random();
        for(int i=0;i<7;i++){
            int sel = random.nextInt(CalabashDoll.allNum);
            while (beOccupied[sel])
                sel = random.nextInt(CalabashDoll.allNum);
            beOccupied[sel] = true;
            this.calabashDolls[i] = calabashDolls[sel];
        }
    }

    public void randomSort(){
        boolean[] beOccupied = new boolean[CalabashDoll.allNum];
        Random random = new Random();
        for(int i=0;i<7;i++){
            int sel = random.nextInt(CalabashDoll.allNum);
            while (beOccupied[sel])
                sel = random.nextInt(CalabashDoll.allNum);
            beOccupied[i] = true;
            tmpHolder = calabashDolls[i];
            calabashDolls[sel].changePos(sel,i,false);
            calabashDolls[i] = calabashDolls[sel];
            calabashDolls[sel] = tmpHolder;
        }
    }

    public void bubbleSort(){
        for(int i=calabashDolls.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(calabashDolls[j].getNum()>calabashDolls[j+1].getNum()){
                    calabashDolls[j].changePos(j,j+1,true);
                    calabashDolls[j+1].changePos(j+1,j,true);
                    tmpHolder = calabashDolls[j];
                    calabashDolls[j] = calabashDolls[j+1];
                    calabashDolls[j+1] = tmpHolder;
                }
            }
        }
    }
    private int getPartition(int l,int r){
        int key = calabashDolls[l].getColor().getPri();
        int tmpHolderNum = l;
        tmpHolder = calabashDolls[l];
        while(l<r){
            while(l<r && calabashDolls[r].getColor().getPri()>= key)
                --r;
            calabashDolls[r].changePos(r,l,true);
            calabashDolls[l] = calabashDolls[r];
            while(l<r && calabashDolls[l].getColor().getPri()<=key)
                ++l;
            calabashDolls[l].changePos(l,r,true);
            calabashDolls[r] = calabashDolls[l];
        }
        tmpHolder.changePos(tmpHolderNum,l,true);
        calabashDolls[l] = tmpHolder;
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
        quickSort(0,calabashDolls.length-1);
    }

    public void countOff(String countType) {
        System.out.println("Count off by "+countType+":");
        for(int i=0;i<calabashDolls.length;i++){
            calabashDolls[i].countOff(countType);
            System.out.print(";");
        }
        System.out.print("\n");
    }
}
