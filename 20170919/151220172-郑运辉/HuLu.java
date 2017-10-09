public class HuLu {
    private static String[] ColorArr = {"Red", "Orange", "Yellow", "Green", "Cyan", "Blue", "Purple"};
    private static String[] NumArr={"老大","老二","老三","老四","老五","老六","老七"};

    private int Num;    //数字


    public static final int TOTAL = 7;    //葫芦娃的总数

    //设定葫芦娃的位置
    public static void setPostion(HuLu[] h, int[] Position) {
        for (int count = 0; count < HuLu.TOTAL; count++)
            h[Position[count]] = new HuLu(count + 1, ColorArr[count]);
    }
    private String Color;   //颜色

    //报数
    public static void HuLuHowlColor(HuLu h[]) {
        System.out.println("报数:");
        for (int count = 0; count < 7; count++)
            System.out.println(h[count].getColor());
    }

    public static void HuLuHowlNum(HuLu h[]){
        System.out.println("报数:");
        for (int count = 0; count < 7; count++)
            System.out.println(NumArr[h[count].getNum()-1]);
    }

    public HuLu(int num, String color) {
        this.Num = num;
        this.Color = color;
    }

    public int getNum() {
        return Num;
    }

    public String getColor() {
        return Color;
    }

    public void ChangePosition(int Before, int After) {
        System.out.println(NumArr[Num-1] + ":" + Before + "->" + After);
    }
}