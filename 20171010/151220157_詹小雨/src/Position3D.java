public class Position3D implements Position {

    private int x, y, z;

    Position3D() { x = Integer.MIN_VALUE; y = Integer.MIN_VALUE; z = Integer.MIN_VALUE; }

    Position3D(int locx, int locy, int locz) { x = locx; y = locy; z = locz; }

     /* public void setX(int loc) { x = loc; }

    public void setY(int loc) { y = loc; }

    public void setZ(int loc) { z = loc; }*/

    public int getX() { return x; }

    public int getY(){ return y; }

    public int getZ(){ return z; }

    public void moveto(Position position) { x = position.getX(); y = position.getY(); z = position.getZ(); }

    public Position getposition() { Position newposition = new Position3D(x, y, z); return newposition; }

    public void clear() { x = Integer.MIN_VALUE; y = Integer.MIN_VALUE; z = Integer.MIN_VALUE; }

}