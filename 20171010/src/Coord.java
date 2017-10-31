public class Coord {
    private int x, y;
    public Coord (int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }
    public int getX(){ return x; }
    public int getY(){ return y; }
    public Coord plusRefCoord(Coord ref){ //不改變自身，返回一個新對象
        return new Coord(x+ref.x, y+ref.y);
    }
    public boolean isOutOfBound(int boundX, int boundY) {
        return (x < 0 || x > boundX || y < 0 || y > boundY);
    }
}
