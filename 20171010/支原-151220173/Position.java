public class Position {
    private int x;
    private int y;
    private Creature holder;
    private boolean empty;

    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
        empty=false;
    }

    public void CreatureOut()
    {
        this.holder=null;
        this.empty=true;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public void setPos(int x,int y) {
        this.x = x;
        this.y=y;
    }

    public boolean occupy(){ return !empty;}

    public Position(int x,int y){
        super();
        this.x = x;
        this.y=y;
        empty=true;
    }
}
