public class Monster implements Creature{
    private String name;
    private Position position;
    public Monster(String name){
        this.name = name;
    }
    @Override
    public void report(){
        System.out.print(this.name);
    }

    public void setPosition(Position position){
        this.position = position;
        position.setHolder(this);
    }

    public Position getPosition(){
        return position;
    }
}
