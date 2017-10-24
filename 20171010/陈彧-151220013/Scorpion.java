public class Scorpion implements Creature {
    private Position position;
    private String id;

    public Scorpion(String id) {
        this.id = id;
    }

    @Override
    public void report() {
        System.out.print(id + " ");
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        if(position != null) {
            position.setHolder(this);
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

}
