/**
 * Created by admin on 2017/10/17.
 */
public class Situation {
    public static final int N = 13;
    private Formation huluwa;
    private Formation scorpion;
    private int[][] position;
    private Snake snake;
    private Grandpa grandpa;

    Situation(Formation huluwa,Formation scorpion,Snake snake,Grandpa grandpa) {
        this.huluwa = huluwa;
        this.scorpion = scorpion;
        this.snake = snake;
        this.grandpa = grandpa;
        position = new int[N][N];
        int[][] huluwaPosition = huluwa.getPosition();
        int[][] scorpionPosition = scorpion.getPosition();
        for(int i=0;i < N;i++)
            for(int j=0;j < N;j++)
                position[i][j] = huluwaPosition[i][j] + scorpionPosition[i][j];
        position[6][N-1] = 13;
        position[6][0] = 9;
    }

    public void changeSituation(Formation scorpion) {
        for(int i=0;i < N;i++)
            for(int j=0;j < N;j++)
                if(position[i][j] == 1)
                    position[i][j]--;
        int[][] scorpionPosition = scorpion.getPosition();
        for(int i=0;i < N;i++)
            for(int j=0;j < N;j++)
                position[i][j] += scorpionPosition[i][j];
    }

    public void printSituation() {
        for(int i=0;i < N;i++) {
            for(int j=0;j < N;j++)
                if(position[i][j] == 1)
                    System.out.print('x');
                else if(position[i][j] == 2)
                    System.out.print('h');
                else if(position[i][j] == 9)
                    System.out.print('g');
                else if(position[i][j] == 13)
                    System.out.print('s');
                else
                    System.out.print(' ');
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }
        Scorpion[] scorpions = new Scorpion[20];
        Snake snake = new Snake();
        Grandpa grandpa = new Grandpa();

        Formation huluwaFormation = new Formation(formation_.长蛇,brothers);
        Formation scorpionFormation = new Formation(formation_.鹤翼,scorpions);
        Situation situation = new Situation(huluwaFormation,scorpionFormation,snake,grandpa);
        System.out.println("x为蝎子,h为葫芦娃,s为蛇精,g为爷爷,以下为各个对峙局面:");
        situation.printSituation();

        scorpionFormation = new Formation(formation_.雁行,scorpions);
        situation.changeSituation(scorpionFormation);
        situation.printSituation();

        scorpionFormation = new Formation(formation_.衡轭,scorpions);
        situation.changeSituation(scorpionFormation);
        situation.printSituation();

        scorpionFormation = new Formation(formation_.鱼鳞,scorpions);
        situation.changeSituation(scorpionFormation);
        situation.printSituation();

        scorpionFormation = new Formation(formation_.方圆,scorpions);
        situation.changeSituation(scorpionFormation);
        situation.printSituation();

        scorpionFormation = new Formation(formation_.偃月,scorpions);
        situation.changeSituation(scorpionFormation);
        situation.printSituation();

        scorpionFormation = new Formation(formation_.锋矢,scorpions);
        situation.changeSituation(scorpionFormation);
        situation.printSituation();

    }
}
