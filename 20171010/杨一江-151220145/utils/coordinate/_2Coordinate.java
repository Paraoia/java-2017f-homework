package utils.coordinate;

import utils.COORD;

public class _2Coordinate extends Coordinate{
    public _2Coordinate(){
        super(2);
    }

    public _2Coordinate(double X, double Y){
        super(2);
        setTensor(X, Y);
    }

    public _2Coordinate(_2Coordinate std){
        super(2);
        super.setTensors(std);
    }

    final public void setTensor(double X, double Y){
        tensors[COORD.X.d()] = X;
        tensors[COORD.Y.d()] = Y;
    }

    final public double X(){
        return tensors[COORD.X.d()];
    }

    final public double Y(){
        return tensors[COORD.Y.d()];
    }

    public final static _2Coordinate Regularized_Scale = new _2Coordinate(1,1);

    public final static _2Coordinate Origin = new _2Coordinate(0,0);
}
