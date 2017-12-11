package utils.coordinate;

public class RelaCoordinate {
    final int dimension;
    protected int[] tensors;

    public RelaCoordinate(int dimension){
        if(dimension <= 1)  dimension = 1;
        this.dimension = dimension;
        tensors = new int[dimension];
    }

    public int[] getTensors(){
        return tensors;
    }

    public boolean setTensors(RelaCoordinate std){
        if(std.dimension != this.dimension)
            return false;
        for (int i = 0; i < dimension; i++) {
            tensors[i] = std.tensors[i];
        }
        return true;
    }

    public boolean setTensors(int... ints){
        if(ints.length != dimension)
            return false;
        for (int i = 0; i < dimension; i++) {
            tensors[i] = ints[i];
        }
        return true;
    }

    @Override
    public String toString(){
        String ret = "[" + tensors[0];
        for (int i: tensors
                ) {
            ret += ("," + i);
        }
        ret += "]";
        return ret;
    }
}
