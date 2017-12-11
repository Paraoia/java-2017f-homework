package unit;

import field.Position;

public abstract class Unit implements CommunicateProtocol, CompareProtocol, MoveProtocol {
    private String name;
    //getter
    public String getName() {
        return name;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }

    private Position position = null;
    //getter
    public Position getPosition() {
        return position;
    }
    //setter
    public void setPosition(Position position) {
        this.position = position;
    }

    public Unit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void report() {
        System.out.print(toString());
    }

    @Override
    public int compareTo(Unit other) {
        Boolean mnull = this instanceof NullUnit;
        Boolean onull = other instanceof NullUnit;
        if (mnull && onull) return 0;
        else if (mnull) return 1;
        else if (onull) return -1;
        else return getName().compareTo(other.getName());
    }

    @Override
    public void moveTo(Position to) {
        //report
        System.out.println(getPosition() + " <-> " + to);
        //get
        Position from = getPosition();
        Unit me = this;
        Unit him = to.getSeat();
        //set
        me.setPosition(to);
        him.setPosition(from);
        from.setSeat(him);
        to.setSeat(me);
    }
}
