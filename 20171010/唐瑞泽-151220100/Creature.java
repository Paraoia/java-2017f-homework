/**
 * Created by tangruize on 10/16/17.
 */
public class Creature {
    // creature's name
    private String name;

    // creature's attr. printing in the map. must be one character
    private String attr;

    // constructor
    Creature(String name, String attr) {
        this.name = name;
        this.attr = attr;
    }

    // get its name
    public String getName() {
        return name;
    }

    // get its attr.
    public String getAttr() {
        return attr;
    }
}
