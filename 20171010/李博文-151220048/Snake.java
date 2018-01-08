public class Snake implements Creature{
    private Position position;
    String name = "蛇";
    @Override
    public void report() {
        System.out.print(name);
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        if (this.position != null)
            this.position.setHolder(this);
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
