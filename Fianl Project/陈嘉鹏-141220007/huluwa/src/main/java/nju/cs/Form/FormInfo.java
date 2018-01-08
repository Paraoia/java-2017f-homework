package nju.cs.Form;

import nju.cs.Screen.Point2D;
import nju.cs.XmlParse.XmlParse;
import nju.cs.myEnum.DirectionMap;
import nju.cs.myEnum.EDIRECTION;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-07
 */
public class FormInfo implements XmlParse {
    String name;
    EDIRECTION edirection;
    Integer Height;
    Integer Width;
    List<PriorityPoint2D> positions = new ArrayList<PriorityPoint2D>();

    public String getName() {
        return name;
    }

    public EDIRECTION getEdirection() {
        return edirection;
    }

    public List<PriorityPoint2D> getPositions() {
        return positions;
    }

    public Integer getHeight() {
        return Height;
    }

    public Integer getWidth() {
        return Width;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEdirection(EDIRECTION edirection) {
        this.edirection = edirection;
    }

    public void setPositions(List<PriorityPoint2D> positions) {
        this.positions = positions;
    }

    public void setHeight(Integer height) {
        Height = height;
    }

    public void setWidth(Integer width) {
        Width = width;
    }

    public void toward(EDIRECTION toDirection){
        //注意：只支持东南西北四个方向
        int diff = toDirection.ordinal() - this.edirection.ordinal();
        diff = diff < 0 ? diff + 4 : diff;
        List<PriorityPoint2D> lp = new ArrayList<PriorityPoint2D>();

        for(Integer i = 0; i < diff; ++i){
            for(PriorityPoint2D p: positions){
                Integer x = p.getX();
                Integer y = p.getY();
                p.setX(Height - y - 1);
                p.setY(x);
            }
            Integer newH = Width;
            Integer newW = Height;
            this.Height = newH;
            this.Width = newW;
        }
        this.edirection = toDirection;

    }

    private static List<Point2D> parseString(List<String> strs){
        ArrayList<Point2D> point2DArrayList = new ArrayList<Point2D>();
        for(Integer i = 0; i < strs.size(); ++i){
            String s = strs.get(i);
            for(Integer j = 0; j < s.length(); ++j){
                if (s.charAt(j) == '@'){
                    point2DArrayList.add(new Point2D(j, i));
                }
            }
        }
        return point2DArrayList;
    }

    private static List<PriorityPoint2D> Point2D2PriorityPoint2D(List<Point2D> point2DList, FormInfo formInfo){
        List<PriorityPoint2D> priorityPoint2DList = new ArrayList<PriorityPoint2D>();
        Point2D p = DirectionMap.EDirection2Point2D(formInfo.getEdirection());
        Integer x_init = p.getX() == 1 ? formInfo.getWidth()-1 : 0;
        Integer x_limit = x_init == 0 ? formInfo.getWidth() : -1;
        Integer x_step = x_init == 0 ? 1 : -1;
        Integer y_init = p.getY() == 1 ? formInfo.getHeight()-1 : 0;
        Integer y_limit = y_init == 0 ? formInfo.getHeight() : -1;
        Integer y_step = y_init == 0 ? 1 : -1;

        Integer priority = 1;
        if (formInfo.edirection == EDIRECTION.东 || formInfo.edirection == EDIRECTION.西){
            for(Integer x = x_init;x != x_limit; x += x_step){
                for(Integer y = y_init;y != y_limit; y += y_step){
                    if(point2DList.contains(new Point2D(x, y))){
                        priorityPoint2DList.add(new PriorityPoint2D(x, y, priority++));
                    }
                }
            }
        }
        else{
            for(Integer y = y_init;y != y_limit; y += y_step){
                for(Integer x = x_init;x != x_limit; x += x_step){
                    if(point2DList.contains(new Point2D(x, y))){
                        priorityPoint2DList.add(new PriorityPoint2D(x, y, priority++));
                    }
                }
            }
        }
        return priorityPoint2DList;
    }

    public XmlParse parseElement(Element e){
        FormInfo formInfo = new FormInfo();
        formInfo.setName(e.elementText("name"));
        formInfo.setEdirection(DirectionMap.String2EDirection(e.elementText("direction")));

        ArrayList<String> dots = new ArrayList<String>();
        Element eDots = e.element("dots");
        for(Iterator i = eDots.elementIterator(); i.hasNext();){
            Element t = (Element) i.next();
            dots.add(t.getTextTrim());
        }
        formInfo.setHeight(dots.size());
        formInfo.setWidth(dots.get(0).length());
        formInfo.setPositions(FormInfo.Point2D2PriorityPoint2D(FormInfo.parseString(dots), formInfo));
        return formInfo;
    }

}
