package field;

public class Coordinate implements Comparable<Coordinate> {
    private Integer x;
    private Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public static Coordinate first() {
        return new Coordinate(0, 0);
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }

    @Override
    public int compareTo(Coordinate o) {
        Integer compareX = x.compareTo(o.x);
        return compareX == 0 ? y.compareTo(o.y) : compareX;
    }
}
