package creatures;
import positions.*;
public interface Creature {

    public void report();

    //一维
    public void setPosition(Position position);

    public Position getPosition();

    //二维
    public void setTwoDimPosition(TwoDimPosition position);

    public TwoDimPosition getTwoDimPosition();

    public void leaveTwoDimPosition();
}
