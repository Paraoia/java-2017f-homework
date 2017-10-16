import java.util.ArrayList;
import java.util.Iterator;

public class Arrow implements Order {

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
        Order.addPos(5, 4, positions, it);
        // lackeys
        Order.addPos(4, 5, positions, it);
        Order.addPos(3, 6, positions, it);
        Order.addPos(2, 7, positions, it);
        Order.addPos(6, 5, positions, it);
        Order.addPos(7, 6, positions, it);
        Order.addPos(8, 7, positions, it);
        for (int i = 0; i < lackeysSize - 6; i++)
            Order.addPos(5, i + 5, positions, it);
        // snake
        Order.addPos(5, 10, positions, it);
    }

}
