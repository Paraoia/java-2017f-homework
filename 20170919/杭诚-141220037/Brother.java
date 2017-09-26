/**
 * Created by joker on 17-9-26.
 */
public class Brother {
    private int num;
    Brother(int number){
        num = number;
    }
    public int getNum(){
        return num;
    }
    public String getColor(){
        String color = "";
        switch (num){
            case 1:color = "红色";break;
            case 2:color = "橙色";break;
            case 3:color = "黄色";break;
            case 4:color = "绿色";break;
            case 5:color = "青色";break;
            case 6:color = "蓝色";break;
            case 7:color = "紫色";break;
        }
        return color;
    }

    public String getName(){
        String name = "";
        switch(num){
            case 1:name = "大娃";break;
            case 2:name = "二娃";break;
            case 3:name = "三娃";break;
            case 4:name = "四娃";break;
            case 5:name = "五娃";break;
            case 6:name = "六娃";break;
            case 7:name = "七娃";break;
        }
        return name;
    }
}
