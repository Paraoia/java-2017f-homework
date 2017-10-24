import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int size;

    private Position[][] board;

    private Queue[] queues;

    private Zhenxing[] zhenxings;

    public Position[][] getBoard() {
        return board;
    }


    public Queue[] getQueues() { return queues; }


    public Zhenxing[] getZhenxings() { return zhenxings;}


    public int getSize() { return size; }

    /*从文件读入阵型信息，初始化阵型*/
    private void initZhenxings(String filePath){
        ArrayList stringList = new ArrayList<String>();
        File file = new File(filePath);
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = br.readLine()) != null){
                stringList.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        this.zhenxings = new Zhenxing[stringList.size()];
        for(int i = 0; i < stringList.size(); ++i)
        {
            ArrayList positionList = new ArrayList<Position>();
            String[] array = ((String)stringList.get(i)).split("\\s+");
            ZNAME zhenming = null;
            int posX, posY;
            for(int j = 0; j < array.length; ++j){
                if(j == 0) zhenming = ZNAME.getZNAME(array[j]);
                else{
                    String[] nums = array[j].replace("(", "").replace(")", "").split(",");
                    posX = Integer.valueOf(nums[0]).intValue();
                    posY = Integer.valueOf(nums[1]).intValue();
                    positionList.add(new Position(posX, posY));
                }
            }
            Position[] positions = new Position[positionList.size()];
            positions = (Position[])positionList.toArray(positions);
            this.zhenxings[i] = new Zhenxing(zhenming,positions);
        }
    }

    /*使得蛇精和老爷爷在矩阵上各个位置随机出现*/
    private void shuffle(CREATRUE creatrue) {
        Creature[] creatures = this.queues[creatrue.ordinal()].getCreatures();
        Random rnd1 = ThreadLocalRandom.current();
        Random rnd2 = ThreadLocalRandom.current();
        for (int i = creatures.length-1; i >= 0;) {
            int posX = rnd1.nextInt(size);
            int posY = rnd2.nextInt(size);
            if(board[posX][posY].isOccupied() || board[posX][posY].isBorder()) continue;
            else{
                creatures[i].setPosition(board[posX][posY]);
                --i;
            }
        }
    }

    /*棋盘构造函数*/
    public Board(int size, Huluwa[] huluwas, Yaoguai[] yaoguais, Spectator[] spectators){
        this.size = size;
        board = new Position[size][size];
        for(int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                board[i][j] = new Position(i, j);
                if (i == 0 || j == 0 || i == size - 1 || j == size - 1)
                    board[i][j].setBorder();
            }
        }

        Queue[] queues = {new CreatrueQueue(huluwas), new CreatrueQueue(yaoguais), new CreatrueQueue(spectators)};
        this.queues = queues;
    }

    /*葫芦娃摆阵*/
    public void huluwasSetZhenxing(ZNAME name){
        Position[] position = zhenxings[name.ordinal()].getPositions();
        Creature[] huluwas = queues[CREATRUE.葫芦娃.ordinal()].getCreatures();
        for(int i = 0; i < huluwas.length; ++i){
            int posX = position[i].getX(), posY = position[i].getY();
            huluwas[i].setPosition(board[posX][posY]);
        }
    }

    /*妖怪变阵*/
    public void yaoGuaiChangeTo(ZNAME name){
        Creature[] yaoguais = queues[CREATRUE.妖怪.ordinal()].getCreatures();
        Creature[] spectators = queues[CREATRUE.旁观者.ordinal()].getCreatures();
        for(Creature creature: yaoguais)
            creature.getPosition().clear();
        for(Creature creature: spectators)
            creature.getPosition().clear();

        Position[] position = zhenxings[name.ordinal()].getPositions();
        for(int i = 0; i < yaoguais.length; ++i){
            int posX = position[i].getX(), posY = position[i].getY();
            yaoguais[i].setPosition(board[posX][posY]);
        }
    }


    public void output(){
        for(int i = 0; i < size; ++i){
            for(Position position: board[i]){
                if(position.isBorder()) System.out.print("* ");
                else if(position.getHolder() == null) System.out.print("  ");
                else System.out.print(position.getHolder().toString().charAt(0));
            }
            System.out.print("\n");
            System.out.flush();
        }
    }

    /*清空棋盘*/
    public void clear(){
        for(int i = 0; i < size; ++i)
            for(int j = 0; j < size; ++j)
                board[i][j].clear();
    }


    public static void main(String[] args){
        Huluwa[] huluwas = new Huluwa[7];
        Yaoguai[] yaoguais = new Yaoguai[9];
        Spectator[] spectators = new Spectator[2];

        for (int i = 0; i < huluwas.length; i++) {
            huluwas[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }

        for (int i = 0; i < yaoguais.length; i++) {
            if(i == 0)
                yaoguais[i] = new Yaoguai(EPITHET.values()[0]);
            else
                yaoguais[i] = new Yaoguai(EPITHET.values()[1]);
        }

        for(int i = 0; i < spectators.length; ++i){
            spectators[i] = new Spectator(WATCHER.values()[i]);
        }


        int size = 17;
        String filePath = "appendix/Zhenxing.txt";
        Board board = new Board(size+1, huluwas, yaoguais, spectators);
        board.initZhenxings(filePath);

        board.getQueues()[CREATRUE.葫芦娃.ordinal()].shuffle();
        System.out.println("葫芦随机排列:");
        board.getQueues()[CREATRUE.葫芦娃.ordinal()].rollCall();

        new BubbleSorter().sort(board.getQueues()[CREATRUE.葫芦娃.ordinal()]);
        System.out.println("葫芦排序后:");
        board.getQueues()[CREATRUE.葫芦娃.ordinal()].rollCall();

        /*葫芦娃摆阵*/
        board.huluwasSetZhenxing(ZNAME.长蛇);

        for(int i = 0; i < board.getZhenxings().length; i++){
            if(ZNAME.values()[i] == ZNAME.长蛇) continue;  //去掉长蛇阵的情况

            /*妖怪变阵*/
            System.out.println("妖怪摆阵: " + ZNAME.values()[i].toString());
            board.yaoGuaiChangeTo(ZNAME.values()[i]);

            /*蛇精和爷爷随机出现在二维空间的任意位置*/
            board.shuffle(CREATRUE.旁观者);
            board.queues[CREATRUE.旁观者.ordinal()].getCreatures()[WATCHER.爷爷.ordinal()].report();
            board.queues[CREATRUE.旁观者.ordinal()].getCreatures()[WATCHER.蛇精.ordinal()].report();

            /*输出二维空间的局面*/
            board.output();
        }
    }

}

enum CREATRUE{
    葫芦娃, 妖怪, 旁观者
}
