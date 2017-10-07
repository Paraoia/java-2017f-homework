enum COLOR {
    CHI, CHENG, HUANG, LV, QING, LAN, ZI;
}

enum NAME {
    老大, 老二, 老三, 老四, 老五, 老六, 老七;
}

enum COLORNAME {
    红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色;
}

public class Huluwa {
    private String name, colorStr;
    private COLOR color;

    Huluwa(int x) {
        color = COLOR.values()[x];
        name = NAME.values()[x].toString();
        colorStr = COLORNAME.values()[x].toString();
    }

    public String getColorStr() {
        return colorStr;
    }

    // 以下两个返回 int 值是为了方便排序时比较大小,
    // 使用了 enum 方法
    public int getColor() {
        return color.ordinal();
    }
    public int getName() {
        return NAME.valueOf(name).ordinal();
    }

    // 葫芦娃的报数
    void exclaim_name() {
        System.out.print(name + ' ');
    }
    void exclaim_color() {
        System.out.print(getColorStr() + ' ');
    }

    // 葫芦娃从位置 src 跳到 dst, 报告交换动作
    public void hop(int src, int dst) {
        exclaim_name();
        System.out.println(":" + src + "->" + dst);
    }
}
