public class Stage {
    public Position[] positions;

    public Stage(){
        positions = new Position[8];
        for(int i = 0; i < positions.length; i++) {
            positions[i] = new Position();
            positions[i].index = i;
            positions[i].holder = null;
            positions[i].is_occupied = false;
        }
    }
    public void enqueue(Brother[] brothers){
        if(brothers.length > positions.length){
            return;
        }
        System.out.print("站队中：\n");
        brothers[0].jump(positions, 5);
        brothers[1].jump(positions, 6);
        brothers[2].jump(positions, 4);
        brothers[3].jump(positions, 3);
        brothers[4].jump(positions, 1);
        brothers[5].jump(positions, 7);
        brothers[6].jump(positions, 2);
        System.out.print("\n站队结束\n");
    }
    public void refresh_queue(){
        for(int i = 0; i < positions.length; i++){
            positions[i].remove();;
        }
    }
    public void tell_names(){
        System.out.print("名称报数：\n");
        for(int i = 1; i < positions.length; i++){
            positions[i].holder.tell_name();
        }
        System.out.print("\n");
    }
    public void tell_colors(){
        System.out.print("颜色报数：\n");
        for(int i = 1; i < positions.length; i++){
            positions[i].holder.tell_color();
        }
        System.out.print("\n");
    }
    /* 对排行（rank）冒泡排序 */
    public void bubble_sort_for_rank(){
        for (int i = 1; i < 7; i++) {
            for(int j = 1; j < 8 - i; j++) {
                if(positions[j].holder.getRank() > positions[j + 1].holder.getRank()){
                    positions[j].holder.swap(positions, (j + 1));
                    System.out.print("\n");
                }
            }
        }
    }

    /* 对颜色（color）快速排序 */
    int partition(int low, int high) {
        if(low < 1 || high >= positions.length){ return 0; }

        positions[low].holder.jump(positions,0);
        int pivot = positions[0].holder.getColor_rank();
        while(low < high) {
            while (low < high && positions[high].holder.getColor_rank() >= pivot) --high;
            if(low < high) positions[high].holder.jump(positions, low);
            while (low < high && positions[low].holder.getColor_rank() <= pivot) ++low;
            if(low < high) positions[low].holder.jump(positions, high);
        }
        positions[0].holder.jump(positions, low);
        System.out.print("\n");
        return low;
    }
    void qsort_for_color(int low, int high) {
        if(low < high) {
            int pivotloc = partition(low, high);
            qsort_for_color(low, pivotloc - 1);
            qsort_for_color(pivotloc + 1, high);
        }
    }
}
class Position{
    public int index;//位置
    public Brother holder;//该位置的葫芦娃
    public boolean is_occupied;//该位置被占用情况

    public Position(){
        index = -1;
        holder = null;
        is_occupied = false;
    }
    public void remove(){
        if(!is_occupied){return;}
        holder = null;
        is_occupied = false;
    }
}
