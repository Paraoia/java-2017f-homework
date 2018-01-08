package nju.cs.State;

import nju.cs.Screen.Point2D;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-08
 */
public class Stateinfo{
    Integer blood;
    Integer magic;
    Point2D moveStep;

    public Stateinfo() {
    }

    public Stateinfo(Integer blood, Integer magic, Point2D moveStep) {
        this.blood = blood;
        this.magic = magic;
        this.moveStep = moveStep;
    }

    public Integer getBlood() {
        return blood;
    }

    public Integer getMagic() {
        return magic;
    }

    public Point2D getMoveStep() {
        return moveStep;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public void setMagic(Integer magic) {
        this.magic = magic;
    }

    public void setMoveStep(Point2D moveStep) {
        this.moveStep = moveStep;
    }

    @Override
    public String toString() {
        String rs = "";
        if (blood != null)
            rs += blood.toString();
        else if (magic != null)
            rs += magic.toString();
        else if(moveStep != null)
            rs += moveStep.toString();
        return rs;
    }
}
