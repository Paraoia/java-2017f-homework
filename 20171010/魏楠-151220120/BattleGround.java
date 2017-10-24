import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BattleGround {
    private Position maps[][];      //a map that is created for fighting
    //When BattleGround created, the map will be initialized
    private int N = 20;      //size of battleground
    private Calabash[] brothers;        //HuLu brothers
    BattleGround(int N) {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                maps[i][j] = new Position(i, j, null);
    }

    public int getN() {
        return N;
    }
    public Position[][] getMaps() {
        return maps;
    }

    BattleGround(int N, Snake snake,Grandpa grandpa, Queue monsters, Queue brothers) {
        maps = new Position[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                maps[i][j] = new Position(i, j, null);
        putCreature(snake, findEmptyPosition());
        putCreature(grandpa, findEmptyPosition());
    }

    //Find empty position
    private Position findEmptyPosition() {
        Random random = ThreadLocalRandom.current();
        Position temp;
        do {
            int i = random.nextInt(N);
            int j = random.nextInt(N);
            temp = maps[i][j];
        }while (temp.isEmpty() == false);
        return temp;
    }

    //To check whether the (a,b) -> (x,y) rectangular is empty
    //Note that a <= x && b <= y
    private boolean checkAreaEmpty(int a, int b, int x, int y) {
        for(int i = a; i <= x; i++)
            for(int j = b; j<=y; j++)
                if(!maps[i][j].isEmpty())
                    return false;
        return true;
    }

    private void ChangShe(Queue queue) {
        Creature[] creatures = queue.getCreatures();
        Random random = new Random();
        int i;
        int j;
        do {
            i = random.nextInt(N - creatures.length);
            j = random.nextInt(N);
        }while (checkAreaEmpty(i, j, i + creatures.length - 1, j));
        for(int s = 0; s < creatures.length; s++)
            putCreature(creatures[s], maps[s + i][j]);
    }

    //creatures.length % 2 == 1
    private void HeYi(Queue queue) {
        Creature[] creatures = queue.getCreatures();
        Random random = new Random();
        int i;
        int j;
        do {
            i = random.nextInt(N - creatures.length / 2);
            j = random.nextInt(N - creatures.length);
        }while (checkAreaEmpty(i, j, i + creatures.length / 2, j + creatures.length - 1));
        for(int s = 0; s < creatures.length/2; s++)
            putCreature(creatures[s], maps[s + i][j + s]);
        for(int s = creatures.length/2; s < creatures.length; s++)
            putCreature(creatures[s], maps[i + creatures.length - s - 1][j + s]);
    }

    private void YanXing(Queue queue) {
        Creature[] creatures = queue.getCreatures();
        Random random = new Random();
        int i;
        int j;
        do {
            i = random.nextInt(N - creatures.length);
            j = random.nextInt(N);
        }while (checkAreaEmpty(i, j, i + creatures.length - 1, j));
        for(int s = 0; s < creatures.length; s++)
            putCreature(creatures[s], maps[i + creatures.length - 1 -s][j + s]);
    }

    private void ChongE(Queue queue) {
        Creature[] creatures = queue.getCreatures();
        Random random = new Random();
        int i;
        int j;
        do {
            i = random.nextInt(N - creatures.length);
            j = random.nextInt(N -1);
        }while (checkAreaEmpty(i, j, i + creatures.length - 1, j + 1));
        for(int s = 0; s < creatures.length; s++)
            putCreature(creatures[s], maps[i + s][j + (s % 2)]);
    }

    private void putCreature(Creature creature, Position position) {
        position.setCreature(creature);
        creature.setPosition(position);
    }

    public static void main(String args[]) {
        Snake snake = new Snake();
        Grandpa grandpa = new Grandpa();
        Creature[] minions = new Creature[7];
        minions[0] = new Scorpion();
        for(int i = 1; i < minions.length; i++)
            minions[i] = new Minion();
        Calabash[] calabashes = new Calabash[7];
        for(int i = 0; i < calabashes.length; i ++)
            calabashes[i] = new Calabash(COLOR.values()[i], SENIORITY.values()[i]);
        Queue monsters = new Queue(minions);
        Queue brothers = new Queue(calabashes);

        BattleGround battle1 = new BattleGround(20, snake, grandpa, monsters, brothers);
        brothers.shuffle();
        new BubbleSort().sort(brothers);

        System.out.println("Round 1:");
        battle1.ChangShe(brothers);
        brothers.queuqReport();
        battle1.HeYi(monsters);
        monsters.queuqReport();
        snake.report();
        grandpa.report(battle1);

        BattleGround battle2 = new BattleGround(20, snake, grandpa, monsters, brothers);
        System.out.println("\n\n\nRound 2:");
        battle2.ChangShe(brothers);
        battle2.ChongE(monsters);
        brothers.queuqReport();
        monsters.queuqReport();
        snake.report();
        grandpa.report(battle2);
        return;
    }
}
