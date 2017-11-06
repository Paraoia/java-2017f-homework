package Position;

public interface Position {
    public Integer calFromOrigin(Position spaceScope);
    public void add(Position position);
    public void sub(Position position);
    public double distance(Position position);
}
