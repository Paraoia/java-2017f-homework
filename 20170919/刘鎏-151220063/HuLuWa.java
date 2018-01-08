public class HuLuWa {
    public color Color;//颜色
    public ranklist Ranklist;//排名

    public static void talk(HuLuWa bro, int from, int to, boolean mode){ //变换位置时哔哔
        if(mode == true) {
            System.out.print(bro.Ranklist);
            System.out.print(':');
            System.out.println(Integer.toString(from) + "->" + Integer.toString(to));
        }
        else if(mode == false) {
            System.out.print(bro.Color);
            System.out.print(':');
            System.out.println(Integer.toString(from) + "->" + Integer.toString(to));
        }
    }
}

enum color{
    红娃, 橙娃, 黄娃, 绿娃, 青娃, 蓝娃, 紫娃;
    public static color valueOfcolor(int value) {
        switch (value) {
            case 0:return color.红娃;
            case 1:return color.橙娃;
            case 2:return color.黄娃;
            case 3:return color.绿娃;
            case 4:return color.青娃;
            case 5:return color.蓝娃;
            case 6:return color.紫娃;
            default: return null;
        }
    }
}

enum ranklist{
    老大, 老二, 老三, 老四, 老五, 老六, 老七;
    public static ranklist valueOfrank(int value) {
        switch (value) {
            case 0:return ranklist.老大;
            case 1:return ranklist.老二;
            case 2:return ranklist.老三;
            case 3:return ranklist.老四;
            case 4:return ranklist.老五;
            case 5:return ranklist.老六;
            case 6:return ranklist.老七;
            default: return null;
        }
    }
}