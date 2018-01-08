package nju.cs.myEnum;

import nju.cs.Screen.Point2D;
import java.util.HashMap;

/**
 * @author chenjiapeng
 * @Description
 *          有关Direction表达格式的转换
 * @date 2018-01-07
 */
public class DirectionMap {
    private static final HashMap<EDIRECTION, Point2D> E2Pmap;
    private static final HashMap<String, EDIRECTION> S2Emap;

    static {
        E2Pmap = new HashMap<EDIRECTION, Point2D>();
        E2Pmap.put(EDIRECTION.北, new Point2D(0, -1));
        E2Pmap.put(EDIRECTION.东, new Point2D(1, 0));
        E2Pmap.put(EDIRECTION.南, new Point2D(0, 1));
        E2Pmap.put(EDIRECTION.西, new Point2D(-1, 0));
        E2Pmap.put(EDIRECTION.东北, new Point2D(1, -1));
        E2Pmap.put(EDIRECTION.东南, new Point2D(1, 1));
        E2Pmap.put(EDIRECTION.西南, new Point2D(-1, 1));
        E2Pmap.put(EDIRECTION.西北, new Point2D(-1, -1));
    }

    static {
        S2Emap = new HashMap<String, EDIRECTION>();
        S2Emap.put(EDIRECTION.北.toString(), EDIRECTION.北);
        S2Emap.put(EDIRECTION.东.toString(), EDIRECTION.东);
        S2Emap.put(EDIRECTION.南.toString(), EDIRECTION.南);
        S2Emap.put(EDIRECTION.西.toString(), EDIRECTION.西);
        S2Emap.put(EDIRECTION.东北.toString(), EDIRECTION.东北);
        S2Emap.put(EDIRECTION.东南.toString(), EDIRECTION.东南);
        S2Emap.put(EDIRECTION.西南.toString(), EDIRECTION.西南);
        S2Emap.put(EDIRECTION.西北.toString(), EDIRECTION.西北);
    }

    public static Point2D EDirection2Point2D(EDIRECTION e){
        return E2Pmap.get(e);
    }

    public static EDIRECTION String2EDirection(String s){
        return S2Emap.get(s);
    }



}
