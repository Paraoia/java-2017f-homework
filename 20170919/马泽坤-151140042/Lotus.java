/** Assigenment 1: Gourd-Brother-oriented programming
 *  @version 2.0
 *  @author 151140042
 *
 *  This part processes an ordered queue.
 */

public class Lotus {

    private Gourd gourd;
    private Attribute attribute;

    public Lotus() {
        gourd = null;
        attribute = Attribute.getAttribute();
    }

    public void distribute(Gourd mate) {
        getGourd(mate);
        mate.getLotus(this);
    }

    /** @param target to bind with */
    public void getGourd(Gourd target) {
            gourd = target;
    }

    public Gourd putGourd() {
        return gourd;
    }

    public int putOrdinal() {
        return attribute.ordinal();
    }

};