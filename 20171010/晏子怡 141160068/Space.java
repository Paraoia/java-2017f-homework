import javafx.geometry.Pos;
import  java.lang.System;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Space {
    private int N;    //size of the Space
    public int getN(){
        return this.N;
    }
    private Position[][] positions;  //有一堆位置
    public Position[][] getPositions() {
        return positions;
    }
    public Space(int n) {
        this.N=n;
        this.positions = new Position[n][];  //初始化space,space上面有一堆position,position 上没有holder
        for (int i = 0; i < n; i++){
            positions[i]= new Position[n];
            for (int j=0;j<n;j++)
                positions[i][j]=new Position(i,j);
        }
    }
    public void addZhenfa(Zhenfa zhenfa) {  // 往空间加阵法
        Position[] ps=zhenfa.getPositions();
        Creature[] holders=zhenfa.getCreatures();
        for (int i = 0; i <ps.length; i++)
           this.positions[ps[i].x][ps[i].y].setHolder(holders[i]);
    }
    public void removeZhenfa(Zhenfa zhenfa) {  // 往空间加阵法
        Position[] ps=zhenfa.getPositions();
        for (int i = 0; i <ps.length; i++)
        {
            this.positions[ps[i].x][ps[i].y].clearHolder();
        }
    }
    boolean hadHolder(Position p){
        if(this.positions[p.x][p.y].getHolder()!=null) return true; //position上是否有holder
        return false;
    }
    // 往空间加入一个生物
    public void addCreature(Creature creature,int x,int y){
        creature.setPosition(this.positions[x][y]);
    }
    //  显示空间中的生物布局
    public void print(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (hadHolder(positions[i][j]))
                    switch (this.positions[i][j].getHolder().getType()) {
                        case Huluwa:
                            System.out.print('H');
                            break;
                        case Yeye:
                            System.out.print('Y');
                            break;
                        case Shejing:
                            System.out.print('S');
                            break;
                        case Loluo:
                            System.out.print('L');
                            break;
                        case Xiezijing:
                            System.out.print('X');
                            break;
                    }
                else System.out.print('_');
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        Space space=new Space(20);

        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], RANK.values()[i]);
        }
        Zhenfa changShe=new Zhenfa(brothers,ZhenfaType.Changshe); //生成长蛇阵法
        changShe.form(space,0,1);
        space.addZhenfa(changShe); //把阵法加到空间

        int nLoluo=6;
        Creature[] badCreatures= new Creature[nLoluo+1];  //蝎子精和n个小喽啰
        badCreatures[0] = new Xiezijing();
        for (int i = 1; i < badCreatures.length; i++) {
            badCreatures[i] = new XIaolouluo();
        }
        Zhenfa heYi=new Zhenfa(badCreatures,ZhenfaType.Heyi); //生成鹤翼阵法
        heYi.form(space,10,11);
        space.addZhenfa(heYi); //把阵法加到空间

        Grandpa yeye=new Grandpa();
        space.addCreature(yeye,0,0);
        Shejing shejing=new Shejing();
        space.addCreature(shejing,10,19);
        System.out.println("-----加入爷爷和蛇精后：两方对峙画面- <长蛇> VS <鹤翼> ----------------");
        space.print();

        space.removeZhenfa(heYi);   //移除之前小喽啰阵营的阵法
        Zhenfa yanXing=new Zhenfa(badCreatures,ZhenfaType.Yanxing); //生成鹤翼阵法
        yanXing.form(space,10,11);
        space.addZhenfa(yanXing); //把阵法加到空间
        System.out.println("---------蝎子精和小喽啰变换阵形：-- <长蛇> VS <雁行> ------------------");
        space.print();
    }


}
