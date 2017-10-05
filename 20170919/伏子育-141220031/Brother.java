
public class Brother {

    public enum Color {RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE}

    ;

    public enum Name {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN}

    ;

    private Color color;
    private Name name;
    private int pos;

    public Brother(Color c, Name n) {
        color = c;
        name = n;
        pos = -1;
    }

    public Color getColor() {
        return color;
    }

    public Name getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void setName(Name n) {
        name = n;
    }

    public void setPos(int p) {
        pos = p;
    }

    public void moveTo(int p) {
        pos = p;
    }

    public void speak() {
        System.out.println("I'm brother " + name + ", " + "my color is " + color);
    }
}
