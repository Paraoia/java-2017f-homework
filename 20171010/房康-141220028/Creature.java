public abstract class Creature implements Comparable {

    private Position position;

    public abstract String speak();

    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position p){
        this.position = p;
    }

    public Creature(){
        this.position = null;
    }
}
