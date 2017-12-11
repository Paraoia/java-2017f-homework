import java.util.*;

enum COLOR{无色,红色,橙色,黄色,绿色,蓝色,靛色,紫色}

public class Huluwa {

    private int rank;
    private COLOR color;

    //初始化函数
    Huluwa(){
        this.rank=0;
        this.color=COLOR.无色;
    }

    Huluwa(int RANK){
        if(RANK<1||RANK>7){
            throw new IndexOutOfBoundsException("The rank is out of bound");
        }
        this.rank=RANK;
        this.color=COLOR.values()[RANK];
    }

    Huluwa(COLOR Color){
        this.color=Color;
        switch(Color){
            case 红色: this.rank=1;
            case 橙色: this.rank=2;
            case 黄色: this.rank=3;
            case 绿色: this.rank=4;
            case 蓝色: this.rank=5;
            case 靛色: this.rank=6;
            case 紫色: this.rank=7;
            default:throw new IndexOutOfBoundsException("The color is out of selection");
        }
    }

    int getRank(){
        return this.rank;
    }

    COLOR getColor(){
        return this.color;
    }

    //通过排行比较
    boolean CompareRank(Huluwa hlw){
        if(this.rank > hlw.getRank())
            return true;
        else
            return false;
    }

    //通过颜色比较
    boolean CompareColor(Huluwa hlw){
            return this.rank > hlw.getRank();
    }

    //说话
    String getColorString(){
        switch(this.color){
            case 红色: return "红色";
            case 橙色: return "橙色";
            case 黄色: return "黄色";
            case 绿色: return "绿色";
            case 蓝色: return "蓝色";
            case 靛色: return "靛色";
            case 紫色: return "紫色";
            default: throw new RuntimeException("The color is not found");
        }
    }

    String getRankString(){
        switch(this.rank){
            case 1: return "老大";
            case 2: return "老二";
            case 3: return "老三";
            case 4: return "老四";
            case 5: return "老五";
            case 6: return "老六";
            case 7: return "老七";
            default : throw new RuntimeException("The rank is not found");
        }
    }

    void HuluwaTalk(String str){
       System.out.println(str);
    }

}
