import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Flat {
    private Position[][] positions = new Position[15][15];

    private Creature[][] creatures = new Creature[2][8];
    //{{赤，橙，黄，绿，青，蓝，紫，爷}，{蛇，蝎，小，小，小，小，小，小}}

    public Position[][] getPositions() {
        return positions;
    }

    public Creature[][] getCreatures() {
        return creatures;
    }

    public Flat(Huluwa[] brothers, Grandpa grandpa, Snake snake, Scorpion scorpion, Minion[] minions){

        for (int i = 0; i < brothers.length; i++) {
            this.creatures[0][i] = brothers[i];
        }
        this.creatures[0][7] = grandpa;
        this.creatures[1][0] = snake;
        this.creatures[1][1] = scorpion;
        for (int i = 0; i < minions.length; i++) {
            this.creatures[1][i + 2] = minions[i];
        }


        for(int i = 0; i < positions.length; i++) {
            for(int j = 0; j < positions[i].length; j++){
                this.positions[i][j] = new Position(i,j);
                this.positions[i][j].setHolder(null);
            }
        }

        //brothers randomly stand
        this.creatures[0][0].setPosition(this.positions[7][3]);
        this.creatures[0][1].setPosition(this.positions[7][6]);
        this.creatures[0][2].setPosition(this.positions[7][2]);
        this.creatures[0][3].setPosition(this.positions[7][5]);
        this.creatures[0][4].setPosition(this.positions[7][1]);
        this.creatures[0][5].setPosition(this.positions[7][4]);
        this.creatures[0][6].setPosition(this.positions[7][0]);

        this.creatures[0][7].setPosition(null);
        this.creatures[1][0].setPosition(null);
        this.creatures[1][1].setPosition(null);
        for (int i = 2; i < this.creatures[1].length; i++) {
            this.creatures[1][i].setPosition(null);
        }
    }

    public Position[] getQueue(int x){return positions[x];}

    public void leadArray1(Creature leader, Creature[] members) {
        for(int i = 4; i <= 10;i++) {
            for (int j = 8; j <= 14; j++) {
                positions[i][j].setHolder(null);
            }
        }
        leader.setPosition(positions[7][11]);
        for (int i = 0; i < members.length; i += 2) {
            members[i].setPosition(positions[7 + i/2 + 1][11 + i/2 + 1]);
            members[i + 1].setPosition(positions[7 - i/2 - 1][11 + i/2 + 1]);
        }
    }//鹤翼

    public void leadArray2(Creature leader, Creature[] members) {
        for(int i = 4; i <= 10;i++) {
            for (int j = 8; j <= 14; j++) {
                positions[i][j].setHolder(null);
            }
        }
        leader.setPosition(positions[7][11]);
        for (int i = 0; i < members.length; i += 2) {
            members[i].setPosition(positions[7 + i/2 + 1][11 + i/2 + 1]);
            members[i + 1].setPosition(positions[7 - i/2 - 1][11 - i/2 - 1]);
        }
    }//雁行

    public void placeCreature(Creature creature, int x, int y){
        if(creature.getPosition() == null)
            creature.setPosition(positions[x][y]);
        else{
            creature.getPosition().setHolder(null);
            creature.setPosition(positions[x][y]);
        }

    }

    public void giveCheer(Creature creature)
    {
        creature.report();
        System.out.println(": 加油！");
    }

    public void printFlat(){
        for(int i = 0;i < positions.length;i++)
        {
            for(int j = 0;j < positions[i].length;j++)
            {
                if(positions[i][j].getHolder() == null)
                    System.out.print("无 ");
                else
                    positions[i][j].getHolder().report();
            }
            System.out.println();
        }
    }

//    public void rollCall(){
///*        for(Creature creature : this.creatures){
//            creature.report();
//        }
//        System.out.println();
//        System.out.flush();
//*/
//        for(Position position : this.positions) {
//            position.getHolder().report();
//        }
//
//        System.out.println("\n");
//        System.out.flush();
//    }

//    private void shuffle(){
//        Random rnd = ThreadLocalRandom.current();
//        for(int i = creatures.length - 1; i > 0; i--)
//        {
//            int index = rnd.nextInt(i + 1);
//            Position position = creatures[index].getPosition();
//            creatures[index].setPosition(creatures[i].getPosition());
//            creatures[i].setPosition(position);
//        }
//    }

    public static void main(String[] args) {
        Huluwa[] brothers = new Huluwa[7];
        Grandpa grandpa = new Grandpa("爷");
        Snake snake = new Snake("蛇");
        Scorpion scorpion = new Scorpion("蝎");
        Minion[] minions = new Minion[6];

        for(int i = 0; i < brothers.length; i++)
        {
            brothers[i] = new Huluwa(COLOR.values()[i], SENIORITY.values()[i]);
        }

        for(int i = 0; i < minions.length; i++)
        {
            minions[i] = new Minion("啰");
        }

        Flat flat = new Flat(brothers, grandpa, snake, scorpion, minions);

        new InsertionSorter().sort(flat.getQueue(7),brothers.length);

        flat.leadArray1(scorpion, minions);

        flat.placeCreature(grandpa,0,0);
        flat.placeCreature(snake,0,14);

        flat.giveCheer(grandpa);
        flat.giveCheer(snake);
        flat.printFlat();

        flat.leadArray2(scorpion, minions);

        flat.placeCreature(grandpa,0,0);
        flat.placeCreature(snake,0,14);

        flat.giveCheer(grandpa);
        flat.giveCheer(snake);
        flat.printFlat();

    }
}