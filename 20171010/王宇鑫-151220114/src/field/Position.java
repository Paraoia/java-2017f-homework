package field;

import unit.Unit;

public class Position implements Comparable<Position> {
    private Coordinate coordinate;
    private Unit seat;

    public Position(Unit seat, Coordinate coordinate) {
        this.seat = seat;
        this.coordinate = coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setSeat(Unit seat) {
        this.seat = seat;
    }

    public Unit getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return coordinate + "(" + seat + ")";
    }

    @Override
    public int compareTo(Position o) {
        return coordinate.compareTo(o.coordinate);
    }
}
