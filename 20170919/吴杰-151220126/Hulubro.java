/**
 * Created by jar on 2017/9/20.
 */
public class Hulubro {
    protected int rank;
    protected String colour;
    protected String name;

    public void Huluborn(int n) {
        this.rank = n;
        this.name = this.return_name(n);
        this.colour = this.return_colour(n);
    }

    private String return_name(int n) {
        switch (n) {
            case 1:
                return "老大";
            case 2:
                return "老二";
            case 3:
                return "老三";
            case 4:
                return "老四";
            case 5:
                return "老五";
            case 6:
                return "老六";
            case 7:
                return "老七";
            default:
                return "NULL";
        }
    }

    private String return_colour(int n) {
        switch (n) {
            case 1:
                return "红色";
            case 2:
                return "橙色";
            case 3:
                return "黄色";
            case 4:
                return "绿色";
            case 5:
                return "青色";
            case 6:
                return "蓝色";
            case 7:
                return "紫色";
            default:
                return "NULL";
        }
    }

    public void tell_name() {
        System.out.print(this.name);
    }//冒泡排序结束后报rank

    public void tell_colour() {
        System.out.printf(this.colour);
    }//2分法排序结合束后报颜色
}
