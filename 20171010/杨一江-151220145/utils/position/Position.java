package utils.position;

import utils.coordinate._2Coordinate;

public class Position extends BasePosition{
    public Position(double x, double y){
        super(2);
        coord = new _2Coordinate(x, y);
    }


    @Override
    public String toString(){
        if(content == null)
            return coord + "{empty} ";
        else
            return coord + " {" + content.TellMyName() + "}";
    }




}
