public class Position {
    private int x;
    private Creature holder;

    public Position(int x){
        super();
        this.x=x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }

    public Creature getHolder() {
        return holder;
    }
}
