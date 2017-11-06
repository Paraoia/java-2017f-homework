package Formation;

import Position.PriorityPosition;
import mEnums.Direction;

import java.util.ArrayList;


public interface Formation {
    public void toward(Direction toDirection);

    public ArrayList<PriorityPosition> getDots();


}
