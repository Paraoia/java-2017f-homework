public abstract class Creature {
    Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }



    public abstract void report();
}
