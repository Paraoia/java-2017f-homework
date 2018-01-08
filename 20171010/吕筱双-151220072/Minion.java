public class Minion implements Creature  {
    private String  name ;
    private Position position;

    public Minion(int num){
        this.name= "喽"+String.format("%02d",num);
    }

    public void printName() {
        System.out.print(this.getName());
    }

    public String  getName() {
        return name;
    }

    @Override
    public Position getPosition(){return position;}

    @Override
    public void setPosition(Position position){
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public String toString() {
        return "Minion{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }

    @Override
    public void report(){
        System.out.print(this.toString());
    }

}
