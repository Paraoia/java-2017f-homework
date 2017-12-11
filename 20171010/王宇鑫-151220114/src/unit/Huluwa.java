package unit;

public class Huluwa extends Unit {
    private Color color;
    private Integer seniority;

    public enum Color {
        CHI, CHENG, HUANG, LV, QING, LAN, ZI;

        @Override
        public String toString() {
            return "" + "赤橙黄绿青蓝紫".charAt(this.ordinal());
        }

        public static Color colorAt(Integer ordinary) {
            return values()[ordinary - 1];
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

    public Huluwa(String name, Color color, Integer seniority) {
        super(name);
        this.color = color;
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return super.toString() + "(" + getColor() + ")";
    }

    @Override
    public void report() {
        super.report();
        System.out.println();
    }

    @Override
    public int compareTo(Unit other) {
        if (other instanceof Huluwa) {
            return this.seniority.compareTo(((Huluwa) other).seniority);
        } else {
            return super.compareTo(other);
        }
    }
}
