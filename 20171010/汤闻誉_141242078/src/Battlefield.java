import java.awt.*;

public class Battlefield {
    final int N=15;
    Creature holder[][]=new Creature[N][N];

    private void checkConflict(int x,int y){
        if( holder[x][y]!=null||x<0||y<0||x>=N||y>=N){
            System.out.println("Find a conflict at position"+x+","+y);
            System.exit(1);
        }
    }

    public void formationIn(Creature[] formation,int x,int y){
        for(int i=0;i<formation.length;i++){
            int x1=formation[i].getPosition().getX();
            int y1=formation[i].getPosition().getY();
            checkConflict(x+x1,y+y1);
            holder[x+x1][y+y1]=formation[i];
        }
    }

    public void creatureIn(Creature creature,int x,int y){
        checkConflict(x,y);
        holder[x][y]=creature;
    }

    public void print(){
        for(int j=0;j<N;j++){
            for(int i=0;i<N;i++) {
                if (holder[i][j] == null)System.out.print("      ");
                else holder[i][j].report();
                System.out.print("  ");
            }
            System.out.println();
            System.out.println();
        }
    }


}
