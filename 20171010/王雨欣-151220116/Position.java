
public class Position {
    boolean taken;
    Creature holder;
    /* 构造函数，实现成员定义时初始化 */
    Position(){
        taken = false;
        holder = null;
    }
    /* 该位置被生物a占用 */
    void Take(Creature a) {
        taken = true;
        holder = new Creature(a.name, a.pattern);
    }
    /* 释放该位置上的生物 */
    void Reset() {
        taken = false;
        holder = null;
    }
}
