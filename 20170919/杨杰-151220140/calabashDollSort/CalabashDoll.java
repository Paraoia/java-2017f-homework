package calabashDollSort;

/*
* 此文件包含葫芦娃类CalabashDoll
* CalabashDoll类含有葫芦娃的排行这一成员变量
* CalabashDoll类可以根据葫芦娃的排行输出葫芦娃的排行、颜色信息
* 当葫芦娃调换顺序时，CalabashDoll类会输出位置变化
*/

public class CalabashDoll {
    private int number;

    CalabashDoll(int _number){
        number = _number;
    }

    public void SayNumber(){
        switch(number) {
            case 1: System.out.print("大娃 "); break;
            case 2: System.out.print("二娃 "); break;
            case 3: System.out.print("三娃 "); break;
            case 4: System.out.print("四娃 "); break;
            case 5: System.out.print("五娃 "); break;
            case 6: System.out.print("六娃 "); break;
            case 7: System.out.print("七娃 "); break;
        }
    }

    public void SayColor(){
        switch(number){
            case 1: System.out.print("红色 "); break;
            case 2: System.out.print("橙色 "); break;
            case 3: System.out.print("黄色 "); break;
            case 4: System.out.print("绿色 "); break;
            case 5: System.out.print("青色 "); break;
            case 6: System.out.print("蓝色 "); break;
            case 7: System.out.print("紫色 "); break;
        }
    }

    public void SayPosChange(int oldPos,int newPos){
        SayNumber();
        SayColor();
        System.out.println(oldPos + "->" + newPos);
    }

    public int getNumber(){
        return number;
    }
}
