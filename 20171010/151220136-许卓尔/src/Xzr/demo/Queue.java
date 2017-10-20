package Xzr.demo;

import Xzr.Creature.CalabashDoll;
import Xzr.Creature.Creature;
import Xzr.Field.BattleField;
import Xzr.Position.Pit;
import Xzr.Position.Position;
import Xzr.Position.PositionXY;

import java.util.Random;

// 队列，战场的一种实现方式
public class Queue implements BattleField{
    private Pit[] pits;
    private int M;
    private int N;

    // 藤蔓的构造函数
    Queue(int num){
        pits = new Pit[num];
    }

    Queue(int M,int N){
        this.M = M;
        this.N = N;
        pits = new Pit[M*N];
        for(int i=0; i<M;i++){
            for(int j=0; j<N; j++){
                pits[i*N+j] = new Pit(new PositionXY(i,j,N));
            }
        }
    }

    public Pit[] getPits(){ return pits;}
    public int getM(){ return M;}
    public int getN(){ return N;}


    //MARK: BattleField interface
    @Override
    public void enterField(Creature[] creatures){
        int pos=0;
        for(int i=0; i<creatures.length; i++){
            while(pits[pos].getHolder()!=null)
                ++pos;
            pits[pos].setHolder(creatures[i]);
        }
    }
    @Override
    public void enterField(Creature[] creatures,Position[] positions){
        if(creatures.length != positions.length)
            return;

        for(int i=0; i<creatures.length; i++){
            pits[positions[i].index()].setHolder(creatures[i]);
        }
    }
    @Override
    public void clearField(){
        for(Pit pit : this.pits){
            pit.clearHolder();
        }
    }
    @Override
    public void showField() {
        int count=0;
        for(Pit pit : this.pits){
            if(pit.getHolder() != null) {
                System.out.format("%-8s",pit.getHolder().getName());
            }
            else{
                System.out.format("%-8s","*");
            }
            ++count;
            if(count%N==0)
                System.out.println("");
        }

        System.out.println("");
        System.out.flush();
    }
}
