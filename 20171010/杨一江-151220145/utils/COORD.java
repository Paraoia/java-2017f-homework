package utils;

public enum COORD {
    X(0), Y(1);

    int dimensionality;

    COORD(int i){
        this.dimensionality = i;
    }

    final public int d(){
        return dimensionality;
    }
}