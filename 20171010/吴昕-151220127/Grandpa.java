public class Grandpa implements Creature {

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public String toString() { return "爷"; }

    private Position position;

}
