enum Color {COLORFUL, RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE};

public class Xiaojingang implements creature {
    /*
     * To make sure there is only one object for each Huluwa,
     * there's no static for rank, color and name.
     *
     * And Xiaojingang is for latter usage.
     *
     * All the 7 huluwas' talkName and talkColor extends from Xiaojingang.
     *
     */
    int rank;
    Color color;
    String name;

    Xiaojingang() {
        rank = 0;
        color = Color.COLORFUL;
        name = "小金刚";
    }
    @Override
    public int getRank() {
        return rank;
    }
    @Override
    public String talkName() {
        return name;
    }
    @Override
    public void talkSkill() {
        System.out.println("我可以打败蛇精！");
    }
    String talkColor() {return color.toString(); }
}
