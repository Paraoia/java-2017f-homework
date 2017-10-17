package HuLuBrother;

import static HuLuBrother.HuLuColor.*;

/**
 * Created by junkai.li on 2017/9/20.
 */

public class HuLuBaby {
    int id;
    HuLuColor color;
    String name;

    HuLuBaby(int i) {
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
}
