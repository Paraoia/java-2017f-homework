public class Xiaolouluo implements Creature, Comparable{

    private Position position;

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    Xiaolouluo() {

    }

    @Override
    public void report() {
        System.out.print(String.format("%-12s",this.toString()));
    }

    @Override
    public String toString(){
        return "@" + this.position.getX()+","+this.position.getY()+"小喽啰" + ";";
    }

    @Override
    public boolean biggerThan(Comparable brother){
        return false;//暂时未有动作
    }

}
