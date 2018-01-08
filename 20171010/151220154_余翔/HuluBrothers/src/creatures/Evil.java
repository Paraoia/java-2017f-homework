package creatures;

import positions.*;

public class Evil implements Creature {

    EVILNAME name;

    //
    private Position position;

    //二维
    private TwoDimPosition twoDPosition;

    public Evil(EVILNAME Evilname){
        this.name = Evilname;
    }

    public EVILNAME getName() {
        return this.name;
    }

    public void report(){
        ;
    }

    public void talk(String str){
        System.out.print(str);
    }

    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setTwoDimPosition(TwoDimPosition position) {
        this.leaveTwoDimPosition();
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

;