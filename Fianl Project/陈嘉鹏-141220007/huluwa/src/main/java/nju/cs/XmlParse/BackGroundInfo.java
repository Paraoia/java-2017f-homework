package nju.cs.XmlParse;

import nju.cs.Screen.Point2D;
import org.dom4j.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenjiapeng
 * @Description
 *            对应于background.xml格式
 * @date 2018-01-06
 */
public class BackGroundInfo implements XmlParse{
    String name;
    String type;
    String discription;
    Integer row;
    Integer col;
    Point2D leftUP;
    Point2D rightDown;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDiscription() {
        return discription;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }

    public Point2D getLeftUP() {
        return leftUP;
    }

    public Point2D getRightDown() {
        return rightDown;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public void setLeftUP(Point2D leftUP) {
        this.leftUP = leftUP;
    }

    public void setRightDown(Point2D rightDown) {
        this.rightDown = rightDown;
    }

    public XmlParse parseElement(Element e){
        BackGroundInfo bg = new BackGroundInfo();
        bg.setName(e.elementText("name"));
        bg.setType(e.elementText("type"));
        bg.setDiscription(e.elementText("discription"));
        bg.setRow(Integer.parseInt(e.elementText("row")));
        bg.setCol(Integer.parseInt(e.elementText("col")));

        Pattern p = Pattern.compile("\\((\\d+),\\s(\\d+)\\)");
        String leftUp = e.elementText("leftUp");
        String rightDown = e.elementText("rightDown");
        Matcher m = p.matcher(leftUp);
        m.find();
        bg.setLeftUP(new Point2D(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
        m = p.matcher(rightDown);
        m.find();
        bg.setRightDown(new Point2D(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));

        return bg;
    }
}
