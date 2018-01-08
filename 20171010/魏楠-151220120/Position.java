public class Position implements Comparable<Position>{
    private int x;
    private int y;
    private Creature creature = null;
    Position(int x, int y, Creature creature) {
        this.x = x;
        this.y = y;
        this.creature = creature;
    }
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Position(Creature creature) {
        this.creature = creature;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Creature getCreature() {
        return this.creature;
    }
    public void setCreature(Creature creature) {
        this.creature = creature;
    }
    public boolean isEmpty() {
        if(this.creature == null)
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Position position) {
        return this.getY() - position.getY();
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
