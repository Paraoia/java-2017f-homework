package huluwa;

public class Position {
    private Creature holder;

    public Position()
    {
        holder = null;
    }
    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }
}
