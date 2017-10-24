public class Huluwa {

    public String name;
    public COLOR color;
    public int seniority;

    public void getseniority(){
        switch (seniority){
            case 0:System.out.println("老大"); break;
            case 1:System.out.println("老二"); break;
            case 2:System.out.println("老三"); break;
            case 3:System.out.println("老四"); break;
            case 4:System.out.println("老五"); break;
            case 5:System.out.println("老六"); break;
            case 6:System.out.println("老七"); break;
        }
    }

    public void getcolor(){
        switch(color){
            case CHI:System.out.println("红色"); break;
            case CHENG:System.out.println("橙色"); break;
            case HUANG:System.out.println("黄色"); break;
            case LV:System.out.println("绿色"); break;
            case QING:System.out.println("青色"); break;
            case LAN:System.out.println("蓝色"); break;
            case ZI:System.out.println("紫色"); break;
        }
    }

    public void jumpto(Position[] positions,int orig,int num)
    {

        positions[num].holder=positions[orig].holder;
        positions[orig].holder=null;

        switch (seniority){
            case 0:System.out.print("|老大"); break;
            case 1:System.out.print("|老二"); break;
            case 2:System.out.print("|老三"); break;
            case 3:System.out.print("|老四"); break;
            case 4:System.out.print("|老五"); break;
            case 5:System.out.print("|老六"); break;
            case 6:System.out.print("|老七"); break;
        }

        System.out.print("从位置"+orig+"跳到位置"+num);

    }
}

enum COLOR{
    CHI,CHENG,HUANG,LV,QING,LAN,ZI
}