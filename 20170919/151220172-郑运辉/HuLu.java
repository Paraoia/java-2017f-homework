public class HuLu {
    private int Num;
    private String Color;
    private static String[] ColorArr = {"Red", "Orange", "Yellow", "Green", "Cyan", "Blue", "Purple"};

    public static final int Sum = 7;    //葫芦娃的总数

    //设定葫芦娃的位置
    public static void setPostion(HuLu[] h, int[] Position) {
        for (int count = 0; count < HuLu.Sum; count++)
            h[Position[count]] = new HuLu(count + 1, ColorArr[count]);
    }

    //报数
    public static void HuLuprint(HuLu h[]) {
        System.out.println("报数:");
        for (int count = 0; count < 7; count++)
            System.out.println("Num:" + h[count].getNum() + "\t Color:" + h[count].getColor());
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
        System.out.println("老" + Num + ":" + Before + "->" + After);
    }
}
