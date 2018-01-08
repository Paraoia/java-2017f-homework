package nju.cs.Creatures;

import nju.cs.State.State;
import nju.cs.State.StateType;
import nju.cs.State.Stateinfo;
import nju.cs.myEnum.*;
import nju.cs.myImage.myImage;
import nju.cs.Screen.Point2D;
import nju.cs.Screen.Screen;
import nju.cs.lib.Hlib;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-07
 */
public class Huluwa extends Creature{

    ECOLOR ecolor;
    EDIRECTION moveDirection = EDIRECTION.东;
    ESENIORITY eseniority;

    Creature nearestCreature;
    Creature nearestEnemy;
    Creature grandpa;


    public Huluwa(Integer blood, Integer magic, Integer priority, myImage image, Screen screen, Integer id, ECOLOR ecolor, ESENIORITY eseniority) {
        super(blood, magic, priority, image, screen, ECreatureType.葫芦娃, id);
        this.ecolor = ecolor;
        this.eseniority = eseniority;
    }

    public ECOLOR getEcolor() {
        return ecolor;
    }

    public EDIRECTION getEdirection() {
        return moveDirection;
    }

    public ESENIORITY getEseniority() {
        return eseniority;
    }

    public void setEcolor(ECOLOR ecolor) {
        this.ecolor = ecolor;
    }


    public void setEdirection(EDIRECTION edirection) {
        this.moveDirection = edirection;
    }

    public void setEseniority(ESENIORITY eseniority) {
        this.eseniority = eseniority;
    }

    @Override
    public boolean isEnemy(Creature creature){
        return creature.geteCreatureType() != ECreatureType.葫芦娃 && creature.geteCreatureType() != ECreatureType.爷爷;
    }

    @Override
    public String getCreatureName(){
        return "葫芦娃" + eseniority.toString() + "娃(" + ecolor.toString() + ")";
    }

    @Override
    public void observe(Screen screen){
        ArrayList<Creature> creatureArrayList = screen.getCreatureArrayList();
        nearestCreature = Hlib.nearestCreature(this, creatureArrayList);
        nearestEnemy = Hlib.nearestEnemy(this, creatureArrayList);
        List<Creature> lgrandpa = Hlib.findTypeFromList(creatureArrayList, ECreatureType.爷爷);
        grandpa = lgrandpa.size() == 1 ? lgrandpa.get(0) : null;

    }

    @Override
    public void action(){
        if (grandpa != null && grandpa.getBlood() < 100 && heal(grandpa)){
            ;
        }
        else{
            if (Hlib.distanceBetween(this.getPosition(), nearestEnemy.getPosition()) > 1){
                moveDirection = Hlib.toDirection(this, nearestEnemy);
                move();
            }
            else{
                attack();
            }

        }

        try{
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void move(){
        Point2D direction = DirectionMap.EDirection2Point2D(this.moveDirection);
        if (    position.getX() + direction.getX() < screen.getScope().getX() &&
                position.getY() + direction.getY() < screen.getScope().getY() &&
                position.getX() + direction.getX() >= 0 &&
                position.getY() + direction.getY() >= 0 ) {
            Stateinfo sInfo = new Stateinfo();
            sInfo.setMoveStep(direction);
            State s = new State(StateType.移动, sInfo, this);
            screen.pushStateMsg(s);
        }
    }


    @Override
    public void attack(){
        if (Hlib.distanceBetween(this.position, nearestEnemy.getPosition()) >= 2)
            return;
        Stateinfo sinfo = new Stateinfo();
        sinfo.setBlood(random.nextInt(100)+80);
        State s = new State(StateType.减血, sinfo, nearestEnemy);
        screen.pushStateMsg(s);
    }

    @Override
    public boolean isAlive(){
        return this.Blood > 0;
    }

    @Override
    public void die(){
        synchronized (creatureNum){
            creatureNum--;
        }
        logger.info(getCreatureName() + ": died.");
        State s = new State(StateType.死亡, null, this);
        screen.pushStateMsg(s);
    }

    private boolean heal(Creature creature){
        final Integer useMagic = 25;
        if (this.Magic < 25)
            return false;
        Stateinfo sinfo = new Stateinfo();
        sinfo.setBlood(random.nextInt(100)+100);
        State s = new State(StateType.加血, sinfo, creature);
        screen.pushStateMsg(s);
        sinfo = new Stateinfo();
        sinfo.setMagic(25);
        s = new State(StateType.减蓝, sinfo, this);
        screen.pushStateMsg(s);
        return true;
    }
}
