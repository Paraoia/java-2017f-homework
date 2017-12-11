import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Space {

    private Position[] space;
    private int N;

    private Creature[] huluwa, soldierTeam;
    private Creature grandpa,snake;


    public Space(int n, Creature[] huluwa, Creature[] soldierTeam, Creature grandpa, Creature snake){
        this.N = n;
        this.space = new Position[n*n];
        for(int i=0;i<n*n;++i){
            space[i] = new Position(new Point(i/n,i%n));
        }

        this.huluwa = huluwa;
        this.soldierTeam = soldierTeam;
        this.grandpa = grandpa;
        this.snake = snake;
    }

    public void arrangeFormation(Creature[] creatures, Formation formation){
        //let the creature get out of the position first
        for(Creature creature:creatures){
            if(creature.getPosition() != null) {
                creature.getPosition().setHolder(null);
            }
        }

        //sort the creatures
        Arrays.sort(creatures);

        //find a suitable place to put the creatures with the given formation
        Point base = null;
        int len = formation.getPoints().length;
        boolean found = false;// a flag to break the two layer loop
        for(int i=0;i<this.N&&!found;++i){
            for(int j=0;j<this.N;++j){
                boolean suitable = true;
                for(int k=0;k<len;++k){
                    int x = i + formation.getPoints()[k].getX();
                    int y = j + formation.getPoints()[k].getY();
                    if(outOfBounds(x, y) || space[x*this.N+y].getHolder()!=null){
                        suitable = false;
                        break;
                    }
                }
                if(suitable){
                    base = new Point(i,j);
                    found = true;
                    break;
                }
            }
        }

        //now put the creatures into the space
        for(int i=0;i<len;++i){
            int x = base.getX() + formation.getPoints()[i].getX();
            int y = base.getY() + formation.getPoints()[i].getY();
            space[x*this.N+y].setHolder(creatures[i]);
            creatures[i].setPosition(space[x*this.N+y]);
        }
    }

    public void print(){
        String format = "%12s";
        for(int i=0;i<this.N;++i){
            for(int j=0;j<this.N;++j){
                if(space[i*this.N+j].getHolder() != null) {
                    String str = String.format(format, space[i * this.N + j].getHolder().speak());
                    System.out.print(str);
                }else{
                    String str = String.format(format, "empty");
                    System.out.print(str);
                }
            }
            System.out.println();
        }
    }

    private boolean outOfBounds(int x, int y){
        return x<0 || x>=this.N || y<0 || y>=this.N;
    }

}
