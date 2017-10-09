package huluwa;

import java.util.Random;

public class new_huluwa {

    enum Color{red,orange,yellow,green,blue,ding,purple};

    String Name[]={"老大","老二","老三","老四","老五","老六","老七"};

    public String name;
    public int rank;
    public Color color;
    public void Set_new_huluwa(int index)
    {
            rank=index;
            name=Name[rank];
            color=Color.values()[rank];
    }


}
