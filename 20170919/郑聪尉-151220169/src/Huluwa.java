/**
 * This class defines Huluwa.
 */

public class Huluwa {
    private String name;
    private String color;
    private int position;

    public Huluwa(String name, String color, int position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getPosition() {
        return position;
    }

    public void jumpFromTo(int i, int j) {
        System.out.println(name + ":\t" + i + "->" + j);
    }

    public void countOff(int kind) {
        if (0 == kind)
            System.out.println(name);
        else if (1 == kind)
            System.out.println(color);
    }
}
