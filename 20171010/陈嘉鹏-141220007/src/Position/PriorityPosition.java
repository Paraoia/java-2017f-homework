package Position;


public class PriorityPosition implements Position, Comparable<PriorityPosition>{
    Integer priority;
    Position position;

    public PriorityPosition(Integer priority, Position position) {
        this.priority = priority;
        this.position = position;
    }

    public Integer getPriority() {
        return priority;
    }

    public Position getPosition() {
        return position;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Integer calFromOrigin(Position spaceScope){
        return this.position.calFromOrigin(spaceScope);
    }

    @Override
    public void add(Position position){
        this.position.add(position);
    }

    @Override
    public void sub(Position position){
        this.position.sub(position);
    }

    @Override
    public double distance(Position position){
        return this.position.distance(position);
    }

    @Override
    public int compareTo(PriorityPosition arg0){
        return this.priority.compareTo(arg0.priority);
    }
}
