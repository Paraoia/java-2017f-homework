package Xzr.demo;

public class PositionXY extends Position {
    protected int y;

    public PositionXY(int i, int N){
        super(i/N);
        this.y = i%N;
    }

    @Override
    public String toString(){
        return "("+x+ ","+y+")";
    }
}
