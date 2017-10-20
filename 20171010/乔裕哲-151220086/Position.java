public class Position {
    private int x;
    private int y;
    private Creature holder;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
        this.holder = null;
    }

    public Position(int x, int y, Creature holder){
        this.x = x;
        this.y = y;
        this.holder = holder;
    }

    public Creature getHolder(){
        return holder;
    };

    public Creature setHolder(Creature holder){
        Creature temp = this.holder;
        this.holder = holder;
        return temp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}
