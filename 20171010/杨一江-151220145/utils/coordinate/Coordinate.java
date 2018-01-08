package utils.coordinate;

public class Coordinate {
    final int dimension;
    protected double[] tensors;

    public Coordinate(int dimension){
        if(dimension <= 1)  dimension = 1;
        this.dimension = dimension;
        tensors = new double[dimension];
    }

    public double[] getTensors(){
        return tensors;
    }

    public boolean setTensors(Coordinate std){
        if(std.dimension != this.dimension)
            return false;
        for (int i = 0; i < dimension; i++) {
            tensors[i] = std.tensors[i];
        }
        return true;
    }

    public boolean setTensors(double... doubles){
        if(doubles.length != dimension)
            return false;
        for (int i = 0; i < dimension; i++) {
            tensors[i] = doubles[i];
        }
        return true;
    }

    @Override
    public String toString(){
        String ret = "(" + tensors[tensors.length - 1];
        for (int i = tensors.length - 2; i >= 0 ; i--) {
            ret += ("," + tensors[i]);
        }
        ret += ")";
        return ret;
    }
}
