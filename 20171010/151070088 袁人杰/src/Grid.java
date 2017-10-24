public class Grid implements CoordinatorCompare{
    private Coordinate coordinate;
    private  boolean occupied;
    private Creature holder;

    public Grid() {
        super();
        this.coordinate = new Coordinate();
        this.occupied=false;
        this.holder= null;

    }
    public Grid(int x, int y){
        super();
        this.coordinate= new Coordinate(x,y);
        this.holder= null;
        this.occupied=false;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied() {
        this.occupied = true;
    }

    public void cleanOccupied() {
        this.occupied = false;
    }

    public int getX() {return this.coordinate.getX();}


    public int getY() { return this.coordinate.getY(); }

    @Override
    public boolean XisBigger(Coordinate another) {
        if (another.getX()>this.getX())
            return true;
        else
            return false;
    }

    @Override
    public boolean YisBigger(Coordinate another) {
        if (another.getY()>this.getY())
            return true;
        else
            return false;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
        this.setOccupied();
    }

    public Creature getHolder() {
        return holder;
    }


}
