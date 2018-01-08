public class Buddy implements Creature {
    private Position position;
    int index;
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
        return "小喽啰"+this.index+"@" + this.position.getX() + ","+this.position.getY()+";";
    }
    Buddy(int i) {
        this.index = i;

    }
}