import java.lang.System;
enum CreatureType{ Huluwa,Shejing,Yeye,Xiezijing,Loluo}
public abstract class Creature {

    protected CreatureType type;
    private Position position;

    public Position getPosition() {
        return position;
    }
    public CreatureType getType(){
        return this.type;
    }
    public void setPosition(Position position) {
        this.position = position;     //creature setposition 时 position 也set 了holder
        position.setHolder(this);
    }
    public void report(){
        System.out.println(type.toString());
    }//必须被
    public void clearPosition(){
        position=null;
    }
}
