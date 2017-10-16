package Xzr.demo;

import java.util.Random;

// 队列，用于放置生物
public class Queue {
    private Pit[] pits;

    // 藤蔓的构造函数
    Queue(int num){
        pits = new Pit[num];
    }

    public Pit[] getPits(){ return pits;}

    public void enqueue(Creature[] creatures){
        if(this.pits.length != creatures.length)
            return;

        for(int i=0; i<creatures.length; i++){
            pits[i] = new Pit(new Position(i));
            pits[i].setHolder(creatures[i]);
        }
    }



    public void randomSort(){
        Random random = new Random();
        for(int i=0;i<7;i++){
            int sel = random.nextInt(CalabashDoll.allNum-i);
            Creature creature = pits[sel].getHolder();
            pits[sel].setHolder(pits[i].getHolder());
            pits[i].setHolder(creature);
        }
    }

    public void countOff() {
        for(Pit pit : this.pits){
            pit.getHolder().countOff();
            System.out.println("");
        }

        System.out.println("");
        System.out.flush();
    }
}
