import java.util.ArrayList;
import java.util.Random;

public class Space implements Constants {

    private Position[][] positions = new Position[MAXSPACE][HALFSPACE];
    ArrayList<ArrayList<Creature>> creatures = new ArrayList<>();


    public void posInit() {
        for (int i = 0; i < MAXSPACE; i++)
            for (int j = 0; j < HALFSPACE; j++)
                positions[i][j] = new Position(i, j);
    }

    public Position[][] getPositions() {
        return positions;
    }

    public ArrayList<ArrayList<Creature>> getCreatures() {
        return creatures;
    }

    public Space(ArrayList<Creature> brothers, ArrayList<Creature> goblins) {
        ArrayList<Creature> grandpa = new ArrayList<>();
        grandpa.add(new Grandpa());
        this.creatures.add(grandpa);

        this.creatures.add(brothers);

        ArrayList<Creature> snake = new ArrayList<>();
        snake.add(new Snake());
        this.creatures.add(snake);

        ArrayList<Creature> scorpion = new ArrayList<>();
        scorpion.add(new Scorpion());
        this.creatures.add(scorpion);

        this.creatures.add(goblins);
    }

    //用于查看当前战场排列与所有生物当前位置
    public void show() {

        for (int m = 0; m < MAXSPACE; m++) {
            for (int n = 0; n < HALFSPACE; n++) {
                if (positions[m][n].isOccupy()) {
                    Position temp = positions[m][n];
                    if (temp.getHolder() instanceof Boy)
                        System.out.print("\uD83D\uDC66");
                    else if (temp.getHolder() instanceof Goblins)
                        System.out.print("\uD83E\uDD8D");
                    else if (temp.getHolder() instanceof Scorpion)
                        System.out.print("\uD83E\uDD82");
                    else if (temp.getHolder() instanceof Snake)
                        System.out.print("\uD83D\uDC0D");
                    else if (temp.getHolder() instanceof Grandpa)
                        System.out.print("\uD83D\uDC74");
                    else
                        System.out.print("?");
                } else
                    System.out.print("\uD83C\uDF3F");
            }
            System.out.print("\n");
        }
        System.out.print("报位置：\n");
        for (int i = 0; i < creatures.size(); i++) {
            for (int j = 0; j < creatures.get(i).size(); j++) {
                creatures.get(i).get(j).report();
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
                creatures.get(1).set(count, new Boy(RANK.values()[s], COLOR.values()[s]));
                count++;
            }
        }
    }

    public static void main(String args[]) {
        ArrayList<Creature> bro = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            bro.add(new Boy(RANK.values()[i], COLOR.values()[i]));
        }
        ArrayList<Creature> gob = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            gob.add(new Goblins(i));
        }

        Space a = new Space(bro, gob);
        a.posInit();
        //将葫芦娃乱序
        a.disturb();
        //new BubbleSorter().sort(a);
        //将葫芦娃排序
        new BinarySorter().sort(a);

        new SnakeFormatter().format(a);
        /*
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
        */
        new ArrowFormatter().format(a);
        new CheerUp().cheer(a);
        a.show();

        new March().march(a,gob.get(1),ORIENTATION.NORTH);
        a.show();
    }
}
