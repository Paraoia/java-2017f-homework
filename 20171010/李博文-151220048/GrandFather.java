public class GrandFather implements  Creature{
    private Position position;
    String name = "爷";
    @Override
    public void report() {
        System.out.print(name);
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
