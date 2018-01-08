/** Assigenment 1: Gourd-Brother-oriented programming
 *  @version 2.0
 *  @author 151140042
 *
 *  This part produces seven cute boys.
 */

public class Gourd {

    private Lotus lotus;
    private Attribute attribute;

    public Gourd() {
        lotus = null;
        attribute = Attribute.getAttribute();
    }

    public void exchange(Gourd mate) {
        if (mate != null && this != mate) {
            lotus.getGourd(mate);
            mate.lotus.getGourd(this);
            Lotus t = lotus;
            getLotus(mate.lotus);
            mate.getLotus(t);
            System.out.println(putRank() + ": " + mate.lotus.putOrdinal() + " -> " + lotus.putOrdinal() + "\n" + mate.putRank() + ": " + lotus.putOrdinal() + " -> " + mate.lotus.putOrdinal());
        }
    }

    /** @param target to bind with */
    public void getLotus(Lotus target) {
        lotus = target;
    }

    public String putColor() {
        switch (attribute) {
            case FIRST:
                return "红色";
            case SECOND:
                return "橙色";
            case THIRD:
                return "黄色";
            case FOURTH:
                return "绿色";
            case FIFTH:
                return "青色";
            case SIXTH:
                return "蓝色";
            default:
                return "紫色";
        }
    }

    public String putRank() {
        switch (attribute) {
            case FIRST:
                return "老大";
            case SECOND:
                return "老二";
            case THIRD:
                return "老三";
            case FOURTH:
                return "老四";
            case FIFTH:
                return "老五";
            case SIXTH:
                return "老六";
            default:
                return "老七";
        }
    }

    public int putOrdinal() {
        return attribute.ordinal();
    }
};