public abstract class Creature {

    protected Position position;

    public void setPosition(Position position) {
        this.position = position;
        if (position != null)
            position.setHolder(this);
    }

    public void report() {
        System.out.print(toString());
    }

    public abstract void act();
}
