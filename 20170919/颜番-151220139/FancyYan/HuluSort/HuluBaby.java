package FancyYan.HuluSort;

/**
 * 此文件包含葫芦娃的类HuluBaby
 * 葫芦娃拥有排行这一个成员变量，可以报告自己的排行，颜色（字符串）
 * 当进行位置交换时，葫芦娃可以报告交换位置的信息（直接输出）
 */

public class HuluBaby {
    int rank;

    HuluBaby(int _rank){
        rank = _rank;
    }

    /**
     * 外部获取该葫芦娃的排行
     * @return 葫芦娃的排行值(int)
     */
    public int getRank(){
        return rank;
    }

    /**
     * 以字符形式报告葫芦娃的排行，没有输出
     * @return 葫芦娃的排行说明，如"大娃：1"形式的字符串
     */
    public String reportRank(){
        String output="";
        switch(rank){
            case 1: output="大娃"; break;
            case 2: output="二娃"; break;
            case 3: output="三娃"; break;
            case 4: output="四娃"; break;
            case 5: output="五娃"; break;
            case 6: output="六娃"; break;
            case 7: output="七娃"; break;
        }
        return output;
    }

    /**
     * 以字符串形式报告葫芦娃的颜色特征
     * @return 葫芦娃颜色字符串，如”红色“
     */
    public String reportColor(){
        String output="";
        switch(rank){
            case 1: output="红色"; break;
            case 2: output="橙色"; break;
            case 3: output="黄色"; break;
            case 4: output="绿色"; break;
            case 5: output="青色"; break;
            case 6: output="蓝色"; break;
            case 7: output="紫色"; break;
        }
        return output;
    }

    /**
     * 报告排序时的位置交换，以屏幕输出的方式
     * @param oldPos 原来的位置
     * @param newPos 交换之后的位置
     */
    public void reportExchangePos(int oldPos, int newPos){
        System.out.printf("%s: %d --> %d\n", reportRank(),oldPos, newPos);
    }

}
