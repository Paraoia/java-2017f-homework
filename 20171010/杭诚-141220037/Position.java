public class Position {
    boolean occupied;
    Creature holder;
    Position(){
        occupied = false;
        holder = null;
    }
    void reset(){
        occupied = false;
        holder = null;
    }
    void set(Creature creature){
        occupied = true;
        holder = new Creature(creature);
    }
}
