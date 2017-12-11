package Xzr.demo;

// 位置，显示了位置信息
public class Position {
    protected int x;
    public Position(int x){
        super();
        this.x = x;
    }

    @Override
    public String toString(){
        return String.valueOf(x);
    }
}
