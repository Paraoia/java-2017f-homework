
public class huluwa{
    //葫芦娃按次序的年龄、颜色
    static private String ageSequence[] = {"老大","老二","老三","老四","老五","老六","老七"};
    static private String color[] = {"赤","橙","黄","绿","青","蓝","紫"};

    static public void printAgeSequence(int i){
        //打印葫芦娃的年龄
        System.out.printf("%s",ageSequence[i]);
    }
    static public void printColor(int i){
        //打印葫芦娃的颜色
        System.out.printf("%s",color[i]);
    }
}
