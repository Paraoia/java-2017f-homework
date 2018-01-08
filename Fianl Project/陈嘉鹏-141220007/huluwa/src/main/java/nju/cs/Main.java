package nju.cs;

import nju.cs.Camp.Camp;
import nju.cs.Creatures.*;
import nju.cs.Form.FormInfo;
import nju.cs.Screen.Point2D;
import nju.cs.Screen.Screen;
import nju.cs.XmlParse.XmlParse;
import nju.cs.XmlParse.XmlReader;
import nju.cs.myEnum.ECOLOR;
import nju.cs.myEnum.EDIRECTION;
import nju.cs.myEnum.ESENIORITY;
import nju.cs.myImage.PicImage;
import nju.cs.myImage.PicInfo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

/**
 * @author chenjiapeng
 * @Description
 *          Just main function. Init JFrame and set start background.
 * @date 2018-01-05
 */
public class Main extends JFrame{

    static Logger logger = Logger.getLogger("Main");
    public Main() {
        InitUI();
    }
    public static boolean start = false;
    ArrayList<Creature> creatureList = new ArrayList<Creature>();

    @SuppressWarnings("unchecked")
    private void InitCreature(Screen screen){
        XmlParse[] xmlParseInfos = XmlReader.<PicInfo>parse("src/main/resources/pic/pictures.xml", PicInfo.class);
        PicInfo []picInfo = new PicInfo[xmlParseInfos.length];
        XmlReader.castArray(picInfo, xmlParseInfos);

        xmlParseInfos = XmlReader.<FormInfo>parse("src/main/resources/forms.xml", FormInfo.class);
        FormInfo[] formInfos = new FormInfo[xmlParseInfos.length];
        XmlReader.castArray(formInfos, xmlParseInfos);

        ArrayList<Huluwa> huluwas = new ArrayList<Huluwa>(
                Arrays.asList(
                        new Huluwa(1000, 50, ESENIORITY.大.ordinal(), new PicImage(PicInfo.findByName(picInfo, "大娃")), screen,1, ECOLOR.红, ESENIORITY.大),
                        new Huluwa(1000, 50, ESENIORITY.二.ordinal(), new PicImage(PicInfo.findByName(picInfo, "二娃")), screen,2, ECOLOR.橙, ESENIORITY.二),
                        new Huluwa(1000, 50, ESENIORITY.三.ordinal(), new PicImage(PicInfo.findByName(picInfo, "三娃")), screen,3, ECOLOR.黄, ESENIORITY.三),
                        new Huluwa(1000, 50, ESENIORITY.四.ordinal(), new PicImage(PicInfo.findByName(picInfo, "四娃")), screen,4, ECOLOR.绿, ESENIORITY.四),
                        new Huluwa(1000, 50, ESENIORITY.五.ordinal(), new PicImage(PicInfo.findByName(picInfo, "五娃")), screen,5, ECOLOR.青, ESENIORITY.五),
                        new Huluwa(1000, 50, ESENIORITY.六.ordinal(), new PicImage(PicInfo.findByName(picInfo, "六娃")), screen,6, ECOLOR.蓝, ESENIORITY.六),
                        new Huluwa(1000, 50, ESENIORITY.七.ordinal(), new PicImage(PicInfo.findByName(picInfo, "七娃")), screen,7, ECOLOR.紫, ESENIORITY.七)
                )
        );

        ArrayList<Sprite> sprites = new ArrayList<>(
                Arrays.asList(
                        new Sprite(600, 10, 11, new PicImage(PicInfo.findByName(picInfo, "鼠")), screen, 1),
                        new Sprite(600, 10, 11, new PicImage(PicInfo.findByName(picInfo, "鼠")), screen, 2),
                        new Sprite(600, 10, 10, new PicImage(PicInfo.findByName(picInfo, "蛙")), screen, 3),
                        new Sprite(600, 10, 10, new PicImage(PicInfo.findByName(picInfo, "蛙")), screen, 4),
                        new Sprite(600, 10, 10, new PicImage(PicInfo.findByName(picInfo, "蛙")), screen, 5)
                )
        );
        Creature grandpa = new Grandpa(600, 10, 10, new PicImage(PicInfo.findByName(picInfo, "爷爷")), screen, 1);
        Creature snake = new Snake(2000, 400, 1, new PicImage(PicInfo.findByName(picInfo, "蛇精")), screen, 1);
        Creature scorpion = new Scorpion(3000, 20, 2, new PicImage(PicInfo.findByName(picInfo, "蝎子")), screen, 11);

        creatureList.addAll(huluwas);
        creatureList.addAll(sprites);
        creatureList.add(grandpa);
        creatureList.add(snake);
        creatureList.add(scorpion);

        Creature.setCountDownLatch(new CountDownLatch(creatureList.size()));
        Creature.setCreatureNum(creatureList.size());

        Camp camp1 = new Camp(formInfos[7], huluwas, new Point2D(0, 0), EDIRECTION.东);
        camp1.addCreature(grandpa);
        camp1.lineUp();

        Camp camp2 = new Camp(formInfos[4], sprites, new Point2D(5, 0), EDIRECTION.西);
        camp2.addCreature(snake);
        camp2.addCreature(scorpion);
        camp2.lineUp();
        screen.addCreatures(creatureList);
    }

    public void InitUI() {
        Screen screen = new Screen("background0", null);
        add(screen);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(screen.getBackgroundWidth(),
                screen.getBackgroundHeight());
        logger.info("Set screen : " + screen.getBackgroundWidth() + "*" + screen.getBackgroundHeight());
        setLocationRelativeTo(null);
        setTitle("Huluwa");
        setResizable(false);
        InitCreature(screen);
        Thread t = new Thread(screen);
        t.start();
        this.setVisible(true);

        while (true) {
            if (Main.start) {
                ThreadRun(screen);
                break;
            }
            try{
                Thread.sleep(100);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    void ThreadRun(Screen screen){
        for(Creature c: creatureList){
            c.setMoveFrequency(1);
            c.setAttackFrequency(1);
        }
        for(Creature c: creatureList){
            Thread t = new Thread(c);
            t.start();
        }
    }


    public static void main(String[] args){
        new Main();
        logger.info("Show JFrame");

    }
}
