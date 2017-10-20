package Xzr.Creature;

import Xzr.Position.Position;

public interface Creature {
    public void countOff();

    public void setPosition(Position position);

    public Position getPosition();

    public String getName();
}
