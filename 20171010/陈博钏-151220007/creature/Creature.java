package creature;

/**
 * Created by cbcwe on 2017/10/16.
 */

public abstract class Creature {
    /* members variables */
    private int x,y; // position , from 0 to N-1
    private int next_x, next_y; // position of the next creature in the list
    private String name;

    /* abstract methods */
    public abstract void reportName();// report name with color

    /* public methods */
    public void setX(int x){
        this.x = x ;
    }
    public void setY(int y){
        this.y = y ;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void setNextX(int x){
        next_x = x ;
    }
    public void setNextY(int y){
        next_y = y ;
    }
    public int getNextX(){
        return next_x;
    }
    public int getNextY(){
        return next_y;
    }

    public void reportMove(int src_x, int src_y, int dest_x, int dest_y){
        reportName();
        System.out.println("move from ( "+src_x+" , "+src_y+" ) to ( " + dest_x+" , "+dest_y+" ) ");
    }

}
