//import java.awt.*;
import java.util.Random;

public class Huluwa {


    private int level;
    private int colorForSort;
    private String color;
    private String name;


    public static final int COLOR = 1;
    public static final int NAME = 2;
    public static final int LEVEL = 3;

    public static final int RED = 1;
    public static final int ORANGE = 2;
    public static final int YELLOW = 3;
    public static final int GREEN = 4;
    public static final int QING = 5;
    public static final int BLUE = 6;
    public static final int PURPLE = 7;

    public Huluwa(int newLevel,String newName,String newColor,int newColorForSort)
    {

        level = newLevel;
        color = newColor;
        name = newName;
        colorForSort = newColorForSort;
    }


    public int getRandomNumber(int range){
        //根据给定的范围，随机产生一个位置

        Random randomNumber = new Random();
        return randomNumber.nextInt(range) % (range);

    }

    public void talkWhenSwap(int startPos, int endPos)
    {
        //换位置时说话
        System.out.println(name+":"+startPos+"->"+endPos);
    }

    public void countOff(int caseChoose)
    {   //根据类型报出自己的一些属性
        switch(caseChoose)
        {
            case NAME:System.out.println(name);break;
            case COLOR:System.out.println(color);break;
            default:return;
        }
    }

    public int GetValue(int type)
    {   //根据所需类型说出自己的属性
        switch(type) {
            case COLOR:
                return colorForSort;
            case LEVEL:
                return level;
            default:
                break;
        }

        return 0;
    }
}
