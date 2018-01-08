public class Position<T extends Creature> {
    private T holder;
    private int x, y;

    Position(int inputX, int inputY) {
        x = inputX;
        y = inputY;
        holder = null;
    }

    public T getHolder() {
        return holder;
    }

    public void setHolder(T creature) {
        holder = creature;
    }
}
