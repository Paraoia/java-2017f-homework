public class Snake implements Creature, Comparable {
    private Position pos;

    @Override
    public void setPos(Position pos) {
        this.pos = pos;
    }

    @Override
    public Position getPos() {
        return this.pos;
    }

    @Override
    public void report() {
        if (this.pos != null)
            System.out.println("Snake @ " + this.pos.getX() + "," + this.pos.getY());
    }

    @Override
    public boolean biggerThan(Comparable another) {
        if (another instanceof Grandpa || another instanceof Boy)
            return false;
        else
            return true;
    }
}
