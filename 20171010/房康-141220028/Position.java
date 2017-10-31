public class Position {

    private Point point;
    private Creature holder;

    public Position(Point p){
        this.point = p;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Creature getHolder() {
        return holder;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }
}
