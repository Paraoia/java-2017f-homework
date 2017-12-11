import com.sun.istack.internal.localization.NullLocalizable;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Huluwa {
    private int name;
    private int color;

    Huluwa(int Name,int Color){
        name = Name;
        color = Color;
    }
    public void report(int place1,int place2){
        System.out.print(name+":"+place1+"->"+place2);
    }

    public int gname(){
        return name;
    }

    public int gcolor(){
        return color;
    }

    public String repName(){//报名字
        switch(name){
            case 1:return "老大";
            case 2:return "老二";
            case 3:return "老三";
            case 4:return "老四";
            case 5:return "老五";
            case 6:return "老六";
            case 7:return "老七";
            default:return null;
        }
    }

    public String repColor(){//报颜色
        switch (color){
            case 1:return "赤";
            case 2:return "橙";
            case 3:return "黄";
            case 4:return "绿";
            case 5:return "青";
            case 6:return "蓝";
            case 7:return "紫";
            default:return null;
        }
    }

    public void reportmove(int pos1,int pos2){//移动报数
        System.out.print(repName()+":"+pos1+"->"+pos2);
    }

}
