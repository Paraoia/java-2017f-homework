public class Grandpa implements Creature {
    private Position position;
    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }
    @Override
    public Position getPosition() {
        return position;
    }
    @Override
    public void report() {
        System.out.print(this.toString());
    }

    @Override
    public String toString(){
        return "爷爷@" + this.position.getX() + ","+this.position.getY()+";";
    }
}
