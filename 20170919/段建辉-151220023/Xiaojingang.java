
public class Xiaojingang {
    /*
     * To make sure there is only one object for each Huluwa,
     * there's no static for rank, color and name.
     *
     * And Xiaojingang is for latter usage.
     *
     * All the 7 huluwas' talkName and talkColor extends from Xiaojingang.
     *
     */
    protected int rank;
    protected Color color;
    protected enum Color {COLORFUL, RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE};
    protected String name;

    public Xiaojingang() {
        rank = 0;
        color = Color.COLORFUL;
        name = "小金刚";
    }

    int getRank() {
        return rank;
    }
    String talkName() {
        return name;
    }
    String talkColor() {return color.toString(); }
    void talkSkill() {
        System.out.println("我可以打败蛇精！");
    }
}
