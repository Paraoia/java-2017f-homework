
public class Goblins implements Creature, Comparable {

    private int no;
    private Position pos;

    public Goblins(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

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
            System.out.println("goblin" + no + " @ " + this.pos.getX() + "," + this.pos.getY());
    }

    @Override
    public boolean biggerThan(Comparable another) {
        if (another instanceof Goblins)
            return this.getNo() > ((Goblins) another).getNo();
        else
            return false;
    }

}
