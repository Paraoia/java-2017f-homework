package Xzr.Position;

public class PositionXY extends Position {
    protected int y;
    /** 记录二维数组的大小*/
    private int N;

    public PositionXY(int x, int y, int N){
        super(x);
        this.y = y;
        this.N = N;
    }

    public int getX(){return this.x;};
    public int getY(){return this.y;};

    @Override
    public int index(){
        if(y<N)
            return x*N+y;
        else
            return 0;
    }

    @Override
    public String toString(){
        return "("+x+ ","+y+")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(obj instanceof PositionXY){
            PositionXY posXY=(PositionXY)obj;
            if(x==posXY.getX() && y==posXY.getY()){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
