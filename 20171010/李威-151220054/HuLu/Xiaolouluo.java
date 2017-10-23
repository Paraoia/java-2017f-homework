package HuLu;


public class Xiaolouluo implements Creature, Comparable{

    private Position position;

    
    Xiaolouluo(){}
    
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
        System.out.print(String.format("%-27s",this.toString()));
    }

  

    @Override
    public boolean isBiggerThan(Comparable brother){
        return false;
    }
    
    @Override
    public String toString(){
        return "#(" + this.position.getX()+","+this.position.getY()+")Сආ�" ;
    }

}