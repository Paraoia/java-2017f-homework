enum Color {
    红, 橙, 黄, 绿, 青, 蓝, 紫
}

enum Rank {
    老大, 老二, 老三, 老四, 老五, 老六, 老七
}

public class Hulu {
    private Rank name;
    private Color color;
    int src;
    int dst;

    public Hulu(int name1, int pos) {
        name = Rank.values()[name1-1];
        color = Color.values()[name1-1];
        src=pos;
        dst=pos;
    }

    public int getName(){
        return name.ordinal();
    }

    public int getColor() {
        return color.ordinal() ;
    }

    public void print_name() {
        System.out.println(name);
    }

    public void print_color() {
        System.out.println(color);
    }

    public void print_move(int pos){
        src=dst;
        dst=pos;
        System.out.printf("%s: %d -> %d\n", name, src, dst);
    }
}
