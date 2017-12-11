import java.util.ArrayList;
import java.util.Iterator;

public interface Order {

    public static void addPos(int x, int y, ArrayList<Position> positions, Iterator<Creature> it) {
        Position pos = new Position(x, y);
        positions.add(pos);
        it.next().setPosition(pos);
    }

    public void rank(Embattle em, int lackeysSize);

}
