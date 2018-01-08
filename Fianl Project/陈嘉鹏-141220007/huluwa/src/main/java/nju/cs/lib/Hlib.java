package nju.cs.lib;

import nju.cs.Creatures.Creature;
import nju.cs.Main;
import nju.cs.Screen.Point2D;
import nju.cs.myEnum.DirectionMap;
import nju.cs.myEnum.ECreatureType;
import nju.cs.myEnum.EDIRECTION;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjiapeng
 * @Description
 *           一些各个模块中经常使用的函数库
 * @date 2018-01-07
 */
public class Hlib {

    public static Double distanceBetween(Point2D p1, Point2D p2){
        Integer dx = p1.getX() - p2.getX();
        Integer dy = p1.getY() - p2.getY();
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public static <T extends Creature> T nearestCreature(T origin, List<T> list){
        T rs = list.get(0);
        for(T c: list)
            if (    distanceBetween(origin.getPosition(), c.getPosition())
                    <
                    distanceBetween(origin.getPosition(), rs.getPosition())
                    )
                rs = c;
        return rs;
    }

    public static <T extends Creature> boolean canMoveTo(EDIRECTION e, T origin, List<T> list){
        Point2D p = origin.getPosition().add(DirectionMap.EDirection2Point2D(e));
        for(Creature c: list){
            if (c.getPosition() == p){
                return false;
            }
        }
        return true;
    }

    public static <T extends Creature> T nearestEnemy(T origin, List<T> list) {
        T rs= null;
        for (T c: list) {
            if (origin.isEnemy(c)) {
                rs = c;
                break;
            }
        }
        for (T c : list)
            if (origin.isEnemy(c) &&
                    distanceBetween(origin.getPosition(), c.getPosition())
                            <
                            distanceBetween(origin.getPosition(), rs.getPosition())
                    )
                rs = c;
        return rs;
    }

    public static EDIRECTION toDirection(Creature origin, Creature creature){
       double angle = angleBetween(origin.getPosition(), creature.getPosition());
       double [] angletop = new double[]{
               22.5, 67.5, 112.5, 157.5, 202.5, 247.5, 292.5, 337.5
       };
       EDIRECTION[] edirections = new EDIRECTION[]{
               EDIRECTION.东南, EDIRECTION.南, EDIRECTION.西南, EDIRECTION.西,
               EDIRECTION.西北, EDIRECTION.北, EDIRECTION.东北, EDIRECTION.东
       };

       if (angle < 0)
           angle += 360;
       if (angle < angletop[0])
           return EDIRECTION.东;
       for (Integer i = 0; i < angletop.length;++i){
           if (angletop[i] < angle && angletop[i]+45 >= angle)
               return edirections[i];
       }
    return null;
    }
    public static double angleBetween(Point2D origin, Point2D dst){
        return Math.atan2(dst.getY()-origin.getY(), dst.getX()-origin.getX())*180/Math.PI;
    }

    public static <T extends Creature> List<T> findTypeFromList(List<T> list, ECreatureType t){
        List<T> rs = new ArrayList<T>();
        for(T e: list){
            if (e.geteCreatureType() == t)
                rs.add(e);
        }
        return rs;
    }

}
