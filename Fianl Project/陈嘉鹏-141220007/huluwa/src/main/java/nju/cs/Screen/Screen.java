package nju.cs.Screen;

import nju.cs.Creatures.Creature;
import nju.cs.Main;
import nju.cs.State.State;
import nju.cs.State.StateType;
import nju.cs.XmlParse.BackGroundInfo;
import nju.cs.XmlParse.XmlParse;
import nju.cs.XmlParse.XmlReader;
import nju.cs.myImage.PicImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * @author chenjiapeng
 * @Description
 *           Screen作为整个屏幕来进行每个物体的绘制
 * @date 2018-01-05
 */
public class Screen extends JPanel implements Runnable{
    private Point2D scope = new Point2D();

    static Logger logger = Logger.getLogger("Screen");

    private ArrayList<Creature> creatureArrayList = new ArrayList<Creature>();
    private Creature[] space;
    private Map<Integer, ArrayList<Point2D>> Space2Pixel = new HashMap<>();
    private ArrayList<State> statesMsg = new ArrayList<State>();

    Integer rowPixel;
    Integer colPixel;

    private Creature fill = null;
    private String backgroundName;
    private BackGroundInfo usedDackGroundInfo = null;
    private BackGroundInfo[] backGroundInfos = null;
    static Image background;

    //locks
    Lock stateMsgLock = new ReentrantLock();
    private Object msgCanApply = new Object();
    private Object screenlock = new Object();

    public Screen(String backgroundName, Creature fill) {
        XmlParse[] xmlParseInfos = XmlReader.<BackGroundInfo>parse("src/main/resources/background/backgrounds.xml", BackGroundInfo.class);
        backGroundInfos = new BackGroundInfo[xmlParseInfos.length];
        XmlReader.castArray(backGroundInfos, xmlParseInfos);
        for(BackGroundInfo b: backGroundInfos) {
            if (b.getName().equals(backgroundName)) {
                String path = "src/main/resources/background/" + b.getName() + "." + b.getType();
                background = new ImageIcon(path).getImage();
                logger.info("open " + path + " as background.");
                scope.setX(b.getRow());
                scope.setY(b.getCol());
                usedDackGroundInfo = b;
            }
        }
        this.backgroundName = backgroundName;
        this.fill = fill;
        space = new Creature[scope.getX()*scope.getY()];
        Arrays.fill(space, fill);
        parseBackground ();

        addKeyListener(new TAdapter());
        setFocusable(true);
    }


