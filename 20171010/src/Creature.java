public abstract class Creature {
    protected String name;
    protected Position position;
    public void repoName(){
        System.out.print(name.toString());
    }
    public void setPosition(Position position){
        this.position = position;
        position.setHolder(this);
    }
    public Position getPosition(){
        return position;
    }
}
