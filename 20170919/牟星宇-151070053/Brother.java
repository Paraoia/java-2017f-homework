
public class Brother {
    private int rank;//排名
    private String name;//名称
    private int color_rank;//颜色值
    private String color;//颜色
    private int stage_pos;//在stage中的位置

    public Brother(int rank, String name, int color_rank, String color){
        this.rank = rank;
        this.name = name;
        this.color_rank = color_rank;
        this.color = color;
        this.stage_pos = -1;
    }
    public void tell_name(){//报名称
        System.out.print( name + " ");
    }
    public void tell_color(){//报颜色
        System.out.print( color + " ");
    }
    public int getRank(){
        return rank;
    }
    public int getColor_rank(){
        return color_rank;
    }
    public void change_pos(int pos){
        if(pos == this.stage_pos){return;}
        int initial_pos = stage_pos;
        this.stage_pos = pos;
        System.out.print( name + ":" + initial_pos + "->" + stage_pos + " ");
    }
    public void reset_pos(){//重置葫芦娃位置值
        stage_pos = -1;
    }
    //葫芦娃从当前位置转移到pos位置上
    public int jump(Position[] p, int pos){
        if(p[pos].is_occupied){return 0;}
        p[pos].holder = this;
        if(stage_pos != -1) {
            p[stage_pos].remove();
        }
        this.change_pos(pos);
        p[pos].is_occupied = true;

        return 1;
    }
    //葫芦娃与位置中pos位的葫芦娃交换
    public int swap(Position[] p, int pos){
        if(p[pos].is_occupied == false || p[pos].holder.getRank() == rank || stage_pos == -1){ return 0;}
        //Brother temp = this;
        p[stage_pos].holder = p[pos].holder;
        p[stage_pos].holder.change_pos(stage_pos);
        p[pos].holder = this;
        p[pos].holder.change_pos(pos);
        return 1;
    }

}
