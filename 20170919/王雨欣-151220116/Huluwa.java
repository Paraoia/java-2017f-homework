enum COLOR {RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE }; //葫芦娃颜色
enum RANK { NO1, NO2, NO3, NO4, NO5, NO6, NO7 };  //葫芦娃辈分

//葫芦娃类
public class Huluwa {
    int rank;  // 葫芦娃辈分排行
    int color;  // 葫芦娃颜色
    String rank_name;  //葫芦娃辈分名称
    String color_name;  //葫芦娃颜色名称
    Huluwa(int r, int c, String rname, String cname)  //构造函数初始化
    {
        rank = r;
        color = c;
        rank_name = rname;
        color_name = cname;
    }
}
