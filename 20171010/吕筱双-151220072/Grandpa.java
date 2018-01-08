public class Grandpa implements Creature{
    private String name;
    private Position position;

    public Grandpa(){
        this.name= "爷爷";
        this.position = null;
    }
@Override
    public void printName(){
           System.out.print(name);
    }
    @Override
    public Position getPosition(){return position;}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public void report(){
        System.out.print(this.toString());
    }

}
