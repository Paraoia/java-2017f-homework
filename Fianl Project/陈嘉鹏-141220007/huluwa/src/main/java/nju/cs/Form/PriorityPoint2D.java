package nju.cs.Form;

import nju.cs.Screen.Point2D;

/**
 * @author chenjiapeng
 * @Description
 *         用于阵列点的优先级描述，首领应该放置于优先级最高的位置，小兵应放置于优先级稍低的区域
 * @date 2018-01-07
 */
public class PriorityPoint2D extends Point2D implements Priority{
    Integer priority;

    public PriorityPoint2D(int x, int y) {
        super(x, y);
    }

    public PriorityPoint2D(int x, int y, Integer priority) {
        super(x, y);
        this.priority = priority;
    }

    public void setPriority(Integer priority){
        this.priority = priority;
    }
    public Integer getPriority(){
        return priority;
    }
    public boolean comparePriority(Priority priority){
        return this.priority < priority.getPriority();
    }

    @Override
    public boolean equals(Object arg0){
        if (arg0 != null && arg0 instanceof PriorityPoint2D)
            return getX() == ((Point2D) arg0).getX() && getY() == ((Point2D) arg0).getY();
        return false;
    }
}
