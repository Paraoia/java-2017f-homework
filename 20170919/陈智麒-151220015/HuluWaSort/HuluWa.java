package HuluWaSort;

enum COLOR{
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE;
}

public class HuluWa {

    private COLOR color;

    HuluWa(COLOR color){
        this.color = color;
    }

    public COLOR getColor(){
        return color;
    }

    public void sayOrderName() {
        String orderName = null;
        switch (color){
            case RED:
                orderName = "老大";break;
            case ORANGE:
                orderName = "老二";break;
            case YELLOW:
                orderName = "老三";break;
            case GREEN:
                orderName = "老四";break;
            case CYAN:
                orderName = "老五";break;
            case BLUE:
                orderName = "老六";break;
            case PURPLE:
                orderName = "老七";break;
            default:
                break;
        }
        System.out.print(orderName);
    }

    public void sayColorName() {
        String colorName = null;
        switch (color){
            case RED:
                colorName = "红色";break;
            case ORANGE:
                colorName = "橙色";break;
            case YELLOW:
                colorName = "黄色";break;
            case GREEN:
                colorName = "绿色";break;
            case CYAN:
                colorName = "青色";break;
            case BLUE:
                colorName = "蓝色";break;
            case PURPLE:
                colorName = "紫色";break;
            default:
                break;
        }
        System.out.print(colorName);
    }

    public void report(int h1, int h2){
        sayOrderName();
        System.out.print(":" + h1 + "->" + h2 + " ");
    }
}
