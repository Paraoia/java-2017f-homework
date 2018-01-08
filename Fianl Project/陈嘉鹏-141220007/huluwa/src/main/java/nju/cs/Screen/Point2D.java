package nju.cs.Screen;

/**
 * @author chenjiapeng
 * @Description  2维坐标点
 * @date 2018-01-05
 */
public class Point2D {
    int x;
    int y;

    public Point2D(){}
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point2D add(Point2D p){
        return new Point2D(this.x + p.getX(), this.y + p.getY());
    }

    @Override
    public boolean equals(Object arg0){
        if (arg0 != null && arg0 instanceof Point2D)
            return x == ((Point2D) arg0).getX() && y == ((Point2D) arg0).getY();
        return false;
    }
    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
