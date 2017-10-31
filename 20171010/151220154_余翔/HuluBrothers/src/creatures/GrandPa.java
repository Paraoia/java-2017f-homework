package creatures;

import creatures.Creature;
import positions.*;

public class GrandPa implements Creature {

    //
    private Position position;

    //二维
    private TwoDimPosition twoDPosition;

    public void report(){
        ;
    }

    public void talk(String str){
        System.out.print(str);
    }

    public void setPosition(Position position) {
        this.leaveTwoDimPosition();
        this.position = position;
        position.setHolder(this);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setTwoDimPosition(TwoDimPosition position) {
        this.twoDPosition = position;
        this.twoDPosition.setHolder(this);
    }

    public void leaveTwoDimPosition() {
        if(this.twoDPosition == null)
            ;
        else {
            this.twoDPosition.delHolder();
            this.twoDPosition = null;
        }
    }

    public TwoDimPosition getTwoDimPosition() {
        return this.twoDPosition;
    }

}
