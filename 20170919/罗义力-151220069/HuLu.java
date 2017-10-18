package lyl.java.huluwa;

/*这是一只小葫芦*/
public class HuLu {
    private int number;     //排行
    private int color;      //颜色
    static final int COLORMAX = 7;
    static final int NUMBERMAX = 7;
    static final String[] colorMap = {"未定义", "红色", "橙色", "黄色", "绿色", "青色","蓝色", "紫色"};
    static final String[] numberMap = {"未定义", "大娃", "二娃", "三娃", "四娃", "五娃", "六娃", "七娃"};

    //默认构造函数
    HuLu() {
        number = 0;
        color = 0;
    }

    //自定义构造函数
    HuLu(int x, int y) {
        if(x <= NUMBERMAX && x >= 1 && y <= COLORMAX && y >= 1) {
            number = x;
            color = y;
        }
        else
            System.out.println("Error: invalid args");
    }

    HuLu(String n, String c) {
        int i;

        for(i=1; i < NUMBERMAX && !n.equals(numberMap[i]); i++);
        if(i <= NUMBERMAX)   number = i;
        else number = 0;

        for(i=1; i < COLORMAX && !c.equals(colorMap[i]); i++) ;
        if(i <= COLORMAX)   color = i;
        else color = 0;
    }

    //两个小葫芦比较排行
    int compareNumberTo(HuLu x) {
        return (number - x.number);
    }

    //两个小葫芦比较颜色
    int compareColorTo(HuLu x) {
        return (color - x.color);
    }

    //报数
    void reportNumber() {
        System.out.print(numberMap[number]);
    }

    //报颜色
    void reportColor() {
        System.out.print(colorMap[color]);
    }

}
