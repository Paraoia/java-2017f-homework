public class Minion implements Creature{
    private Position position;

    @Override
    public void report() {
        System.out.print("喽");
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        if(this.position != null)
            this.position.setHolder(this);
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
