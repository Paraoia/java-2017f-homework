public class HuluBoy {
    private   String name;
    private COLOR color;
    private   int rank;

    HuluBoy(String name,COLOR color,int rank){
        this.name=name;
        this.color=color;
        this.rank=rank;
    }

    public String getname(){
        return this.name;
    }

    public String toColorString(COLOR color) {
               switch (color) {
                   case CHI:
                       return "红色";
                   case CHENG:
                       return "橙色";
                   case HUANG:
                       return "黄色";
                   case LV:
                       return "绿色";
                   case QING:
                       return "青色";
                   case LAN:
                       return "蓝色";
                   case ZI:
                       return "紫色";
                   default:
                       throw new RuntimeException("No such Color");
               }
    }
    public void getcolor(){
        System.out.print(toColorString(this.color)+" ");
    }

    public int getrank(){
        return rank;
    }

    public void swap(HuluBoy[] Boys,int a,int b){ ;
        HuluBoy t=Boys[a];
        Boys[a]=Boys[b];
        Boys[b]=t;
    }

    public void printExchange(HuluBoy[]Boys,int a,int b){
        if(a==b)return;
        System.out.print(Boys[a].getname());
        System.out.print((a+1)+"->"+(b+1)+"  ");
        System.out.print(Boys[b].getname());
        System.out.print((b+1)+"->"+(a+1)+"  ");
        swap(Boys,a,b);
    }

}
enum COLOR{CHI,CHENG,HUANG,LV,QING,LAN,ZI}