public class Position {

    private Coord coord;
    private Creature holder;

    public Position(Coord coord){
        this.coord = coord;
    }

    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }

    public void swapHolderWith(Position position){
        Creature tmpCreature = this.getHolder();
        position.getHolder().setPosition(this);
        tmpCreature.setPosition(position);
    }

    public void moveHolderTo(Position desPosition){
        this.getHolder().setPosition(desPosition);
        this.setHolder(null);
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) { this.coord = coord; }

    public void setCoordX(int x){ coord.setX(x); }

    public void setCoordY(int y){ coord.setY(y); }

    public boolean holderOccupied(){
        if (holder==null) { return false; } else { return true; }
    }

}
