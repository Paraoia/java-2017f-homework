public class Monster implements Creature {
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

    Monster() {
        name = "怪 ";
    }

    Monster(String name) {
        this.name = name;
    }
}
