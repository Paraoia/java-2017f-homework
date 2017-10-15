package hlw;

public class Position {
    private boolean avail;
    private Creature holder;
    private int index;
    Position(int idx){
        index = idx;
        avail = true;
        holder = null;
    }
    public Creature get_holder(){
        return holder;
    }
    public boolean get_avail(){
        return avail;
    }
    public int get_index() {
        return index;
    }
    public void put_in(Creature creature){
        avail = false;
        holder = creature;
    }
    public void clear_pos(){
        avail = true;
        holder = null;
    }

    public String show(){
        if (avail){
            return index + " " + "avail:" + avail + " ";
        }
        else{
            return index + " " + "avail:" + avail + " holder:" + holder.show();
        }
    }
}
