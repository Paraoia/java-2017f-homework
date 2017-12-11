package Xzr.Creature;

import Xzr.Position.Position;

enum COLOR{
    RED(1),ORANGE(2),YELLOW(3),GREEN(4),CYAN(5),BLUE(6),PURPLE(7);

    private int pri;    // 规定颜色的优先级

    private COLOR(int _pri){
        this.pri = _pri;
    }
    public int getPri() {
        return pri;
    }
}

enum SENIORITY {
    老大, 老二, 老三, 老四, 老五, 老六, 老七;
}

// 这是葫芦娃，他可以换位置的时候报数，告诉爷爷他的排行和颜色
public class CalabashDoll implements Creature{
    private static int curNum=0;    // 葫芦娃现个数
    public final static int allNum = 7; // 葫芦娃总个数

    private SENIORITY seniority;        // 葫芦娃各自序号
    private COLOR color;    // 葫芦娃的颜色
    private Position position;

    public CalabashDoll(){
        color = COLOR.values()[curNum];
        seniority = SENIORITY.values()[curNum];
        curNum = (curNum+1)%allNum;
    }

    public SENIORITY getSeniority(){ return seniority; }
    public COLOR getColor(){
        return color;
    }

    @Override
    public String toString() {
        return seniority.toString() + " Color: " + color.toString() + " Position: " + position.toString() + " ;";
    }

    //MARK: Creature
    @Override
    public void countOff() {
            System.out.print(this.toString());
    }
    @Override
    public void setPosition(Position position){
        this.position = position;
    }
    @Override
    public Position getPosition(){
        return this.position;
    }
    @Override
    public String getName(){ return this.seniority.toString(); }

}
