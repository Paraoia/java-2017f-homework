//葫芦娃的爷爷：能够命令葫芦娃做事，比如打乱葫芦娃的顺序和让葫芦娃重新排序

import java.util.Random;

public class Space implements Constants {

    private Position[][] positions = new Position[MAXSPACE][MAXSPACE];
    private Creature[][] creatures = new Creature[5][];

    public void posInit() {
        for (int i = 0; i < MAXSPACE; i++)
            for (int j = 0; j < MAXSPACE; j++)
                positions[i][j] = new Position(i, j);
    }

    public Position[][] getPositions() {
        return positions;
    }

    public Creature[][] getCreatures() {
        return creatures;
    }

    public void setCreatures(Creature newCre[][]) {
        creatures = newCre;
    }

    public Space(Boy[] brothers, Goblins[] monsters) {
        this.creatures[0] = new Grandpa[1];
        this.creatures[0][0] = new Grandpa();

        this.creatures[1] = brothers;

        this.creatures[2] = new Snake[1];
        this.creatures[2][0] = new Snake();

        this.creatures[3] = new Scorpion[1];
        this.creatures[3][0] = new Scorpion();

        this.creatures[4] = monsters;
    }

    //用于查看当前战场排列与所有生物当前位置
    public void show() {

        for (int m = 0; m < MAXSPACE; m++) {
            for (int n = 0; n < MAXSPACE; n++) {
                if (positions[m][n].isOccupy()) {
                    Position temp = positions[m][n];
                    if (temp.getHolder() instanceof Boy)
                        System.out.print(((Boy) temp.getHolder()).getRank() + " ");
                    else if (temp.getHolder() instanceof Goblins)
                        System.out.print(((Goblins) temp.getHolder()).getNo() + " ");
                    else if (temp.getHolder() instanceof Scorpion)
                        System.out.print("蝎 ");
                    else if (temp.getHolder() instanceof Snake)
                        System.out.print("蛇 ");
                    else if (temp.getHolder() instanceof Grandpa)
                        System.out.print("爷 ");
                    else
                        System.out.print("? ");
                } else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
        System.out.print("报位置：\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < creatures[i].length; j++) {
                creatures[i][j].report();
            }
        }
    }

    //随机打乱葫芦娃序列
    public void disturb() {        //打乱
        boolean alhave[] = new boolean[7];
        for (int i = 0; i < 7; i++) {
            alhave[i] = false;
        }
        int count = 0;
        while (count <= 6) {
            Random r = new Random();
            int s = r.nextInt(7);
            if (!alhave[s]) {
                alhave[s] = true;
                creatures[1][count] = new Boy(RANK.values()[s], COLOR.values()[s]);
                count++;
            }
        }
    }

    public static void main(String args[]) {

        Boy bro[] = new Boy[7];
        for (int i = 0; i < bro.length; i++) {
            bro[i] = new Boy(RANK.values()[i], COLOR.values()[i]);
        }
        Goblins gob[] = new Goblins[20];
        for (int i = 0; i < gob.length; i++) {
            gob[i] = new Goblins(i);
        }

        Space a = new Space(bro, gob);
        a.posInit();
        //将葫芦娃乱序
        a.disturb();
        //new BubbleSorter().sort(a);
        //将葫芦娃排序
        new BinarySorter().sort(a);

        new SnakeFormatter().format(a);
        new WingFormatter().format(a);
        new CheerUp().cheer(a);
        a.show();

        new LineFormatter().format(a);
        new CheerUp().cheer(a);
        a.show();

        new BalanceFormatter().format(a);
        new CheerUp().cheer(a);
        a.show();

        new ScaleFormatter().format(a);
        new CheerUp().cheer(a);
        a.show();

        new SquareFormatter().format(a);
        new CheerUp().cheer(a);
        a.show();

        new MoonFormatter().format(a);
        new CheerUp().cheer(a);
        a.show();

        new ArrowFormatter().format(a);
        new CheerUp().cheer(a);
        a.show();

    }
}
