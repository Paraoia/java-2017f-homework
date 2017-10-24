package hlw;

public class HuLuWa implements Creature, Comparable{
    private RANK rank;
    private COLOR color;
    private Position pos;

    HuLuWa(RANK rk, COLOR cl){
        rank = rk;
        color = cl;
        pos = null;
    }
    public String show(){
        return rank + " " + color + " ";
    }
    public Position get_pos() {
        return pos;
    }
    public void set_pos(Position p){
        int old_p = -1;
        if (pos != null){
            old_p = pos.get_index() + 1;
        }
        int new_p = p.get_index() + 1;
        System.out.println( rank.toString() + ":" + old_p + "->" + new_p);
        pos = p;
        p.put_in(this);
    }
    public boolean BiggerThan(Comparable another){
        if (this.rank.ordinal() < ((HuLuWa)another).get_rank().ordinal()) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public RANK get_rank(){
        return rank;
    }
    public COLOR get_color(){
        return color;
    }
    public void echo_move(String movement){
        System.out.print(rank + ":" + movement);
    }
}
enum COLOR{
    红,橙,黄,绿,青,蓝,紫
}
enum RANK{
    老大,老二,老三,老四,老五,老六,老七
}