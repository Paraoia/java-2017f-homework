package nju.cs.Creatures;

import nju.cs.Screen.Point2D;
import nju.cs.Screen.Screen;
import nju.cs.State.State;
import nju.cs.State.StateType;
import nju.cs.State.Stateinfo;
import nju.cs.lib.Hlib;
import nju.cs.myEnum.DirectionMap;
import nju.cs.myEnum.ECreatureType;
import nju.cs.myEnum.EDIRECTION;
import nju.cs.myImage.myImage;

import java.util.ArrayList;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-08
 */
public class Grandpa extends Creature {

    EDIRECTION moveDirection = EDIRECTION.西;
    Creature nearestCreature;
    Creature nearestEnemy;

    public Grandpa(Integer blood, Integer magic, Integer priority, myImage image, Screen screen, Integer id) {
        super(blood, magic, priority, image, screen, ECreatureType.爷爷, id);
    }

    public void setMoveDirection(EDIRECTION moveDirection) {
        this.moveDirection = moveDirection;
    }

    public EDIRECTION getMoveDirection() {
        return moveDirection;
    }

    @Override
    public String getCreatureName(){
        return "爷爷";
    }

    @Override
    public boolean isEnemy(Creature creature){
        return creature.geteCreatureType() != ECreatureType.葫芦娃 && creature.geteCreatureType() != ECreatureType.爷爷;
    }


    @Override
    public void observe(Screen screen){
        ArrayList<Creature> creatureArrayList = screen.getCreatureArrayList();
        nearestCreature = Hlib.nearestCreature(this, creatureArrayList);
        nearestEnemy = Hlib.nearestEnemy(this, creatureArrayList);
        EDIRECTION d[] = new EDIRECTION[]{
                EDIRECTION.西, EDIRECTION.西北, EDIRECTION.西南, EDIRECTION.北, EDIRECTION.南,
                EDIRECTION.东, EDIRECTION.东北, EDIRECTION.东南
        };
        for(Integer i = 0; i < 10; ++i){
            Integer idx = random.nextInt(d.length);
            if(Hlib.canMoveTo(d[idx], this, creatureArrayList)){
                moveDirection = d[idx];
                return;
            }
        }
    }

    @Override
    public void action(){
        move();
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
    }
}
