package HuluwaFighting;

/**
 * 二维平面坐标的具体实现，holder变量可使坐标与某一个生物体关联
 */
public class FieldPosition implements Position{
    private int X;
    private int Y;
    private boolean Occupied;
    private Creature holder;

    FieldPosition(){
        Occupied = false;
    }
    FieldPosition(int x, int y){
        X = x; Y = y;
        Occupied = false;
        holder = null;
    }

    public int getX(){ return X;}
    public int getY() {return Y;}
    public Creature getHolder() {return holder;}
    public boolean isOccupied() {return Occupied;}

    public void setX(int x) {X = x;}
    public void setY(int y) {Y = y;}
    public boolean setHolder(Creature creature){
        if(creature==null){
            return false;
        }
        else{
            Occupied = true;
            holder = creature;
            return true;
        }
    }

    public void clearHolder(){
        Occupied=false;
        holder = null;
    }

    public Boolean isbiggerThan(Position another){
        return  (this.X+this.Y) <= (another.getX()+another.getY());
    }
}
