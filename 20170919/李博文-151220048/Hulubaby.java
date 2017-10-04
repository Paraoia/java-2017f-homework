enum Color {
    RED("红色", 1), ORANGE("橙色", 2), YELLOW("黄色", 3), GREEN("绿色", 4), CYAN("青色", 5), BLUE("蓝色", 6), PURPLE("紫色", 7);

    public String name;
    public int index;

    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
public class Hulubaby {
    int range; //排名
    Color color;
    String name;

    public Hulubaby(int range, Color color, String name) {
        this.range = range;
        this.color = color;
        this.name = name;
    }
}

