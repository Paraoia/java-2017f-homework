/**
 * Created by Yuyang Wei on 2017/10/10.
 */
enum COLOR{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE}
//enum ORDER{老大,老二,老三,老四,老五,老六,老七}
public class HULUWA {
    private String name;
    private COLOR color;
    private int order;
    //private Position position;

    public COLOR getColor() {
        return color;
    }
    public int getOrder(){
        return order;
    }

    public String getName(){
        return name;
    }

    //@Override
    /*public Position getPosition() {
        return position;
    }*/

    public void setName(String name){
        this.name=name;
    }

    public void setColor(COLOR color){
        this.color=color;
    }

    public void setOrder(int order){
        if(order <= 0 || order >= 8)
            return;
        else
        {
            this.order=order;
        }
    }

    public String reportColor(){
        String temp=null;
        switch(this.color){
            case RED:   temp = "红色";break;
            case ORANGE:temp = "橙色";break;
            case YELLOW:temp = "黄色";break;
            case GREEN: temp = "绿色";break;
            case CYAN:  temp = "青色";break;
            case BLUE:  temp = "蓝色";break;
            case PURPLE:temp = "紫色";break;
        }
        return temp;
    }

    public String reportOrder(){
        String temp = null;
        switch(order){
            case 1:temp = "老大";break;
            case 2:temp = "老二";break;
            case 3:temp = "老三";break;
            case 4:temp = "老四";break;
            case 5:temp = "老五";break;
            case 6:temp = "老六";break;
            case 7:temp = "老七";break;
        }
        return temp;
    }
}

class Main{
    public static void Initialize(HULUWA[] members){
        members[0].setName("红娃");   members[0].setColor(COLOR.RED);    members[0].setOrder(1);
        members[1].setName("橙娃");   members[1].setColor(COLOR.ORANGE); members[1].setOrder(2);
        members[2].setName("黄娃");   members[2].setColor(COLOR.YELLOW); members[2].setOrder(3);
        members[3].setName("绿娃");   members[3].setColor(COLOR.GREEN);  members[3].setOrder(4);
        members[4].setName("青娃");   members[4].setColor(COLOR.CYAN);   members[4].setOrder(5);
        members[5].setName("蓝娃");   members[5].setColor(COLOR.BLUE);   members[5].setOrder(6);
        members[6].setName("紫娃");   members[6].setColor(COLOR.PURPLE); members[6].setOrder(7);
    }
    public static void main(String[] args){
        HULUWA[] members = new HULUWA[7];
        for(int i = 0;i < members.length;i++)
            members[i] = new HULUWA();

        Initialize(members);

        Queue queue = new Queue();

        queue.EnQueue(members);
        queue.ReportOrder();
        //queue.Display();
        queue.BubbleSort();
        queue.ReportOrder();

        queue.EnQueue(members);
        queue.ReportColor();
        //queue.Display();
        queue.QuickSort(0,members.length - 1);
        queue.ReportColor();
    }
}