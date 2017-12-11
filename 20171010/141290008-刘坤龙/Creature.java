
public class Creature {

    String name;

    Position position;

    Creature(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    public void setPosition(Position position){
        this.position = position;
        if(position != null)
            position.setHolder(this);
    }

    public Position getPosition(){
        return this.position;
    }
}
