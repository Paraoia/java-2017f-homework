import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue {
    final static int size = 15;
    final static int GoodGuyColStart = 4;
    final static int GoodGuyRowStart = 0;
    final static int BadGuyColStart = 4;
    final static int BadGuyRowStart = 6;
    final static int GrandpaX = 3;
    final static int GrandpaY = 2;
    final static int SnackX = 3;
    final static int SnackY = 12;
    private Position[][] positions;
    private Creature[][] creatures;

    public Position[] getPositions(int i) {
        return positions[i];
    }

    public Creature[][] getCreatures() {
        return creatures;
    }

    public void Add(int x, int y, Creature creature){
        this.creatures[x][y] = creature;
        this.creatures[x][y].setPosition(this.positions[x][y]);
    }

    public Queue() {    //创建出二维空间放置生物
        this.positions = new Position[size][size];
        this.creatures = new Creature[size][size];
        for(int i = 0; i < size; ++i)
            for(int j = 0; j < size; ++j){
                this.creatures[i][j] = new Vacancy();
                this.positions[i][j] = new Position(i, j);
                this.creatures[i][j].setPosition(this.positions[i][j]);
        }
    }

    public void rollCall() { //二维空间报数
        for (int i = 0; i < size; ++i) {
            for(int j = 0; j < size; ++j)
                this.positions[i][j].getHolder().report();
            System.out.println();
        }
        System.out.println();
        System.out.flush();
    }

    private void shuffle(int row, int startPosition, int len) { //重置某一排的某几个位置
        Random rnd = ThreadLocalRandom.current();
        for (int i = len - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1) + startPosition;
            Position position = creatures[0][index].getPosition();
            creatures[row][index].setPosition(creatures[row][i+startPosition].getPosition());
            creatures[row][i+startPosition].setPosition(position);
        }
    }

    private void yell(int positionX, int positionY, Creature creature, boolean cancel){
        if(cancel)
            this.Add(positionX,positionY,new Vacancy());
        else
            this.Add(positionX,positionY,creature);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        //葫芦娃排队
        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }

        Changshezhen changshezhen = new Changshezhen();//长蛇阵
        changshezhen.generate(GoodGuyRowStart, GoodGuyColStart, brothers, queue); //生成
        queue.shuffle(GoodGuyRowStart, GoodGuyColStart, brothers.length); //随机
        new BubbleSorter().sort(queue, GoodGuyRowStart, GoodGuyColStart, brothers.length); //排序

        //坏蛋排队
        Monster []badguys = new Monster[7];
        Xiezijing laoda = new Xiezijing();
        badguys[0] = laoda;//蝎子精加入
        Xiaolouluo []xiaodi = new Xiaolouluo[6];
        for(int i = 0; i < xiaodi.length; ++i){
            xiaodi[i] = new Xiaolouluo();
            badguys[i+1] = xiaodi[i];
        } //小喽啰加入

        Yanxingzhen yanxingzhen = new Yanxingzhen();//雁行阵
        yanxingzhen.generate(BadGuyRowStart,BadGuyColStart,badguys, queue); //生成

        //爷爷蛇精助威
        Grandpa grandpa = new Grandpa();
        Snake snake = new Snake();
        queue.yell(GrandpaX,GrandpaY,grandpa, false);
        queue.yell(SnackX,SnackY,snake, false);

        //输出对峙局面
        queue.rollCall();

        //取消雁行阵 转成鹤翼阵
        yanxingzhen.cancel(BadGuyRowStart, BadGuyColStart, badguys,queue); //取消
        Heyizhen heyizhen = new Heyizhen(); //鹤翼阵
        heyizhen.generate(BadGuyRowStart, BadGuyColStart, badguys,queue); //生成

        //输出对峙局面
        queue.rollCall();
    }
}