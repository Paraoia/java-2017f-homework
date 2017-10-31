import java.util.ArrayList;
import java.util.Iterator;

public class Crane implements Order {

    @Override
    public void rank(Embattle em, int lackeysSize) {
        ArrayList<Position> positions = em.getPositions();
        Iterator<Creature> it = em.getCreatures().listIterator();
        // brothers
        for (int i = 0; i < em.broLength; i++)
            Order.addPos(i + 2, 1, positions, it);
        // grandpa
        Order.addPos(5, 0, positions, it);
        // scorpion
        Order.addPos(5, 7, positions, it);
        // lackeys
        Order.addPos(4, 8, positions, it);
        Order.addPos(3, 9, positions, it);
        Order.addPos(2, 10, positions, it);
        Order.addPos(6, 8, positions, it);
        Order.addPos(7, 9, positions, it);
        Order.addPos(8, 10, positions, it);
        // snake
        Order.addPos(5, 10, positions, it);
    }

}
