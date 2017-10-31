/**
 * Created by admin on 2017/9/22.
 */
enum Color{
    RED,ORANGE,YELLOW,GREEN,BLUE,INDIGO,VIOLET
}

public class brother {
    int no;
    Color color;

    public brother(int ex_no,Color ex_color) {
        no = ex_no;
        color = ex_color;
    }

    public int getNo() {
        return no;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        if(no == 1)
            return "老大";
        else if(no == 2)
            return "老二";
        else if(no == 3)
            return "老三";
        else if(no == 4)
            return "老四";
        else if(no == 5)
            return "老五";
        else if(no == 6)
            return "老六";
        else if(no == 7)
            return "老七";
        return "";
    }

    public String getColorName() {
        if(no == 1)
            return "红色";
        else if(no == 2)
            return "橙色";
        else if(no == 3)
            return "黄色";
        else if(no == 4)
            return "绿色";
        else if(no == 5)
            return "青色";
        else if(no == 6)
            return "蓝色";
        else if(no == 7)
            return "紫色";
        return "";
    }

}
