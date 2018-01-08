import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Space {
    private int length;
    private ArrayList<Creature[]> creatures = new ArrayList<>();
    private Position[][] positions;

    Space(int N){
        this.length = N;
        positions = new Position[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                positions[i][j] = new Position(i,j);
    }

    public void joinStory(Creature[] avatars){
        creatures.add(avatars);
    }

    public boolean setInSpace(int x,int y,Creature c){
        if(x >= 0 && x < this.length && y >=0 && y < this.length){
            if(positions[x][y].getHolder() != null)
                return false;

            if(c.getPosition() != null)
                c.getPosition().setHolder(null);
            c.setPosition(positions[x][y]);
        }
        return false;
    }

    /* TODO not secure, need some security check*/
    public Creature expelAt(int x,int y){
        if(x >= 0 && x < this.length && y >=0 && y < this.length) {
            if(positions[x][y].getHolder() != null){
                Creature ret = positions[x][y].getHolder();
                ret.setPosition(null);
                positions[x][y].setHolder(null);
                return ret;
            }
        }
        return null;
    }

    public Position[][] getPositions(){
        return this.positions;
    }

    public void shuffle(Creature[] creatureArray){
        Random rnd = ThreadLocalRandom.current();
        for (int i = creatureArray.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Position position = creatureArray[index].getPosition();
            creatureArray[index].setPosition(creatureArray[i].getPosition());
            creatureArray[i].setPosition(position);
        }
    }

    public void printSpace(){
        for(int i=0;i<this.length;i++){
            for(int j=0;j<this.length;j++){
                if(positions[i][j].getHolder()!=null)
                    System.out.print(positions[i][j].getHolder());
                else
                    System.out.print("-");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void main(String[] args){
        Huluwa[] brothers = new Huluwa[7];
        for(int i=0;i<brothers.length;i++)
            brothers[i] = new Huluwa(COLOR.values()[i],SENIORITY.values()[i]);

        Grandpa[] grandpa = new Grandpa[1];
        grandpa[0] = new Grandpa();

        Snake[] snake = new Snake[1];
        snake[0] = new Snake();

        Minions[] minions = new Minions[7];
        minions[0] = new Minions("蝎");
        for(int i=1;i<7;i++)
            minions[i] = new Minions("兵" );

        /* 12*12 */
        Space space = new Space(12);

        /* join the story */
        space.joinStory(brothers);
        space.joinStory(grandpa);
        space.joinStory(snake);
        space.joinStory(minions);

        /* Huluwa formation */
        new LongSnakeFormation().form(space,2,2,brothers);

        space.shuffle(brothers);

        System.out.println("*****before sort******");
        space.printSpace();

        new BubbleSorter().sort(space,2,2,brothers.length);

        System.out.println("*****after sort******");
        space.printSpace();

        /* Minions Formation */
        new HeyiFormation().form(space,6,5,minions);

        /* Grandpa */
        space.setInSpace(0,0,grandpa[0]);

        /* Snake */
        space.setInSpace(11,11,snake[0]);

        System.out.println("*****Heyi Zhen******");
        space.printSpace();
        grandpa[0].act();
        snake[0].act();

        /* reshape */
        new ArrowFormation().form(space,6,5,minions);

        System.out.println("*****Fengshi Zhen******");
        space.printSpace();
        grandpa[0].act();
        snake[0].act();
    }
}

enum AvatarType{
    HULUWA,GRANDPA,SNAKE,MINIONS
}