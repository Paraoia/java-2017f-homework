/**
 * Created by rajesh on 17-9-25.
 */


public class Brother {

    public enum Color {RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE}

    ;

    public enum Name {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN}

    ;

    private Color color;
    private Name name;

    public Brother(Color c, Name n) {
        color = c;
        name = n;
    }

    public Color getColor() {
        return color;
    }

    public Name getName() {
        return name;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void setName(Name n) {
        name = n;
    }
}
