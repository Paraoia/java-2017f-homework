package game;

import creature.*;
import actions.*;

import java.util.Scanner;

/**
 * Created by cbcwe on 2017/10/19.
 */
public final class Game {
    public static void main(String[] args) {

        /* Part 1 */
        System.out.println("输入N来创建一个N*N的地图( 7 < N < 20 )：");      // create the world
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if( N < 8 ) {
            N = 8;
            System.out.println("N修正为"+N);
        }
        else if( N > 20){
            N = 20;
            System.out.println("N修正为"+N);
        }
        Map map = new Map(N);

        GourdDolls gourdDolls = GourdDolls.getGourdDolls();   // create the creature
        Grandpa grandpa = Grandpa.getGrandpa();
        Snake snake = Snake.getSnake();
        Creature[] enemy = new Creature[5];                   // create 5 accomplice , Scorpion sits in middle
        for (int i = 0; i < 5; ++i) {                       // Don't use for( Accomplice a : accomplice )
            if (i == 2)
                enemy[i] = Scorpion.getSorpion();
            else
                enemy[i] = new Accomplice();
        }

        ChangShe changShe = new ChangShe();                   // create actions
        HeYi heYi = new HeYi();
        YanXing yanXing = new YanXing();
        Move move = new Move();


        /* Part 2 */
        gourdDolls.getARandomSeq();
        gourdDolls.printGourdDolls("乱序的葫芦娃:");
        gourdDolls.sort();
        gourdDolls.printGourdDolls("排完序的葫芦娃:");
        changShe.doAction(map, map.LENGTH / 2 - GourdDolls.NUM / 2, 0, gourdDolls);
        //map.printMap("test：葫芦娃长蛇完成");


        /* 3 */
        heYi.doAction(map, 0, 3, enemy);
        //map.printMap("test：蝎子精+马仔鹤翼完成");


        /* 5 */
        move.doAction(map,0,0,grandpa);
        move.doAction(map,0,5,snake);
        //map.printMap("test：爷爷蛇精加入战局");


        /* 6 */
        map.printMap("对峙1：长蛇 vs 鹤翼");


        /* 7 */
        yanXing.doAction(map, map.LENGTH / 2 - enemy.length / 2, map.LENGTH / 2 - enemy.length / 2, enemy);
        move.doAction(map,map.LENGTH / 2, 1,grandpa);
        move.doAction(map,map.LENGTH / 2, map.LENGTH / 2 - 1,snake);
        map.printMap("对峙2：长蛇 vs 雁行");
    }

}
