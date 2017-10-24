public class HuLuWa {
    //名字
    private String name;
    //颜色
    private COLOR color;
    //排行
    private int seniority;

    //构建葫芦娃
    public HuLuWa(int rank){
        seniority=rank;
        switch (rank){
            case 1:
                name="老大";
                color=COLOR.RED;
                break;
            case 2:
                name="老二";
                color=COLOR.ORANGE;
                break;
            case 3:
                name="老三";
                color=COLOR.YELLOW;
                break;
            case 4:
                name="老四";
                color=COLOR.GREEN;
                break;
            case 5:
                name="老五";
                color=COLOR.CYAN;
                break;
            case 6:
                name="老六";
                color=COLOR.BLUE;
                break;
            case 7:
                name="老七";
                color=COLOR.PURPLE;
                break;
            default:
                System.out.println("失败");
                break;
        }
    }
    //葫芦娃会说话
    //报自己的名字
    public void SayName(){
        System.out.print(name);
    }
    //报自己的颜色
    public void SayColor(){
        System.out.print(color);
    }
    //报自己是如何移动
    public void SayMovement(int src,int des){
        if(src!=des)
        System.out.println(name+":"+src+"->"+des);
    }

    //葫芦娃知道自己的排行
    public int Seniority(){
        return seniority;
    }

    //葫芦娃会移动
    public void Move(int src,int des){
        /*TODO*/
        SayMovement(src,des);
    }
}

enum COLOR {
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}