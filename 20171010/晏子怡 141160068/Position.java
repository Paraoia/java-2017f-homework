public class Position {
    private Creature holder;   // Position with a holder
    int x;
    int y;
    public Creature getHolder() {
        return holder;
    }
    public void setHolder(Creature holder) {
        this.holder = holder;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x ) {
        this.x = x;
    }
    public void setY(int y ) {
        this.y = y;
    }

    public Position(int x,int y){
        super();
        this.x=x;
        this.y=y;
    }
    public void clearHolder(){
        setHolder(null);

    }
}
