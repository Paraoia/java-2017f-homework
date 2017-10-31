public class Scorpion implements Creature {

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
    public String toString() { return "蝎"; }

    private Position position;

}
