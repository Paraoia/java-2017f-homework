package nju.cs.Camp;

import nju.cs.Creatures.Creature;
import nju.cs.Form.FormInfo;
import nju.cs.Form.PriorityPoint2D;
import nju.cs.Screen.Point2D;
import nju.cs.myEnum.EDIRECTION;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-07
 */
public class Camp  <T extends Creature>{
    FormInfo form;
    List<T> creatureList = new ArrayList<T>();
    Point2D leftUpPoint;
    EDIRECTION toward;

    static Logger logger = Logger.getLogger("Camp");

    public Camp() {
    }

    public Camp(FormInfo form, List<T> creatureList, Point2D leftUpPoint, EDIRECTION toward) {
        this.form = form;
        this.creatureList = creatureList;
        this.leftUpPoint = leftUpPoint;
        this.toward = toward;
    }

    public void addCreature(T creature){
        creatureList.add(creature);
    }

    public void setForm(FormInfo form) {
        this.form = form;
    }

    @SuppressWarnings("unchecked")
    public void setCreatureList(List<T> creatureList) {
        this.creatureList = creatureList;
    }

    public void setLeftUpPoint(Point2D leftUpPoint) {
        this.leftUpPoint = leftUpPoint;
    }

    public void setToward(EDIRECTION toward) {
        this.toward = toward;
    }

    public FormInfo getForm() {
        return form;
    }

    public List<T> getCreatureList() {
        return creatureList;
    }

    public Point2D getLeftUpPoint() {
        return leftUpPoint;
    }

    public EDIRECTION getToward() {
        return toward;
    }

    public void lineUp(){
        form.toward(toward);
        creatureList.sort((o1, o2) -> o1.getPriority() < o2.getPriority() ? 1 : 0);
        form.getPositions().sort((p1, p2) -> p1.getPriority() < p2.getPriority() ? 1 : 0);


        List<PriorityPoint2D> priorityPoint2DList = form.getPositions();
        for(Integer c = 0, p = 0; c < creatureList.size() && p < priorityPoint2DList.size();c++, p++){
            Creature creature = creatureList.get(c);
            Point2D point2D = new Point2D(leftUpPoint.getX() + priorityPoint2DList.get(p).getX(),
                    leftUpPoint.getY() + priorityPoint2DList.get(p).getY());
            creature.setPosition(point2D);
        }

        if (creatureList.size() > priorityPoint2DList.size()){
            logger.info("Creature size is larger than Form. Ignore the redundancy.");

        }

    }
}
