package Homework2;

enum Color{RED, ORIGIN, YELLOW, GREEN, CYAN, BLUE, PURPLE};
enum Rank{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN};

public class Calabash {
    private static String[] rankArray = {"老大","老二", "老三", "老四", "老五", "老六", "老七"};
    private static String[] colorArray = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
    private Rank rank;
    private Color color;

    /*初始化*/
    public Calabash(int rank){
        this.rank = Rank.values()[rank];
        this.color = Color.values()[rank];
    }
    /*报告排行*/
    public String reportRank() {
        return rankArray[rank.ordinal()];
    }
    /*报告颜色*/
    public String reportColor(){
        return colorArray[color.ordinal()];
    }
    /*报告位置交换*/
    public String reportExchange(int src, int dst){
        return (rankArray[rank.ordinal()] + ": " + src + "->" + dst);
    }
    /*排行比较*/
    public boolean rankLessThan(Calabash x){
        return rank.ordinal() < x.rank.ordinal();
    }
    /*颜色比较*/
    public boolean colorLessThan(Calabash x){
        return color.ordinal() < x.color.ordinal();
    }

}
