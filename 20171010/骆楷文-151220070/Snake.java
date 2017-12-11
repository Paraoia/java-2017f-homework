import com.sun.scenario.effect.impl.prism.PrImage;

public class Snake implements Creature {//蛇精

    private Position position;

    public String toString(){
        return "助威蛇精";
    }

    public void join(Square square){
        square.union(this);
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
