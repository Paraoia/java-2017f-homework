/*public enum Age {
    老大(1), 老二(2), 老三(3), 老四(4), 老五(5), 老六(6), 老七(7);
    private int index;
    Age(int idx) {
        this.index = idx;
    }
}
public enum Color {
    赤(1), 橙(2), 黄(3), 绿(4), 青(5), 蓝(6), 紫(7);
    private int index;
    Color(int idx) {
        this.index = idx;
    }
}
*/
enum Age { 老大, 老二, 老三, 老四, 老五, 老六, 老七; }
enum Color { 赤, 橙, 黄, 绿, 青, 蓝, 紫; }

public class Calabash {

    Age age;
    Color color;
    int pre_pos;
    int cur_pos;
    public Calabash(int name, int pos) {
        age = Age.values()[name-1];
        color = Color.values()[name-1];
/*        switch(name) {
            case 1: age = Age.老大; color = Color.赤;break;
            case 2: age = Age.老二; color = Color.橙;break;
            case 3: age = Age.老三; color = Color.黄;break;
            case 4: age = Age.老四; color = Color.绿;break;
            case 5: age = Age.老五; color = Color.青;break;
            case 6: age = Age.老六; color = Color.蓝;break;
            case 7: age = Age.老七; color = Color.紫;break;
        }
*/

//        age = new Age(name);
//        color = new Color(name);
        pre_pos = pos;
        cur_pos = pos;
    }
    public int get_name() {
        return age.ordinal();
    }
    public void print_name() {
        System.out.printf(age + " ");
    }
    public void print_color() {
        System.out.printf(color + " ");
    }
    public void move(int pos) {
        pre_pos = cur_pos;
        cur_pos = pos;
        System.out.printf(age + ": " + pre_pos + "->" + cur_pos + "\n");
    }
}
