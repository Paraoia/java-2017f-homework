package Position;


public class Position2D implements Position{
    Integer x, y;

    public Position2D(Integer x, Integer y) {
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

    @Override
    public Integer calFromOrigin(Position spaceScope){
        return ((Position2D)spaceScope).getX() * y + x;
    }

    @Override
    public void add(Position position){
        this.x += ((Position2D)position).getX();
        this.y += ((Position2D)position).getY();
    }

    @Override
    public void sub(Position position){
        this.x -= ((Position2D)position).getX();
        this.y -= ((Position2D)position).getY();
    }

    @Override
    public double distance(Position position){
        return  Math.sqrt(
                Math.pow(this.x - ((Position2D)position).getX(), 2) +
                Math.pow(this.y - ((Position2D)position).getY(), 2)
        );
    }
}
