public class Position {
    private int x, y;
    private Creature holder;
    public Creature getHolder(){
        return holder;
    }
    public void setHolder(Creature holder){
        this.holder = holder;
    }
    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
    public String getXY(){
        String string = "(" + x + ", " + y + ")";
        return string;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Position(int x, int y){
        super();
        this.x = x;
        this.y = y;
    }
    public Position(int x, int y, Creature holder){
        super();
        this.x = x;
        this.y = y;
        this.holder = holder;
    }
}
