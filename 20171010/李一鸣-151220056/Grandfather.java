public class Grandfather implements Creature {
    private Position position;
    private String name;
    Grandfather(String name){
        this.name = name;
    }
    @Override
    public void report(){
        System.out.print(this.name+"  ");
    }
    @Override
    public void setPosition(Position position){
        this.position = position;
        position.setHolder(this);
    }
    @Override
    public Position getPosition(){
        return position;
    }
}
