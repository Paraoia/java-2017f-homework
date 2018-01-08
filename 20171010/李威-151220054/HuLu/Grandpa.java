package HuLu;


public class Grandpa implements Creature, Comparable{

    private Position position;

    
    Grandpa() {}

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }


    @Override
    public void show() {
        System.out.print(String.format("%-30s",this.toString()));
    }


    @Override
    public boolean isBiggerThan(Comparable brother){
            return false;
    }
    
    
    @Override
    public String toString(){
        return "#(" + this.position.getX()+","+this.position.getY()+")үү" ;
    }


}