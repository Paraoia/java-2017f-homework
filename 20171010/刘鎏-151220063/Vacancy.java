public class Vacancy implements Creature {
    private Position position;

    @Override
    public void report(){
        System.out.print("空");
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
