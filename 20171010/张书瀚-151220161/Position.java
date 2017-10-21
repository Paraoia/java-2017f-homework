
public class Position {
    private int x, y;
    private boolean occupy;
    private Creature holder;

    public void setHolder(Creature creature) {
        holder = creature;
    }

    public Creature getHolder() {
        return holder;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.occupy = false;
        this.holder = null;
    }

    public void setOccupy() {
        this.occupy = true;
    }

    public void clearOccupy() {
        this.occupy = false;
        this.holder = null;
    }

    public void setX_Y(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOccupy() {
        return occupy;
    }
}
