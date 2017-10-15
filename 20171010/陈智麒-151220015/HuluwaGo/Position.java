package HuluwaGo;

public class Position {
    private int x, y;
    private Creature holder;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }

    public Creature getHolder() {
        return holder;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
}
