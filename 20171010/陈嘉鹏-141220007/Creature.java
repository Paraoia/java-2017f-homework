
public class Creature extends Obj implements Comparable<Creature>{
    Integer priority;

    Creature(Image img){
        super(img);
    }
    Creature(Image img, Integer priority){ super(img); this.priority = priority;}
    Creature(Position pos, Image img){
        super(pos, img);
    }
    Creature(Position pos, Image img, Integer priority){
        super(pos, img);
        this.priority = priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Creature arg0){
        return this.priority.compareTo(arg0.priority);
    }
}
