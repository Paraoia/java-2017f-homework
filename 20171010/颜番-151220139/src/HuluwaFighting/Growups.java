package HuluwaFighting;

public class Growups implements Creature {
    private String name;
    private Position pos;

    public Growups(String _name){
        this.name = _name;
    }
    public String getName(){
        return name;
    }
    public void report(){
        System.out.println(name);
    }

    public Position getPosition(){
        return pos;
    }

    public void clearPosition(){
        if(pos!=null){
            pos.clearHolder();
            this.pos = null;
        }
    }

    public void setPosition(Position position){
        this.pos = position;
        position.setHolder(this);
    }

}
