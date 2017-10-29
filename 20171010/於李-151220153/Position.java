public class Position {
    private Creature holder;
    private int x, y;

    Position(int inputX, int inputY) {
        x = inputX;
        y = inputY;
        holder = null;
    }

    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature creature) {
        holder = creature;
    }
}
