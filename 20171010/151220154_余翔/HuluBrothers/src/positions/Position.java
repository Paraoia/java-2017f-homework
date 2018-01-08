package positions;

import creatures.Creature;

public class Position {

    private int x;

    private boolean empty;

    private Creature holder;

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(){
        this.empty = true;
    }

    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {

        this.holder = holder;
        this.empty = false;
    }

    public void delHolder() {
        this.holder = null;
        this.empty = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Position(){
        empty = true;
    }

    public Position(int x){
        super();
        this.x = x;
    }
}
