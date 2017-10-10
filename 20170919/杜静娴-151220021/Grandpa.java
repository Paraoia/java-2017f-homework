public class Grandpa {
    CalabashBoy[] boys = new CalabashBoy[8]; //boys[0]不用
    Line line;
    static int count;
    static {
        count = 1;
    }
    Grandpa(){
        if(count == 0)
            System.out.println("Grandpa exists.");
        else {
            count--;
            for(int i = 1 ; i <= 7;i ++ ){
                CalabashBoy boy = new CalabashBoy();
                boys[i] = boy;
            }
            Line l = new Line();
            line = l;
        }
    }

    void rand_line() {
        line.dicing();
        for(int i = 1; i <= 7; i++) {
            int pos = boys[i].take_rand_position(line);
            line.sit(boys[i].ID, pos);
        }
    }

    void bubble_sort() {

        for(int i = 1; i < 7; i ++){
            for(int j = 1; j < 8-i; j++) {
                int id1 = line.id_at(j);
                int id2 = line.id_at(j+1);
                if(id1 > id2) {
                    line.leave(j);
                    line.leave(j+1);
                    boys[id1].move2(j+1);
                    boys[id2].move2(j);
                    line.sit(id1, j+1);
                    line.sit(id2, j);
                }
            }
        }
    }

    void quick_sort(int s, int r){
        if(s >= r)
            return;
        int pivot = s;
        int pivot_id = line.id_at(s);
        int p_id;

        for(int i = s+1; i <= r; i ++) {
            int id = line.id_at(i);
            if(id < pivot_id) {
                pivot++;
                p_id = line.id_at(pivot);
                //move i to pivot & increase pivot
                if(i != pivot) {
                    line.leave(pivot);
                    line.leave(i);
                    boys[id].move2(pivot);
                    boys[p_id].move2(i);
                    line.sit(id, pivot);
                    line.sit(p_id, i);
                }
            }
        }
        //put pivot_id in pivot
//        line.leave(pivot);
        if(pivot != s) {
            p_id = line.id_at(pivot);
            line.leave(s);
            line.leave(pivot);
            boys[pivot_id].move2(pivot);
            boys[p_id].move2(s);
            line.sit(pivot_id, pivot);
            line.sit(p_id, s);
        }
        quick_sort(s, pivot-1);
        quick_sort(pivot+1, r);
    }

    void check_line() {
        line.show_line();
    }

    void count_off(int key) {
        switch(key) {
            case 1:
                for(int i = 1; i <= 7; i++) {
                    boys[i].report_name();
                }
                System.out.println();
                break;
            case 2:
                for(int i = 1; i <= 7; i++) {
                    boys[i].report_color();
                }
                System.out.println();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args){
        Grandpa pa = new Grandpa();
        pa.rand_line();
        pa.bubble_sort();
        pa.count_off(1);
        pa.rand_line();
        pa.quick_sort(1,7);
        pa.count_off(2);
    }
}
