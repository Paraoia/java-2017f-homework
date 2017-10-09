public class CalabashWorld {
    Brother[] brothers;//葫芦娃兄弟数列
    Stage stage;//舞台

    public CalabashWorld(){
        brothers = new Brother[7];
        brothers[0] = new Brother(1, "大娃", 1, "红色");
        brothers[1] = new Brother(2, "二娃", 2, "橙色");
        brothers[2] = new Brother(3, "三娃", 3, "黄色");
        brothers[3] = new Brother(4, "四娃", 4, "绿色");
        brothers[4] = new Brother(5, "五娃", 5, "青色");
        brothers[5] = new Brother(6, "六娃", 6, "蓝色");
        brothers[6] = new Brother(7, "七娃", 7, "紫色");
        stage = new Stage();
    }
    private void refresh_brother(){
        for(int i = 0; i < brothers.length; i++){
            brothers[i].reset_pos();
        }
    }
    public void world_start(){
        //葫芦娃进场
        stage.enqueue(brothers);
        //冒泡排序
        System.out.print("冒泡排序\n");
        stage.bubble_sort_for_rank();
        stage.tell_names();
        //舞台重组
        System.out.print("舞台重组\n");
        this.refresh_brother();
        stage.refresh_queue();
        stage.enqueue(brothers);
        //快速排序
        System.out.print("快速排序\n");
        stage.qsort_for_color(1,7);
        stage.tell_colors();
    }
    public static void main(String[] args){
        CalabashWorld world = new CalabashWorld();
        world.world_start();
    }
}
