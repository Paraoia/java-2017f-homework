package creature;

/**
 * Created by cbcwe on 2017/10/16.
 */

public abstract class Creature {
    /* members variables */
    private int x = -1 ,y = -1; // position , from 0 to N-1

    /* abstract methods */
    public abstract String toString();

    /* public methods */
    public final void setX( final int x){
        this.x = x ;
    }
    public final void setY( final int y){
        this.y = y ;
    }
    public final int getX(){
        return x;
    }
    public final int getY(){
        return y;
    }


    public final void moveTo( final int dest_x, final int dest_y){

        System.out.println(toString()+" moves from ( "+x+" , "+y+" ) to ( " + dest_x+" , "+dest_y+" ) ");
        setX(dest_x);
        setY(dest_y);
    }
    public final void swapPoi( Creature another ){
        int temp_x = another.getX();
        int temp_y = another.getY();
        another.moveTo(x,y);
        moveTo(temp_x,temp_y);
    }

}
