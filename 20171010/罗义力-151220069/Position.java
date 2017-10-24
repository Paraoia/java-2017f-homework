public class Position {

    private int x;
    private int y;

    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }

    private Creature holder;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(int x, int y){
        super();
        this.x = x;
        this.y = y;
    }

    boolean legal() {
        return (x >= 0) && (y >= 0);
    }
}