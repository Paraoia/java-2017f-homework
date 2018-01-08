package nju.cs.myImage;

import nju.cs.Screen.Point2D;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-05
 */
public class PicImage implements myImage{

    Image image;
    Graphics g;

    static Logger logger = Logger.getLogger("PicImage");

    public PicImage(Image image){
        this.image = image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public void draw(Point2D position){
        g.drawImage(image, position.getX(), position.getY(), null);
    }

    public void drawNewLine(){
        logger.log(Level.SEVERE, "Pic image, should not touch here");
    }

    public Integer getHeight(){
        return image.getHeight(null);
    }

    public Integer getWidth(){
        return image.getHeight(null);
    }

}
