public class Position {

    private int x;
    private int y;
    private Creature holder;
    private boolean beOccupied;//标志是否被占

    public Creature getHolder() {
        if(beOccupied)
            return holder;
        else
            return null;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
        beOccupied=true;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean getBeOccupied(){return this.beOccupied;}

    public void setBeOccupied(boolean beOccupied){this.beOccupied=beOccupied;}

    public Position(int x){
        super();
        this.x = x;
        beOccupied=false;
    }

    public Position(int x,int y){
        super();
        this.x = x;
        this.y = y;
        beOccupied=false;
    }
}
