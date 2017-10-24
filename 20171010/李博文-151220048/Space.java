
public class Space {

    static final int N = 20;
    private Position[][] positions;
//    private Creature[] creatures;
    private HuluQueue huluQueue;
    public Position[][] getPositions() {
        return positions;
    }

    public void setHolder(Position position) {
        positions[position.getX()][position.getY()].setHolder(position.getHolder());
    }

    public Space(){
        //位置初始化
        positions = new Position[N][N];
        for(int i = 0; i < N; i++)
            positions[i] = new Position[N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                positions[i][j] = new Position(i,j);
        }
        //所有Creature准备进入space
      //  this.creatures = creatures;

    }
    //排好队形的creatures以相应的偏移量(即找好位置)，进入space
    public void getIntoSpace(Creature[] creatures, int x, int y){
        for(Creature creature: creatures){
            Position position = creature.getPosition();
            Position position1 = new Position(position.getX()+x, position.getY()+y);
            creature.setPosition(position1);
            setHolder(position1);
        }
    }
    public void getIntoSpace(Creature creature){
        setHolder(creature.getPosition());
    }
    public void leaveSpace(Creature[] creatures){
        for(Creature creature: creatures){
            positions[creature.getPosition().getX()][creature.getPosition().getY()].setHolder(null);
            creature.setPosition(null);
        }
    }
    public void leaveSpace(Creature creature){
        positions[creature.getPosition().getX()][creature.getPosition().getY()].setHolder(null);
        creature.setPosition(null);
    }
    public void drawSpace(){
        for(int i = 0; i < N; i++)
            System.out.print("--");
        System.out.println("");
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++){
                if(positions[i][j].getHolder() != null){
                    positions[i][j].getHolder().report();
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        for(int i = 0; i < N; i++)
            System.out.print("--");
        System.out.println("");
    }
    public static void main(String[] args) {
        //七个葫芦娃，老爷爷，蛇精，蝎子精，小喽啰 诞生
        HuluBaby[] huluBabies = new HuluBaby[7];
        for(int i = 0; i < 7; i++){
            huluBabies[i] = new HuluBaby(COLOR.values()[i], SENIORITY.values()[i]);
        }
        GrandFather grandFather = new GrandFather();
        Snake snake = new Snake();
        Scorpion scorpion = new Scorpion();
        Minion[] minions = new Minion[10];
        for(int i = 0; i < 10; i++){
            minions[i] = new Minion();
        }

        //七个葫芦娃自己排起了队形
        HuluQueue huluQueue = new HuluQueue(huluBabies);
        //蝎子精领小喽啰排队形
        EnemyFormation enemyFormation = new EnemyFormation(scorpion, minions);
        enemyFormation.formate(Formation.鹤立);
        //双方进入二维空间对峙
        Space space = new Space();
        space.getIntoSpace(huluQueue.getCreature(),N - 7, N / 2);
        space.getIntoSpace(enemyFormation.getCreature(), 0, N/2 - 5);
        //老爷爷和蛇精分别加入
        grandFather.setPosition(space.positions[N-7][N/2-5]);
        space.getIntoSpace(grandFather);
        snake.setPosition(space.positions[5][5]);
        space.getIntoSpace(snake);
        //打印局面
        space.drawSpace();

        //蝎子小喽啰变换阵型
        space.leaveSpace(minions);
        space.leaveSpace(scorpion);
        enemyFormation.formate(Formation.锋矢);
        //再次进入二维空间
        space.getIntoSpace(enemyFormation.getCreature(), 0, N/2 - 3);
        //再次打印局面
        space.drawSpace();

    }
}
