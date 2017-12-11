
enum COLORS{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,VIOLET};

public class brothers {
    String name;
    COLORS color;

    public brothers(String na,COLORS col){
        name=na;
        color=col;
    }

    public int get_num(){
        switch(name){
            case("老大"):return 1;
            case("老二"):return 2;
            case("老三"):return 3;
            case("老四"):return 4;
            case("老五"):return 5;
            case("老六"):return 6;
            case("老七"):return 7;
            default:return -1;
        }
    }

    public String get_name(){
        return name;
    }

    public String get_color(){
        switch(name) {
            case ("老大"):
                return "红色";
            case ("老二"):
                return "橙色";
            case ("老三"):
                return "黄色";
            case ("老四"):
                return "绿色";
            case ("老五"):
                return "青色";
            case ("老六"):
                return "蓝色";
            case ("老七"):
                return "紫色";
            default:
                return " ";
        }

    }

}
