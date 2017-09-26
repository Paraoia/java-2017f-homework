import com.sun.org.apache.xpath.internal.operations.Bool;

public class Huluwa {
    private String name;
    private Color color;
    private Integer seniority;
    //
    public enum Color {
        CHI, CHENG, HUANG, LV, QING, LAN, ZI, NONE;

        private static String colorString = "赤橙黄绿青蓝紫";
        @Override
        public String toString() {
            return "" + colorString.charAt(this.ordinal());
        }

        public static Color colorAt(Integer ordinal) {
            switch (ordinal) {
                case 1: return CHI;
                case 2: return CHENG;
                case 3: return HUANG;
                case 4: return LV;
                case 5: return QING;
                case 6: return LAN;
                case 7: return ZI;
                default: return NONE;
            }
        }
    }

    Huluwa(Integer seniority, String name, Color color) {
        this.seniority = seniority;
        this.name = name;
        this.color = color;
    }

    public void moveTo(Queue.Position to) {
        to.seat = this;
        whatName();
        System.out.println(" -> " + to.position);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void whatName() {
        System.out.print(getName());
    }

    public void whatColor() {
        System.out.print(getColor());
    }

    public Boolean isGreaterThan(Huluwa h) {
        return this.seniority > h.seniority;
    }

    public Boolean isLessThan(Huluwa h) {
        return this.seniority < h.seniority;
    }

    public Boolean isEqualTo(Huluwa h) {
        return this.seniority == h.seniority;
    }

    public static void main(String[] args)
    {
        GrandFather gf = new GrandFather();
        gf.enqueueHuluwas();
        gf.sortHuluwas(Queue.SortType.BUBBLE);
        gf.report(GrandFather.ReportType.NAME);
        gf.dequeueHuluwas();
        gf.enqueueHuluwas();
        gf.sortHuluwas(Queue.SortType.QUICK);
        gf.report(GrandFather.ReportType.COLOR);
    }
}
