package sort;

import field.Coordinate;
import field.Position;

public interface Sortable {
    public void shuffle();
    public Integer length();
    public Boolean isEmpty();
    public Position get(Integer index);
    public Position get(Position position, Integer advance);
    public Position get(Coordinate coordinate);
    public Position getFirst();
    public Position getLast();
    public Integer distance(Position one, Position two);
    public Integer distance(Coordinate one, Coordinate two);
}
