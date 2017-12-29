/**
 * Created by bingo on 2017/10/22.
 */
public class Position {
    private Point point;
    private Creature holder;

    public Position(Point point) {
        this.point = point;
        this.holder = null;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Creature getHolder() {
        return this.holder;
    }

    public void setHolder(Creature holder) {
        this.holder = holder;
    }
}
