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
    private int pos;        // 葫芦娃当前位置

    CalabashDoll(){
        num = curNum = curNum%allNum+1;
        pos = num;
        switch(num){
            case 1:color = Color.RED;break;
            case 2:color = Color.ORANGE;break;
            case 3:color = Color.YELLOW;break;
            case 4:color = Color.GREEN;break;
            case 5:color = Color.CYAN;break;
            case 6:color = Color.BLUE;break;
            case 7:color = Color.PURPLE;break;
        }
    }

    public void changePos(int toPos,boolean isHowl){
        if(isHowl)
            System.out.println(Name()+"："+pos+"->"+(toPos+1));
        pos = toPos+1;
    }

    public int getNum(){
        return num;
    }

    public Color getColor(){
        return color;
    }

    public String Name(){
        String name="";
        switch (num){
            case 1:name = "老大";break;
            case 2:name = "老二";break;
            case 3:name = "老三";break;
            case 4:name = "老四";break;
            case 5:name = "老五";break;
            case 6:name = "老六";break;
            case 7:name = "老七";break;
        }
        return name;
    }
}
