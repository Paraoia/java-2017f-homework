import com.sun.media.sound.ModelStandardIndexedDirector;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Matrix{
    private Position[][] positions;

    public Position[][] getPositions() {
        return positions;
    }

    public void setPositions(Position[][] positions) {
        this.positions = positions;
    }

    private Creature[] creatures;

    public Matrix(int x){
        int length = x > 10 ? x:10;
        this.positions = new Position[length][length];

        for(int i = 0 ; i < length ; i++){
            for(int j = 0 ; j < length; j++) {
                this.positions[i][j] = new Position(i, j);
            }
        }

    }


    private void shuffle(Creature member[]){
        this.creatures= member;
        Random rnd = ThreadLocalRandom.current();
        for(int i = creatures.length-1; i >= 0; i--){
            int x = rnd.nextInt(positions.length);
            int y = rnd.nextInt(positions.length);

            if(positions[x][y].getHolder() == null){
                creatures[i].setPosition(positions[x][y]);
            }
            else
                i++;

        }
    }

    public void printMatix(){
        for(Position []position0 :this.positions) {
            for (Position position : position0) {
                if (position.getHolder() == null) {
                    System.out.print("    ");
                } else {
                    position.getHolder().printName();
                }
            }
            System.out.print("\n");
        }

        System.out.println("\n");
        System.out.flush();
    }

    public void StandFormation(Formation formation,Creature []creature){

        Position []position = formation.getPositions();

        for(int i = 0,j=0 ; i < creature.length;i++){
            positions[creature[i].getPosition().getX()][creature[i].getPosition().getY()].setHolder(null);
            if(creature[i] instanceof Minion) {

                creature[i].setPosition(position[j]);
                j++;
            }
            else if(creature[i] instanceof Grandpa){
                creature[i].setPosition(position[0]);
            }
            else if(creature[i] instanceof  Magnate && creature[i].getName() == "蛇精"){
                creature[i].setPosition(position[1]);
            }
            else if(creature[i] instanceof  Magnate && creature[i].getName() == "蝎子") {
                creature[i].setPosition(position[0]);
                j++;
            }


        }
    }

    public  void StandInMatrix(int n,Formation formation,Creature [] creature){

        //for(int i = 0 ; i < creature.length;i++)
        //    System.out.println(creature[i].getName());
        for(Position []position0 :this.positions) {
            for (Position position : position0) {
                if(position.getHolder() instanceof Calabash)
                    continue;
                else
                    position.setHolder(null);
            }
        }
        Formation go = new Formation(2);
        go.GoGoGo();

        StandFormation(go, Arrays.copyOfRange(creature, 0, 2));

        StandFormation(formation,Arrays.copyOfRange(creature, 2,creature.length));

        for(int i = 0 ;i < creature.length;i++){
            this.positions[creature[i].getPosition().getX()+n/5][creature[i].getPosition().getY()+2].cleanHolder();
            this.positions[creature[i].getPosition().getX()+n/5][creature[i].getPosition().getY()+2].setHolder(creature[i]);
            creature[i].setPosition(this.positions[creature[i].getPosition().getX()+n/5][creature[i].getPosition().getY()+2]);
        }
    }

    public Creature[] getCreatures() {
        return creatures;
    }

    public static void main(String[] args){
       // Calabash[] all = new Calabash[7];
        Creature[] all = new Creature[20];
        for(int i = 0 ; i < 7;i++){
            all[i] = new Calabash(i);
        }
        all[7] = new Grandpa();
        all[8] = new Magnate(1);
        all[9]= new Magnate(0);
        for(int i = 10;i < all.length;i++)
            all[i] = new Minion(i-10);

        Matrix matrix = new Matrix(15);

        matrix.shuffle(all);
        matrix.printMatix();

        new BubbleSorter().sort(matrix);

        matrix.printMatix();



       // matrix.printMatix();
        Formation formation;
        formation = new Formation(all.length-9);
        formation.YuLin();

        matrix.StandInMatrix(15,formation, Arrays.copyOfRange(all, 7, all.length));

        matrix.printMatix();

        formation = new Formation(all.length-9);
        formation.YanXing();

        matrix.StandInMatrix(15,formation, Arrays.copyOfRange(all, 7, all.length));

        matrix.printMatix();
    }
}
