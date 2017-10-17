/**
 * Created by tangruize on 10/16/17.
 */
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        
        // 鹤翼
        System.out.println("\n----------鹤翼----------");
        battle.randCalabashArray();
        battle.craneWingArray();
        battle.print();

        // 雁行
        System.out.println("\n----------雁行----------");
        battle.randCalabashArray();
        battle.gooseFlyArray();
        battle.print();

        // 衡轭
        System.out.println("\n----------衡轭----------");
        battle.randCalabashArray();
        battle.balanceYokeArray();
        battle.print();

        // 长蛇
        System.out.println("\n----------长蛇----------");
        battle.randCalabashArray();
        battle.longSnakeArray();
        battle.print();

        // 鱼鳞
        System.out.println("\n----------鱼鳞----------");
        battle.randCalabashArray();
        battle.fishScaleArray();
        battle.print();

        // 方円
        System.out.println("\n----------方円----------");
        battle.randCalabashArray();
        battle.squareRoundArray();
        battle.print();

        // 偃月
        System.out.println("\n----------偃月----------");
        battle.randCalabashArray();
        battle.layDownHalfMoonArray();
        battle.print();

        // 锋矢
        System.out.println("\n----------锋矢----------");
        battle.randCalabashArray();
        battle.sharpArrayArray();
        battle.print();
    }
}
