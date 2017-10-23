
public class Calabash{

    public static void main(String[] args){
        Huluwa[] hulubro = CreatSevenHuluwa();  // creat 葫芦娃
        Seat[] seats = CreatSevenSeat();  // creat 座位
        MakeQueue makequeue = new MakeQueue();
        makequeue.random_sort(hulubro, seats);  //任意排序
        makequeue.bubble_sort(seats);  //冒泡排序
        makequeue.random_sort(hulubro, seats);  //任意排序
        makequeue.quick_sort(seats);  //冒泡排序
    }

    //生成7个葫芦娃
    public static Huluwa[] CreatSevenHuluwa(){
        Huluwa[] Hulubro = new Huluwa[7];
        Hulubro[0] = new Huluwa(RANK.NO1.ordinal(), COLOR.RED.ordinal(), "老大", "红色");
        Hulubro[1] = new Huluwa(RANK.NO2.ordinal(), COLOR.ORANGE.ordinal(), "老二", "橙色");
        Hulubro[2] = new Huluwa(RANK.NO3.ordinal(), COLOR.YELLOW.ordinal(), "老三", "黄色");
        Hulubro[3] = new Huluwa(RANK.NO4.ordinal(), COLOR.GREEN.ordinal(), "老四", "绿色");
        Hulubro[4] = new Huluwa(RANK.NO5.ordinal(), COLOR.CYAN.ordinal(), "老五", "青色");
        Hulubro[5] = new Huluwa(RANK.NO6.ordinal(), COLOR.BLUE.ordinal(), "老六", "蓝色");
        Hulubro[6] = new Huluwa(RANK.NO7.ordinal(), COLOR.PURPLE.ordinal(), "老七", "紫色");
        return Hulubro;
    }

    //创造7个座位
    public static Seat[] CreatSevenSeat(){
        Seat[] seats = new Seat[7];
        int i;
        for(i=0; i<7; i++)
            seats[i] = new Seat(i);
        return seats;
    }
}