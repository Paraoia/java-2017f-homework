/**
 * Created by tangruize on 17-9-20.
 */
public class Fuluwa {
    private int no;
    private static String names[] = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
    private static String colors[] = {"赤", "橙", "黄", "绿", "青", "蓝", "紫"};
    private static boolean born[] = {false, false, false, false, false, false, false};
    private static int unBorn = 7;
    private static String getName(int n) {
        return names[n];
    }
    private static String getColor(int n) {
        return colors[n];
    }
    private static void setBorn(int n) {
        if (unBorn == 0) return;
        born[n] = true;
        --unBorn;
    }
    private static void unsetBorn(int n) {
        if (unBorn == 7) return;
        born[n] = false;
        ++unBorn;
    }
    private static boolean isBorn(int n) {
        return born[n];
    }
    private static boolean isAllBorn() {
        return unBorn == 0;
    }
    Fuluwa() {
        if (isAllBorn()) {
            System.out.println("藤蔓上没有葫芦啦！");
            System.exit(1);
        }
        while (true) {
            no = (int)(Math.random() * 7);
            if (!isBorn(no)) {
                break;
            }
        }
        Fuluwa.setBorn(no);
    }
    public void goHome() {
        Fuluwa.unsetBorn(no);
    }
    public int getNo() {
        return no;
    }
    public String getName() {
        return Fuluwa.getName(no);
    }
    public String getColor() {
        return Fuluwa.getColor(no);
    }
}