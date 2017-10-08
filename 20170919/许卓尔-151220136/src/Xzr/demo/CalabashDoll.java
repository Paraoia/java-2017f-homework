package Xzr.demo;

enum Color{
    RED(1),ORANGE(2),YELLOW(3),GREEN(4),CYAN(5),BLUE(6),PURPLE(7);

    private int pri;    // 规定颜色的优先级

    private Color(int _pri){
        this.pri = _pri;
    }
    public int getPri(){
        return pri;
    }
}

// 这是葫芦娃，他可以换位置的时候报数，告诉爷爷他的排行和颜色
public class CalabashDoll {
    private static int curNum=0;    // 葫芦娃现个数
    public final static int allNum = 7; // 葫芦娃总个数

    private int num;        // 葫芦娃各自序号
    private Color color;    // 葫芦娃的颜色
    private String name;
    CalabashDoll(){
        num = curNum = curNum%allNum+1;
        switch(num){
            case 1:color = Color.RED;name = "大娃";break;
            case 2:color = Color.ORANGE;name = "二娃";break;
            case 3:color = Color.YELLOW;name = "三娃";break;
            case 4:color = Color.GREEN;name = "四娃";break;
            case 5:color = Color.CYAN;name = "五娃";break;
            case 6:color = Color.BLUE;name = "六娃";break;
            case 7:color = Color.PURPLE;name = "七娃";break;
        }
    }

    public void changePos(int curPos,int toPos,boolean isHowl){
        if(isHowl)
            System.out.println(name+"："+(curPos+1)+"->"+(toPos+1));
    }

    public int getNum(){
        return num;
    }

    public Color getColor(){
        return color;
    }

    public void countOff(String countType) {
        if(countType=="name")
            System.out.print(name);
        else
            System.out.print(color.toString());
    }
}
