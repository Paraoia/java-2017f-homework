package nju.cs.myImage;

import nju.cs.Screen.Point2D;
import nju.cs.XmlParse.XmlParse;
import org.dom4j.Element;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-08
 */
public class PicInfo implements XmlParse{
    Point2D leftUp;
    Point2D rightDown;
    String name;
    String fileName;
    String filetype;
    Image img;

    public PicInfo() {
    }

    public PicInfo(Point2D leftUp, Point2D rightDown, String name, Image img) {
        this.leftUp = leftUp;
        this.rightDown = rightDown;
        this.name = name;
        this.img = img;
    }

    public Point2D getLeftUp() {
        return leftUp;
    }

    public Point2D getRightDown() {
        return rightDown;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFiletype() {
        return filetype;
    }

    public Image getImg() {
        return img;
    }

    public void setLeftUp(Point2D leftUp) {
        this.leftUp = leftUp;
    }

    public void setRightDown(Point2D rightDown) {
        this.rightDown = rightDown;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public static Image findByName(PicInfo[] p, String name){
        for(PicInfo i: p){
            if (i.getName().equals(name)){
                return i.getImg();
            }
        }
        return null;
    }

    public XmlParse parseElement(Element e){
        PicInfo picInfo = new PicInfo();
        picInfo.setName(e.elementText("name"));
        picInfo.setFileName(e.elementText("filename"));
        picInfo.setFiletype(e.elementText("filetype"));


        Pattern p = Pattern.compile("\\((\\d+),\\s(\\d+)\\)");
        String leftUp = e.elementText("leftUpPoint");
        String rightDown = e.elementText("righDownPiont");
        Matcher m = p.matcher(leftUp);
        m.find();
        picInfo.setLeftUp(new Point2D(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
        m = p.matcher(rightDown);
        m.find();
        picInfo.setRightDown(new Point2D(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));

        BufferedImage bufferedImage = null;
        try{
            bufferedImage = ImageIO.read(new FileInputStream("src/main/resources/pic/" + picInfo.getFileName() + "." + picInfo.getFiletype()));
            Image img = bufferedImage.getSubimage(picInfo.getLeftUp().getX(), picInfo.getLeftUp().getY(),
                    picInfo.getRightDown().getX()-picInfo.getLeftUp().getX(), picInfo.getRightDown().getY()-picInfo.getLeftUp().getY());
            picInfo.setImg(img);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return picInfo;

    }
}
