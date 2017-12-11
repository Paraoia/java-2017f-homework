import java.util.PrimitiveIterator;

public class Scorpion implements Creature {//蝎子精

    private Position position;

    public String toString(){
        return "老蝎子精";
    }

    @Override
    public void report(){
        System.out.print(this.toString());
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
