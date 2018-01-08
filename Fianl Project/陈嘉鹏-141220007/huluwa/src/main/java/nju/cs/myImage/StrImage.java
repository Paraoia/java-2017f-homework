package nju.cs.myImage;

import nju.cs.Screen.Point2D;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-05
 */
public class StrImage implements myImage{
    String image;

    public StrImage(String image){
        this.image = image;
    }

    public void draw(Point2D position){
        System.out.print(image);
    }

    public void drawNewLine(){
        System.out.print("\n");
    }

    public Integer getHeight(){
        return 1;
    }

    public Integer getWidth(){
        return image.length();
    }
}
