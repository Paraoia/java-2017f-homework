package nju.cs.myImage;

import nju.cs.Screen.Point2D;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-05
 */
public interface myImage {
    public void draw(Point2D position);
    public void drawNewLine();
    public Integer getHeight();
    public Integer getWidth();
}
