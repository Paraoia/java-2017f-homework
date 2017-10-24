public class Grandpa implements Creature {
    private Position position;

    public String toString(){
        return "助威爷爷";
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
