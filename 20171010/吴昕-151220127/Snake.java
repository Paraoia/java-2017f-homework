public class Snake implements Creature {

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
    public String toString() { return "蛇"; }

    private Position position;

}
