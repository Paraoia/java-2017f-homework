public class Creature {
    private String name;
    private Position pos;
    Creature(String name)
    {
        this.name=name;
        pos=null;
    }
    public void report(){
          System.out.print(name);
    }
    public void setPosition(Position position)//设置位置
    {
        this.pos=position;
        position.setHolder(this);
    }
    public void freePosition()//离开位置
    {
        this.pos.freeHolder();
        this.pos=null;
    }
    public Position getPosition() {
        return pos;
    }

}
