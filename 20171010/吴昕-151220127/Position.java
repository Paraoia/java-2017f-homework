public class Position {

    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setPos(int x, int y) {
        this.x = x; this.y = y;
    }

    public Position(int x, int y) {
        super();
        setPos(x, y);
    }

    private Creature holder;
    private int x,y;

}
