import java.awt.*;
import java.util.Random;

public class Huluwa {


    int level;
    String color;
    String name;
    int pos;
    int colorForSort;

    public static final int COLOR = 1;
    public static final int NAME = 2;
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
        pos = 0;
        colorForSort = newColorForSort;
    }


    public int getRandomNumber(){
        Random randomNumber = new Random();
        return randomNumber.nextInt(7) % (7);

    }

    public void swapPos(int startPos, int endPos)
    {
        System.out.println(name+":"+startPos+"->"+endPos);
        pos = endPos;
    }

    public void setPos(int newPos)
    {
        pos = newPos;
    }

    public void countOff(int caseChoose)
    {
        switch(caseChoose)
        {
            case NAME:System.out.println(name);break;
            case COLOR:System.out.println(color);break;
            default:return;
        }
    }

}
