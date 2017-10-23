public class LouLuo implements Creature{
    private NAME name;
    private Position position;
    LouLuo(NAME name) {
        this.name = name;
    }
    @Override
    public void report(){
        System.out.print(this.name+" ");
    }

    public void setPosition(Position position){
        this.position = position;
        position.setHolder(this);
    }

    public Position getPosition(){
        return position;
    }
}
enum NAME{
    喽啰A,喽啰B,喽啰C,喽啰D,喽啰E,喽啰F
}
