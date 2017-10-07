import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Queue {
    static class Position {
        Integer position;
        Huluwa seat;

        Position(Integer position, Huluwa huluwa)
        {
            this.position = position;
            this.seat = huluwa;
        }
    }
    private List<Position> positions = new ArrayList<>();

    public void sort(SortType type) {
        switch (type) {
            case BUBBLE: bubbleSort(); break;
            case QUICK: qSort(); break;
        }
    }

    public void clear() {
        positions.clear();
    }

    public void shuffle() {
        Collections.shuffle(positions);
        for (Integer i = 0; i < length(); i++) get(i).position = i;
    }

    public Integer length() {
        return positions.size();
    }

    public Integer tail() {
        return length();
    }

    public void report(GrandFather.ReportType what) {
        switch (what) {
            case NAME:
                for (Position position : positions) {
                    position.seat.whatName();
                    System.out.println();
                } break;
            case COLOR:
                for (Position position : positions) {
                    position.seat.whatColor();
                    System.out.println();
                } break;
        }
    }

    public Position get(Integer i) {
        return positions.get(i);
    }

    public void add(Position p) {
        positions.add(p);
    }

    public enum SortType {
        BUBBLE, QUICK
    }

    private void bubbleSort() {
        for (int i = 0; i < length(); i++)
        {
            boolean noChange = true;
            for (int j = length() - 1; j > i; j--)
            {
                Position ll = get(j - 1), rr = get(j);
                if (ll.seat.isGreaterThan(rr.seat))
                {
                    Huluwa l = ll.seat, r = rr.seat;
                    l.moveTo(rr);
                    r.moveTo(ll);
                    noChange = false;
                }
            }
            if (noChange)
                break;
        }
    }

    private void qSort() {
        _qSort(0, length() - 1);
    }

    private void _qSort(Integer i, Integer j) {
        if (j - i < 1) return;
        //save
        Integer l = i, r = j;
        //pivot
        Random random = new Random(System.currentTimeMillis());
        Position pivotPosition = get(i + random.nextInt(j + 1 - i));
        Huluwa pivot = pivotPosition.seat;
        //prepare
        Position empty = get(i++);
        empty.seat.moveTo(pivotPosition);
        //go
        out: while (true) {
            while (true) {
                if (get(j).seat.isLessThan(pivot)) break;
                j--;
                if (i > j) break out;
            }
            get(j).seat.moveTo(empty);
            empty = get(j);
            while (true) {
                if (get(i).seat.isGreaterThan(pivot)) break;
                i++;
                if (i >= j) break out;
            }
            get(i).seat.moveTo(empty);
            empty = get(i);
        }
        //fulfill empty
        pivot.moveTo(empty);
        //sort the remain
        _qSort(l, empty.position - 1);
        _qSort(empty.position + 1, r);
    }
}