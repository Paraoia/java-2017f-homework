

public class Position {

    Integer x, y, z;
    static final Integer dimension = 2;

    public Position(){
        x = y = 0;
    }

    public Position(Integer x, Integer y) {
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

    public Integer calIndex (Position limit){
        return y*limit.getX() + x;
    }

    public void add(Position p){
        this.x += p.x;
        this.y += p.y;
    }
}
