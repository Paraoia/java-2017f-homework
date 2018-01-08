package creatures;

import positions.*;
import sorters.Comparable;

public class Huluwa implements Creature, Comparable {

    private COLOR color;
    private SENIORITY seniority;

    //一维
    private Position position;

    //二维
    private TwoDimPosition twoDPosition;


    public COLOR getColor() {
        return color;
    }

    public SENIORITY getSeniority() {
        return seniority;
    }


    public void setTwoDimPosition(TwoDimPosition position) {
        this.leaveTwoDimPosition();
        this.twoDPosition = position;
        twoDPosition.setHolder(this);
    }

    public TwoDimPosition getTwoDimPosition() {
        return twoDPosition;
    }

    public void leaveTwoDimPosition() {
        if(this.twoDPosition == null)
            ;
        else {
            this.twoDPosition.delHolder();
            this.twoDPosition = null;
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    public Huluwa(COLOR color, SENIORITY seiority) {
        this.color = color;
        this.seniority = seiority;
    }

    public void report() {
        ;
    }

    public boolean biggerThan(Comparable brother){

        if (brother instanceof  Huluwa)
            return this.getSeniority().ordinal()> ((Huluwa) brother).getSeniority().ordinal();
        else
            return false;
    }

}

