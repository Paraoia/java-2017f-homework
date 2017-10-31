import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Field {
    final int N=15;

    private Position[][] positions;
    private Creature[][] creatures;

    public Position[] getPositions(int i) {
        return positions[i];
    }

    public Position[][] getPositions(){
        return positions;
    }
    public Creature[][] getCreatures() {
        return creatures;
    }

    public Field (){
        this.positions = new Position[N][N];
        this.creatures = new Creature[N][N];
        for (int i = 0; i < N ;++i)
            for (int j = 0 ; j< N ;++j) {
                this.creatures[i][j] = new Blank();
                this.positions[i][j] = new Position(i,j);
                this.creatures[i][j].setPosition(this.positions[i][j]);
            }
    }

    public void putIn(Queue queue){
        Position []tmp1 = queue.getPositions();
        for (int i=0 ; i<tmp1.length ; ++i){
            int x= tmp1[i].getX();
            int y= tmp1[i].getY();
            this.positions[x][y].setHolder(tmp1[i].getHolder());
            this.creatures[x][y]=tmp1[i].getHolder();
            this.creatures[x][y].setPosition(tmp1[i]);
        }
    }
    public void clean(){
        for (int i=0;i<N;++i)
            for (int j=0 ;j<N ;++j){
                creatures[i][j]=new Blank();
                positions[i][j].setHolder(new Blank());
            }
    }
    public void rollCall() {
        for (int i=0;i<N;++i) {
            for (int j = 0; j < N; ++j)
                this.positions[i][j].getHolder().report();
            System.out.println();
        }
        System.out.flush();
    }

    private void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = 6; i > 0; i--) {
            int index = rnd.nextInt(i + 1)+4;   //4是 7个葫芦娃处于15个位置正中间左右相等 4-10
            Position position = creatures[0][index].getPosition();
            Creature creature = creatures[0][index];

            positions[0][index].setHolder(creatures[0][i+4]);
            positions[0][i+4].setHolder(creature);
            positions[0][index].setX(i+4);
            positions[0][i+4].setY(index);
            creatures[0][index] =  creatures[0][i+4];
            creatures[0][i+4] = creature;
        }
    }

    public static void main(String[] args) {
        //生成葫芦娃
        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i < brothers.length; i++) {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i] ,new Position(0,i));
        }
        Queue huluwaqueue = new Queue (7);   //生成葫芦娃队
        for (int i=0;i<brothers.length;++i)
            huluwaqueue.JoinIn(brothers[i]);
        new Snake().format(huluwaqueue);        //葫芦娃排成长蛇形
        Field field = new Field();
        field.putIn(huluwaqueue);   //葫芦娃放进field
        field.shuffle();        //葫芦娃乱序
        /*
        field.rollCall();
        System.out.println();
        */
        new BubbleSorter().sort(field,0);   //葫芦娃排序

        //生成喽啰
        LouLuo[] louluos = new LouLuo[6];
        for (int i = 0; i < 6; i++) {
            louluos[i] = new LouLuo(NAME.values()[i]);
        }
        Monster xiezijing = new Monster("蝎子精");
        Queue monsterqueue = new Queue(7);         //生成妖怪队
        monsterqueue.JoinIn(xiezijing);
        for (int i=0;i<louluos.length;++i)
            monsterqueue.JoinIn(louluos[i]);
        new CraneWing().format(monsterqueue);    //妖怪鹤翼形
        field.putIn(monsterqueue);

        Creature grandfather = new Grandfather("爷爷");  //0,0
        Monster  shejing = new Monster("蛇精");      //14,14
        Queue audiencequeue = new Queue(2);  //观战助威队
        audiencequeue.JoinIn(grandfather);
        audiencequeue.JoinIn(shejing);
        new Audience().format(audiencequeue);
        field.putIn(audiencequeue);

        field.rollCall();

        System.out.println();
        field.clean();    //清空  blank填满field   重新站队形 翼形
        field.putIn(huluwaqueue);
        new Goose().format(monsterqueue);
        field.putIn(monsterqueue);
        field.putIn(audiencequeue);
        field.rollCall();


    }
}

