package positions;

import positions.Position;

public class TwoDimPosition extends Position {

    private int y;

    public int getY(){
        return  y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TwoDimPosition(int x, int y){
        setX(x);
        this.y=y;
    }

}
