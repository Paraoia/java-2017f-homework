import java.util.*;

enum Color { RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE } // 葫芦娃颜色

public class Huluwa {
    private Color color;
    private int rank;

    public Huluwa(int rank) {
        if (rank < 1 || rank > 7) 
            throw new RuntimeException("Rank out of bound");
        this.rank = rank;
        this.color = Color.values()[rank - 1];
    }

    public int getRank() {
        return rank;
    }

    public boolean lessThan(Huluwa b) {
        return rank < b.rank;
    }

    public void tellRank() {
        System.out.println(toRankString());
    }

    public void tellColor() {
        System.out.println(toColorString());
    }

    public String toColorString() {
        switch (this.color) {
            case RED:    return "红色";
            case ORANGE: return "橙色";
            case YELLOW: return "黄色";
            case GREEN:  return "绿色";
            case CYAN:   return "青色";
            case BLUE:   return "蓝色";
            case PURPLE: return "紫色";
            default: throw new RuntimeException("No such Color");
        }
    }

    public String toRankString() {
        switch (this.rank) {
            case 1: return "老大";
            case 2: return "老二";
            case 3: return "老三";
            case 4: return "老四";
            case 5: return "老五";
            case 6: return "老六";
            case 7: return "老七";
            default: throw new RuntimeException("No such Rank");
        }
    }

    public String toString() {
        return toRankString() + "(" + toColorString() + ")";
    }
}