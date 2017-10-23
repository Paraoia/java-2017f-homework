package Huluwa;
enum Color{RED,ORANGE,YELLOW,GREEN,CHING,BLUE,PURPLE}
public class HuLuWa {
    String name;
    Color color;
    int rank;

    public String rtnName(){
        return name;
    }
    public Color rtnColor(){
        return color;
    }
    public int rtnRank(){
        return rank;
    }

    public HuLuWa(int rank) {
        switch (rank) {
            case 1:
                name = "老大";
                color = Color.RED;
                this.rank = 1;
                break;
            case 2:
                name = "老二";
                color = Color.ORANGE;
                this.rank = 2;
                break;
            case 3:
                name = "老三";
                color = Color.YELLOW;
                this.rank = 3;
                break;
            case 4:
                name = "老四";
                color = Color.GREEN;
                this.rank = 4;
                break;
            case 5:
                name = "老五";
                color = Color.CHING;
                this.rank = 5;
                break;
            case 6:
                name = "老六";
                color = Color.BLUE;
                this.rank = 6;
                break;
            case 7:
                name = "老七";
                color = Color.PURPLE;
                this.rank = 7;
                break;
        }
    }
    public void tellMove(int from,int to){
        System.out.println(name+":"+String.valueOf(from)+"->"+String.valueOf(to));
    }
}