    private void parseBackground(){
        Point2D leftUp = usedDackGroundInfo.getLeftUP();
        Point2D rightDown = usedDackGroundInfo.getRightDown();
        Integer row = usedDackGroundInfo.getRow();
        Integer col = usedDackGroundInfo.getCol();
        rowPixel = (rightDown.getX() - leftUp.getX())/row;
        colPixel = (rightDown.getY() - leftUp.getY())/col;
        for(Integer i = 0; i < row; i++){
            for (Integer j = 0; j < col; j++){
                ArrayList<Point2D> p = new ArrayList<>();
                p.add(new Point2D(leftUp.getX()+i*rowPixel, leftUp.getY()+j*colPixel));
                p.add(new Point2D(leftUp.getX()+(i+1)*rowPixel, leftUp.getY()+(j+1)*colPixel));
                try{
                    Space2Pixel.put(calculateIdx(new Point2D(i, j)), p);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


    }

    public ArrayList<Creature> getCreatureArrayList(){
        return creatureArrayList;
    }

    public void addCreature(Creature creature){
        creatureArrayList.add(creature);
    }

    public Object getScreenlock() {
        return screenlock;
    }

    public void pushStateMsg(State s){
        stateMsgLock.lock();
        try{
            statesMsg.add(s);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            stateMsgLock.unlock();
        }
    }

    public void stateMsgApply(){
        stateMsgLock.lock();
        try {
            synchronized (msgCanApply) {
                if (Creature.getCountDownLatch().getCount() != Creature.getCreatureNum()) {
                    logger.info(" screen wait creature   " + Creature.getCountDownLatch().getCount() + "/" + Creature.getCreatureNum());
//                    msgCanApply.wait();
                }
            }
            for (State s : statesMsg) {
                if (s.getStateType() == StateType.移动) {
                    Point2D p = s.getStateinfo().getMoveStep().add(s.getTarget().getPosition());
                    if(p.getX() >= scope.getX() || p.getY() >= scope.getY() || p.getX() < 0 || p.getY() < 0)
                        continue;
                    Integer idx = calculateIdx(s.getStateinfo().getMoveStep().add(s.getTarget().getPosition()));
                    if (space[idx] == null) {
                        flushSpace(s.getTarget());
                        s.apply(s.getTarget());
                        layout(s.getTarget());
                        logger.info("apply : " + s.toString());
                    } else
                        logger.info("ignore : " + s.toString());
                } else if (s.getStateType() == StateType.死亡) {
                    creatureArrayList.remove(s.getTarget());
                    logger.info("apply : " + s.toString());
                } else {
                    s.apply(s.getTarget());
                    logger.info("apply : " + s.toString());
                }

            }
            statesMsg.clear();


            synchronized (screenlock) {
                logger.info("screen notifyAll");
                screenlock.notifyAll();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            stateMsgLock.unlock();
        }
    }

    public Integer getBackgroundWidth(){
        return background.getWidth(null);
    }

    public Integer getBackgroundHeight(){
        return background.getHeight(null);
    }

    public Point2D getScope() {
        return scope;
    }

    public Object getMsgCanApply() {
        return msgCanApply;
    }

    private Integer calculateIdx(Point2D point) throws Exception{
        if (point.getX() >= scope.getX() || point.getY() >= scope.getY())
            throw new Exception("[Screen.calculateIdx] Out of Screen");
        return point.getY()*scope.getX() + point.getX();
    }
    private void flushSpace(Creature creature) throws  Exception{
        Integer idx = calculateIdx(creature.getPosition());
        space[idx] = null;
    }

    private void layout(Creature creature) throws Exception{
        if (!creature.isAlive())
            return;
        Integer idx = calculateIdx(creature.getPosition());
        space[idx] = creature;
        logger.info(creature.getCreatureName() + " layout in space " + creature.getPosition().toString());
    }

    public void layout2Space() throws Exception{
        clear();
        for (Creature creature: creatureArrayList)
            layout(creature);
    }

    /**
     * 从space的矩阵值域转换到实际图片的位置上
     *
     */
    public Point2D TranslatePosition(Point2D spacePoint){
        //返回左下角
        try{
            Point2D p0 = Space2Pixel.get(calculateIdx(spacePoint)).get(0);
            Point2D p1 = Space2Pixel.get(calculateIdx(spacePoint)).get(1);
            return new Point2D(p0.getX(), p1.getY());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void SpaceDraw(Graphics g){
        for(Creature e: space){
            if (e != null){
                ((PicImage)e.getImage()).setG(g);
                Point2D leftDown = TranslatePosition(e.getPosition());
                Point2D leftRight = new Point2D(leftDown.getX(), leftDown.getY()-e.getImage().getHeight());
                e.getImage().draw(leftRight);

                //画血条
                g.setColor(new Color(216, 51, 12));
                g.fillRect(leftRight.getX(), leftRight.getY()-10, (int)Math.round(rowPixel*((double)e.getBlood()/(double)e.getOriginBlood())), 5);
                g.setColor(new Color(255, 252, 25));
                g.drawRect(leftRight.getX(), leftRight.getY()-10, rowPixel, 5);

                //画蓝条
                g.setColor(new Color(9, 113, 178));
                g.fillRect(leftRight.getX(), leftRight.getY()-5, (int)Math.round(rowPixel*((double)e.getMagic()/(double)e.getOriginMagic())), 5);
                g.setColor(new Color(255, 252, 25));
                g.drawRect(leftRight.getX(), leftRight.getY()-5, rowPixel, 5);
            }
        }
    }

    public void clear(){
//        space = new Creature[scope.getX()*scope.getY()];
        Arrays.fill(space, fill);
        logger.info("Clear space");
    }

    public <T extends Creature> void addCreatures(Collection<T> creatureList){
        creatureArrayList.addAll(creatureList);
        logger.info("Screen add creatures: " + creatureList.toString());
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (Main.start) {
                return;
            }
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {
                Main.start = true;
            }
        }
    }



    public void buildWorld(Graphics g){
        g.drawImage(background, 0, 0, null);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        buildWorld(g);
        try{
            layout2Space();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        SpaceDraw(g);
        stateMsgApply();
    }

    public void run(){
        while(true){
            try{
                Thread.sleep(100);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            repaint();
        }
    }


}
