package utils.coordinate;

import utils.COORD;

public class _2RelaCoordinate extends RelaCoordinate {
    public _2RelaCoordinate(){
        super(2);
    }

    public _2RelaCoordinate(int X, int Y){
        super(2);
        setTensor(X, Y);
    }

    public _2RelaCoordinate(_2RelaCoordinate std){
        super(2);
        super.setTensors(std);
    }

    final public void setTensor(int X, int Y){
        tensors[COORD.X.d()] = X;
        tensors[COORD.Y.d()] = Y;
    }

    final public int X(){
        return tensors[COORD.X.d()];
    }

    final public int Y(){
        return tensors[COORD.Y.d()];
    }
}
