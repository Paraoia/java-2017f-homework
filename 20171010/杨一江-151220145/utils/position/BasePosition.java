package utils.position;

import character.Beings;
import utils.coordinate.Coordinate;

public class BasePosition {
    protected Coordinate coord;
    protected final int dimension;
    protected Beings content;

    BasePosition(int dimensionality){
        dimension = dimensionality;
        //coord = new Coordinate(dimension);
    }

    public boolean isOccupied(){
        if (content == null)
            return false;
        else
            return true;
    }

    public int TellDimensionality(){
        return dimension;
    }

    public boolean ConsistencyCheck(Beings chk){
        if (isOccupied()){
            return content == chk;
        }
        else
            return false;
    }

    final public boolean checkin(Beings standin){
        if(isOccupied())
            return false;
        else{
            content = standin;
            return true;
        }
    }

    final public Beings checkout(){
        if (isOccupied()){
            Beings reside = content;
            content = null;
            return reside;
        }
        return null;
    }

    public Beings getContent() {
        return content;
    }

}

