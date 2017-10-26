enum EColor {
    red,orange,yellow,green,cyan,blue,purple
}
enum ERank {
    one,two,three,four,five,six,seven
}
public class Huluwa {
    private EColor color;
    private ERank rank;
    private int position; /* ranging from 1 to 7*/

    public Huluwa(EColor color,ERank rank,int position){
        this.color=color;
        this.rank=rank;
        this.position=position;
    }
    public ERank getRank(){
        return this.rank;
    }
    public EColor getColor(){
        return this.color;
    }
    public void changePosition(int p){
        this.position=p;
    }
    public int getPosition(){
        return this.position;
    }
    public void reportRank(){
        switch (rank){
            case one:
                System.out.println("老大！");break;
            case two:
                System.out.println("老二！");break;
            case three:
                System.out.println("老三！");break;
            case four:
                System.out.println("老四！");break;
            case five:
                System.out.println("老五！");break;
            case six:
                System.out.println("老六！");break;
            case seven:
                System.out.println("老七！");
        }
    }
    public void reportColor(){
        switch (color){
            case red:
                System.out.println("红色！");break;
            case orange:
                System.out.println("橙色！");break;
            case yellow:
                System.out.println("黄色！");break;
            case green:
                System.out.println("绿色！");break;
            case cyan:
                System.out.println("青色！");break;
            case blue:
                System.out.println("蓝色！");break;
            case purple:
                System.out.println("紫色！");
        }
    }
    public void reportSwitch(Huluwa objToSwitch){
        System.out.println(position+" -> "+objToSwitch.getPosition());
    }
}


