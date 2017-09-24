public class HuLuWa {
//属性：颜色和排行
    HuLuWaColour Color;
    int Rank;

    //构造器文字
    HuLuWa(String str){
        //Color=color;
        switch (str){
            case "红":
                Color=HuLuWaColour.RED;
                Rank=1;
                break;
            case "橙":
                Color=HuLuWaColour.ORANGE;
                Rank=2;
                break;
            case "黄":
                Color=HuLuWaColour.YELLOW;
                Rank=3;
                break;
            case "绿":
                Color=HuLuWaColour.GREEN;
                Rank=4;
                break;
            case "青":
                Color=HuLuWaColour.CYAN;
                Rank=5;
                break;
            case "蓝":
                Color=HuLuWaColour.BLUE;
                Rank=6;
                break;
            case "紫":
                Color=HuLuWaColour.PURPLE;
                Rank=7;
                break;
        }
    }
    //构造器颜色
    HuLuWa(HuLuWaColour color){
        Color=color;
        switch (Color){
            case RED:
                Rank=1;
                break;
            case ORANGE:
                Rank=2;
                break;
            case YELLOW:
                Rank=3;
                break;
            case GREEN:
                Rank=4;
                break;
            case CYAN:
                Rank=5;
                break;
            case BLUE:
                Rank=6;
                break;
            case PURPLE:
                Rank=7;
                break;
        }
    }
    //构造器排行
    HuLuWa(int rank){
        Rank=rank;
        switch (Rank){
            case 1:
                Color=HuLuWaColour.RED;
                break;
            case 2:
                Color=HuLuWaColour.ORANGE;
                break;
            case 3:
                Color=HuLuWaColour.YELLOW;
                break;
            case 4:
                Color=HuLuWaColour.GREEN;
                break;
            case 5:
                Color=HuLuWaColour.CYAN;
                break;
            case 6:
                Color=HuLuWaColour.BLUE;
                break;
            case 7:
                Color=HuLuWaColour.PURPLE;
                break;
        }
    }

}

