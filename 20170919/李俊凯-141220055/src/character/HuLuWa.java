package character;

import static character.COLOR.*;

/**
 * Created by ljkgo_000 on 2017/10/2.
 */

public class HuLuWa {

    int id;
    COLOR color;
    String name;

    public HuLuWa(int i) {
        id = i;
        switch (i) {
            case 1:
                color = red;
                name = "老大";
                break;
            case 2:
                color = orange;
                name = "老二";
                break;
            case 3:
                color = yellow;
                name = "老三";
                break;
            case 4:
                color = green;
                name = "老四";
                break;
            case 5:
                color = cyan;
                name = "老五";
                break;
            case 6:
                color = blue;
                name = "老六";
                break;
            case 7:
                color = purple;
                name = "老七";
                break;
            default:
                color = white;
                name = "老几";
        }
    }

    public int getId() {
        return id;
    }

    public COLOR getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void selfIntroduction() {
        System.out.println("我是葫芦七兄弟中的" + name);
    }
}
