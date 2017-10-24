package Xzr.demo;

import Xzr.Creature.CalabashDoll;
import Xzr.Creature.Demon;
import Xzr.Position.PositionXY;
import Xzr.Sort.Formation;
import Xzr.Sort.RandomFormationSorter;

/** 葫芦娃程序 */
public class HuluwaProject {
    static final int filedSize = 50;
    static final int demonNum = 20;

    public static void main(String args[]){

        // 葫芦娃出生
        CalabashDoll[] calabashDolls= new CalabashDoll[CalabashDoll.allNum];
        for(int i=0;i<CalabashDoll.allNum;i++) {
            calabashDolls[i] = new CalabashDoll();
        }

        // 妖精出生
        Demon[] demons = new Demon[demonNum];
        demons[0] = new Demon("蝎子精");
        for(int i=1; i<demonNum; i++){
            demons[i] = new Demon("喽啰");
        }

        // 设置战场
        Queue myCirrus = new Queue(filedSize, filedSize);

        myCirrus.showField();

        // 葫芦娃进入战场
        myCirrus.enterField(calabashDolls);
        myCirrus.showField();

        // 葫芦娃随机排列
        new RandomFormationSorter().formation(calabashDolls, myCirrus,null);
        // 葫芦娃长蛇阵
        new Formation().embattle("长蛇",calabashDolls,myCirrus);

        // 妖怪进入战场
        myCirrus.enterField(demons);
        // 妖怪锋矢阵
        new Formation().embattle("锋矢",demons,myCirrus);
        myCirrus.showField();

        myCirrus.clearField();
    }
}
