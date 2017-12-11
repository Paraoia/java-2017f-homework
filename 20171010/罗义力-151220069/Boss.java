public class Boss implements Creature{
    private Position position;
    private String name;

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
    public void report() {
        System.out.print(this.name);
    }

    Boss() {
        name = "蛇 ";
    }
}