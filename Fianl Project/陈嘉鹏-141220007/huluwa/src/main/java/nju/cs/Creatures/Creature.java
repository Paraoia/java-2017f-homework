package nju.cs.Creatures;

import nju.cs.Form.Priority;
import nju.cs.Screen.Point2D;
import nju.cs.Screen.Screen;
import nju.cs.myEnum.ECreatureType;
import nju.cs.myImage.myImage;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

/**
 * @author chenjiapeng
 * @Description
 *         Creature是所有生物的基类，存在两种属性血条，魔法条
 *
 *
 * @date 2018-01-05
 */
public abstract class Creature implements Runnable, Priority{
    Integer Blood;
    Integer originBlood;
    Integer Magic;
    Integer originMagic;

    Point2D position;
    Integer priority;
    Integer attackFrequency;
    Integer moveFrequency;
    myImage image;

    Screen screen;

    ECreatureType eCreatureType;
    Integer id;
    Random random = new Random();

    static CountDownLatch countDownLatch;
    static Integer creatureNum;
    static Logger logger = Logger.getLogger("Creature");

    public Creature(Integer blood, Integer magic, Integer priority, myImage image, Screen screen, ECreatureType eCreatureType, Integer id) {
        Blood = blood;
        originBlood = blood;
        Magic = magic;
        originMagic = magic;
        this.priority = priority;
        this.image = image;
        this.screen = screen;
        this.eCreatureType = eCreatureType;
        this.id = id;
    }

    public Integer getBlood() {
        return Blood;
    }

    public Integer getMagic() {
        return Magic;
    }

    public Integer getOriginBlood() {
        return originBlood;
    }

    public Integer getOriginMagic() {
        return originMagic;
    }

    public Point2D getPosition() {
        return position;
    }

    public Integer getPriority() {
        return priority;
    }

    public Integer getAttackFrequency() {
        return attackFrequency;
    }

    public Integer getMoveFrequency() {
        return moveFrequency;
    }

    public Screen getScreen() {
        return screen;
    }

    public myImage getImage() {
        return image;
    }

    public static Integer getCreatureNum() {
        return creatureNum;
    }

    public static CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public ECreatureType geteCreatureType() {
        return eCreatureType;
    }

    public void setBlood(Integer blood) {
        Blood = blood;
    }

    public void setMagic(Integer magic) {
        Magic = magic;
    }

    public void setPosition(Point2D Position) {
        this.position = Position;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setAttackFrequency(Integer attackFrequency) {
        this.attackFrequency = attackFrequency;
    }

    public void setMoveFrequency(Integer moveFrequency) {
        this.moveFrequency = moveFrequency;
    }

    public static void setCreatureNum(Integer creatureNum) {
        Creature.creatureNum = creatureNum;
    }

    public void setImage(myImage image) {
        this.image = image;
    }

    public static void setCountDownLatch(CountDownLatch countDownLatch) {
        Creature.countDownLatch = countDownLatch;
    }

    public void seteCreatureType(ECreatureType eCreatureType) {
        this.eCreatureType = eCreatureType;
    }

    public boolean comparePriority(Priority priority){
        return this.getPriority() < priority.getPriority();

    }

    public final void run(){
        perform(screen);
    }


    /**
     * @Description
     *      每个Creature均按照固定的动作来（如果是自动run的话，手动控制在设计中不该走这个路径）
     *      至于动作细节，由具体的生物决定，即模板方法模式
     */
    private final void perform(Screen screen){
        while(true){
            if (isAlive()){
                observe(screen);
                action();
                logger.info(getCreatureName() + " : Action over.");
            }
            else {
                die();
//                Synchronization();
                break;
            }
            Synchronization();
        }

    }

    private void Synchronization() {
        try {
            synchronized (countDownLatch) {
                countDownLatch.countDown();
                logger.info(getCreatureName() + " : countDownLatch " + countDownLatch.getCount() + "/" + creatureNum);
                if (countDownLatch.getCount() == 0) {
                    logger.info(getCreatureName() + " countDownLatch 0 ");
                    logger.info(getCreatureName() + " into synchronized ");
                    countDownLatch = new CountDownLatch(creatureNum);
                    synchronized (screen.getMsgCanApply()){
                        logger.info(getCreatureName() + " : notify screen");
                        screen.getMsgCanApply().notify();
                    }
                }

            }
            synchronized (screen.getScreenlock()) {
                logger.info(getCreatureName() + " : wait screen");
//                screen.getScreenlock().wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveTo(Point2D position){
        this.position = position;
    }

    public abstract String getCreatureName();
    public abstract boolean isEnemy(Creature creature);

    /**
     * @Description
     *      Observe应该观察所有的Creature，之后判断应该attack哪个生物，以及该move的方向，
     *      因此需要一个screen来获得目前生物的位置。同时在这个
     */
    public abstract void observe(Screen screen);


    /**
     * @Description
     *      move的快慢由moveFrequency进行决定，到一定时间则移动，移动方向由observe决定
     */
    public abstract void move();

    /**
     * @Description
     *      attack的快慢由attackFrequency进行决定，到一定时间则攻击，如何攻击由observe决定
     */
    public abstract void attack();

    /**
     * @Description
     *      每一个时钟进行一次action，具体做啥，move还是attack由具体Creature决定
     */
    public abstract void action();

    /**
     * @Description
     *      isAlive由血量判断是否还活着
     */
    public abstract boolean isAlive();

    /**
     * @Description
     *      die之后应该有标记，处理完该处理的任务后退出线程
     */
    public abstract void die();
}
