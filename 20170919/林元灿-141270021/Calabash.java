
public class Calabash {
    private Name name;
    private Color color;

    Calabash(Color color, Name name) {
        this.color = color;
        this.name = name;
    }

    public String sayName(){
    	return name.name();
    }

    public String sayColor(){
        return color.name();
    }

    public int getnameID(){
        return name.ordinal();
    }

    public int getcolorID(){
        return color.ordinal();
    }

    public static void hop(Calabash[] holders,int i,int j,int flag/*0:report change, other:no report*/){
        if (flag == 0) System.out.println(holders[i].sayName() + ":" + i + ">" + j);
        Calabash temp = holders[i];
        holders[i] = holders[j];
        holders[j] = temp;
    }

    @Override
    public String toString() {
        return name.name();
    }
}

enum Color {
    红色, 橙色, 黄色, 绿色, 青色, 蓝色, 紫色;
};

enum Name {
    老大, 老二, 老三, 老四, 老五, 老六, 老七;
}

