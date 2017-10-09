package gourd_brothers;

public class Boy {
    private final String []colour = new String[]{"赤", "橙", "黄", "绿", "青", "蓝", "紫"};

    private final String []name = new String[]{"老大", "老二", "老三", "老四", "老五", "老六", "老七"};

    private int order;

    Boy(int n) {
        order = n;
    }

    public void ReportOrder() {
        System.out.print(name[order - 1]);
    }

    public void ReportColour() {
        System.out.print(colour[order - 1]);
    }

    public boolean Compare(Boy guy) {
        return order > guy.order;
    }

}
