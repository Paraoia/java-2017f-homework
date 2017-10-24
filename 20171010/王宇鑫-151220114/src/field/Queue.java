package field;

import sort.Sortable;
import sort.Sorter;
import unit.Manager;
import unit.NullUnit;
import unit.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Queue implements Sortable, Iterable<Position> {
    private Integer N;
    private List<Position> positions = new ArrayList<>();

    public Queue(Integer N) {
        this.N = N;
        dequeue();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(positions);
        for (Integer i = 0;i < N * N;i++)
            get(i).setCoordinate(new Coordinate(i / N, i % N));
    }

    @Override
    public Integer length() {
        return positions.size();
    }

    @Override
    public Boolean isEmpty() {
        for (Position position : positions) {
            if (position != null)
                return false;
        }
        return true;
    }

    @Override
    public Position get(Integer index) {
        return positions.get(index);
    }

    @Override
    public Position get(Position position, Integer advance) {
        Integer index = position.getCoordinate().getX() * N +
                position.getCoordinate().getY() + advance;
        if (index >= N * N || index < 0) return null;
        return get(index);
    }

    @Override
    public Position get(Coordinate coordinate) {
        return get(coordinate.getX() * N + coordinate.getY());
    }

    @Override
    public Position getFirst() {
        return get(0);
    }

    @Override
    public Position getLast() {
        return get(length() - 1);
    }

    @Override
    public Integer distance(Position one, Position two) {
        if (one == null || two == null) return 0;
        return distance(one.getCoordinate(), two.getCoordinate());
    }

    @Override
    public Integer distance(Coordinate one, Coordinate two) {
        if (one == null || two == null) return 0;
        return (one.getX() - two.getX()) * N +
                (one.getY() - two.getY());
    }

    private Position position;
    private Boolean first;

    @Override
    public Iterator<Position> iterator() {
        position = getFirst();
        first = true;
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                if (first) return position != null;
                return get(position, 1) != null;
            }

            @Override
            public Position next() {
                if (first) {
                    first = false;
                    return position;
                }
                position = get(position, 1);
                return position;
            }
        };
    }

    public Integer getN() {
        return N;
    }

    private Sorter sorter = null;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sort() {
        sorter.sort(this);
    }

    public List<Unit> getUnits(Manager you, Class type) {
        if (!you.isManager(type)) return null;
        List<Unit> list = new ArrayList<>();
        for (Position position : positions) {
            if (position.getSeat().getClass() == type)
                list.add(position.getSeat());
        }
        return list;
    }

    public void enqueue(List<Unit> members) {
        int index = 0;
        for (Position position : positions) {
            if (position.getSeat() instanceof NullUnit) {
                if (members.size() <= index) break;
                Unit unit = members.get(index++);
                position.setSeat(unit);
                unit.setPosition(position);
            }
        }
    }

    public void dequeue() {
        positions.clear();
        for (int i = 0;i < N * N;i++) {
            positions.add(new Position(new NullUnit(), new Coordinate(i / N, i % N)));
            get(i).getSeat().setPosition(get(i));
        }
    }

    public void report() {
        for (int i = 0;i < N * N;i++) {
            System.out.print(get(i) + " ");
            if (i % N == N - 1) {
                System.out.println();
            }
        }
    }
}
