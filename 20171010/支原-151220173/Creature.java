enum Name
{HULUWA,GRANDPA,SNAKE,SCORPTION,MONSTOR}
public abstract class Creature {
    protected Position position;
    protected Name name;
    Creature()
    {
        position=null;
    }
    public void setPos(Position pos){leavePos();this.position = pos;}
    public Position getPos(){return this.position;}
    public void leavePos(){position = null;}
    public abstract void report();
}
