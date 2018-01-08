/**
 * Created by Yuyang Wei on 2017/10/17.
 */
public class Grandfather implements Creature{
    private String name;
    private Position position;

    Grandfather(){
        this.name="爷 爷";
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        position.setHolder(this);
    }

    @Override
    public void report() {
        System.out.print(this.toString());
    }

    @Override
    public String toString(){
        return this.name+"@(" + this.position.getX()+","+this.position.getY()+");";
    }
}
