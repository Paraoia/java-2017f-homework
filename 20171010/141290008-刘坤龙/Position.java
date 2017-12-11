public class Position {

    private int x,y;
    private Creature holder;

    public Creature getHolder(){
        return this.holder;
    }

    public void setHolder(Creature holder){
        this.holder = holder;
    }

    @Override
    public String toString(){
        return "(" + Integer.toString(x) + " , " + Integer.toString(y) + ")";
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    Position(int x,int y){
        this.x = x;
        this.y = y;
        this.holder = null;
    }

}
