package Xzr.Position;

// 位置，显示了位置信息
public class Position {
    protected int x;
    public Position(int x){
        super();
        this.x = x;
    }

    public int index(){
        return x;
    }

    @Override
    public String toString(){
        return String.valueOf(x);
    }
}
