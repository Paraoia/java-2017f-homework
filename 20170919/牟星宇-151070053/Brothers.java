import java.util.Random;

class Brothers {
    Brother[] brothers; //7个葫芦娃（brother）构成数组


    void initialize(){ //按rank顺序初始化数组
        brothers = new Brother[7];
        brothers[0] = new Brother(1, "大娃", 1, "红色");
        brothers[1] = new Brother(2, "二娃", 2, "橙色");
        brothers[2] = new Brother(3, "三娃", 3, "黄色");
        brothers[3] = new Brother(4, "四娃", 4, "绿色");
        brothers[4] = new Brother(5, "五娃", 5, "青色");
        brothers[5] = new Brother(6, "六娃", 6, "蓝色");
        brothers[6] = new Brother(7, "七娃", 7, "紫色");
    }

    void tell_name(){ //按数组顺序报名称
        for(int i = 0; i < 7; i++){
            brothers[i].tell_name();
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    void tell_color(){ //按数组顺序报颜色
        for(int i = 0; i < 7; i++){
            brothers[i].tell_color();
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    void swap(int i, int j){
        Brother temp;
        temp = brothers[i];
        brothers[i] = brothers[j];
        brothers[j] = temp;
    }

    /* 葫芦娃重新站队得到新顺序的数组 */
    void new_sequence(){
        Random random = new Random();
        System.out.print("站队中……");
        for(int i = 0; i < 7; i++){
            int j = random.nextInt(7);
            swap(i, j);
        }
        System.out.print("完成\n");
    }

    /* 对排行（rank）冒泡排序 */
    void bubble_sort_for_rank(){
        for (int i = 1; i < 7; i++) {
            for(int j = 0; j < 7 - i; j++) {
                if(brothers[j].rank > brothers[j + 1].rank){
                    brothers[j].tell_name();
                    System.out.print(":" + j + "->" + (j + 1) + " ");
                    brothers[j + 1].tell_name();
                    System.out.print(":" + (j + 1) + "->" + j + "\n");
                    swap(j, j+1);
                }
            }
        }
    }

    /* 对颜色（color）快速排序 */
    int partition(int low, int high) {
        Brother record = brothers[low];
        int initial_pos = low;
        int pivot = record.color_rank;
        while(low < high){
            while(low < high && brothers[high].color_rank >= pivot) --high;
            if(low != high) {
                System.out.print(brothers[high].name + ":" + high + "->" + low + '\n');
            }
            brothers[low] = brothers[high];
            while(low < high && brothers[low].color_rank <= pivot) ++low;
            if(low != high) {
                System.out.print(brothers[low].name + ":" + low + "->" + high + '\n');
            }
            brothers[high] = brothers[low];
        }
        if(initial_pos != low) {
            System.out.print(record.name + ":" + initial_pos + "->" + low + '\n');
        }
        brothers[low] = record;
        return low;
    }
    void qsort_for_color(int low, int high) {
        if(low < high) {
            int pivotloc = partition(low, high);
            qsort_for_color(low, pivotloc - 1);
            qsort_for_color(pivotloc + 1, high);
        }
    }

    public static void main(String[] args){
        Brothers bros = new Brothers();
        bros.initialize();

        //过程1
        bros.new_sequence();
        //bros.tell_name();
        bros.bubble_sort_for_rank();
        bros.tell_name();
        //过程2
        bros.new_sequence();
        //bros.tell_color();
        bros.qsort_for_color(0,6);
        bros.tell_color();
    }
}
