/**
 * Created by Yuyang Wei on 2017/10/16.
 */
public class Position {
    private boolean have;
    private int x;
    private int y;

    public Creature getHolder() {return holder;}

    public void setHolder(Creature holder){this.holder=holder;}

    private Creature holder;

    public boolean getHave(){return have;}

    public void setHaveTrue(){this.have=true;}
    public void setHaveFalse(){this.have=false;}

    public int getX(){return x;}
    public int getY(){return y;}

    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}

    public Position(int x, int y){
        super();
        this.have=false;
        this.x=x;
        this.y=y;
    }
}
