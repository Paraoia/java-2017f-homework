public class Formation {
    private Point points[];

    public Formation(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    // point.Y = -point.Y
    public Formation UD() {
        for(int i = 0; i < points.length; i ++) {
            points[i].setY(-points[i].getY());
        }

        return this;
    }

    // point.X = - point.X
    public Formation LR() {
        for(int i = 0; i < points.length; i ++) {
            points[i].setX(-points[i].getX());
        }

        return this;
    }

    // point.X = point.Y
    // point.Y = point.X
    public Formation EX() {
        for(int i = 0; i < points.length; i ++) {
            int temp = points[i].getX();
            points[i].setX(points[i].getY());
            points[i].setY(temp);
        }

        return this;
    }

    public static Formation HEYI = new Formation(
            new Point[] {
                    new Point(0, 0),
                    new Point(-1, -1), new Point(1, -1),
                    new Point(-2, -2), new Point(2, -2),
                    new Point(-3, -3), new Point(3, -3),
            }
    );

    public static Formation YANXING = new Formation(
            new Point[] {
                    new Point(0, 0),
                    new Point(-1, -1), new Point(1, 1),
                    new Point(-2, -2), new Point(2, 2),
                    new Point(-3, -3), new Point(3, 3),
            }
    );

    public static Formation CHANGSHE = new Formation(
            new Point[] {
                    new Point(0, 0),
                    new Point(-1, 0), new Point(1, 0),
                    new Point(-2, 0), new Point(2, 0),
                    new Point(-3, 0), new Point(3, 0),
            }
    );

    public static Formation HENGE = new Formation(
            new Point[] {
                    new Point(0, 0),
                    new Point(0, 2), new Point(0, -2),
                    new Point(-1, -1), new Point(-1, 1),
                    new Point(-1, -3), new Point(-1, 3),
            }
    );

    public static Formation FENGSHI = new Formation(
            new Point[] {
                    new Point(0, 0),
                    new Point(-1, -1), new Point(1, -1),
                    new Point(-2, -2), new Point(2, -2),
                    new Point(0, -2), new Point(0, -4),
            }
    );
}
