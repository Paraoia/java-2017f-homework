public class Position {

    private int x;
    private int y;
    private Creature holder;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
        holder = null;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Creature getHolder(){
        return holder;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setHolder(Creature holder){
        this.holder = holder;
        this.holder.setPosition(this);
    }

    public void cleanHolder(){
        if(this.is_occupied()) {
            this.holder.cleanPosition();
            this.holder = null;
        }
    }

    public boolean is_occupied(){
        if(this.holder != null)
            return true;
        else
            return false;
    }

}
