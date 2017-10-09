/** Assigenment 1: Gourd-Brother-oriented programming
 *  @version 2.0
 *  @author 151140042
 *
 *  This part prepares initial individual characters.
 */

public enum Attribute {
    
    FIRST,SECOND,THIRD,FOURTH,FIFTH,SIXTH,SEVENTH;
    private boolean occupied;

    /** return an unassigned attribute, otherwise one random
     *  @throws UnsupportedOperationException that there will be objects with the same attributes
     */
    public static Attribute getAttribute() {
        try {
            for (Attribute i : values())
                if (!i.occupied) {
                    i.occupied = true;
                    return i;
                }
            throw new UnsupportedOperationException();
        } catch(UnsupportedOperationException e) {
            System.out.println("fail in identicaction");
            return values()[(int)(Math.random() * Attribute.values().length)];
        }
    }

    public static void reset() {
        for (Attribute i : values())
            i.occupied = false;
    }

}