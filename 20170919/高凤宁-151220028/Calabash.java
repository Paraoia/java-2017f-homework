enum  COLOR{
    Red,Orange,Yellow,Green,Cyan,Blue,Purple
}

public class Calabash {
    private String name;
    private COLOR color;
    private int order;

    public void SetName(String name){
        this.name = name;
    }
    public void SetColor(COLOR color){
        this.color = color;
    }
    public void SetOrder(int order){
        if(order <= 0 || order >= 8)
            return;
        this.order = order;
    }

    public String GetName(){
        return name;
    }
    public COLOR GetColor(){
        return color;
    }
    public int GetOrder(){
        return order;
    }

    public String ReportColor(){
        String temp = null;
        switch(this.color){
            case Red:   temp = "红色";break;
            case Orange:temp = "橙色";break;
            case Yellow:temp = "黄色";break;
            case Green: temp = "绿色";break;
            case Cyan:  temp = "青色";break;
            case Blue:  temp = "蓝色";break;
            case Purple:temp = "紫色";break;
        }
        return temp;
    }
    public String ReportOrder(){
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
    public static void Initialize(Calabash[] members){
        members[0].SetName("红娃");   members[0].SetColor(COLOR.Red);    members[0].SetOrder(1);
        members[1].SetName("橙娃");   members[1].SetColor(COLOR.Orange); members[1].SetOrder(2);
        members[2].SetName("黄娃");   members[2].SetColor(COLOR.Yellow); members[2].SetOrder(3);
        members[3].SetName("绿娃");   members[3].SetColor(COLOR.Green);  members[3].SetOrder(4);
        members[4].SetName("青娃");   members[4].SetColor(COLOR.Cyan);   members[4].SetOrder(5);
        members[5].SetName("蓝娃");   members[5].SetColor(COLOR.Blue);   members[5].SetOrder(6);
        members[6].SetName("紫娃");   members[6].SetColor(COLOR.Purple); members[6].SetOrder(7);
    }
    public static void main(String[] args){
        Calabash[] members = new Calabash[7];
        for(int i = 0;i < members.length;i++)
            members[i] = new Calabash();

        Initialize(members);

        Queue queue = new Queue();

        queue.EnQueue(members);
        //queue.Display();
        queue.BubbleSort();
        queue.ReportOrder();

        queue.EnQueue(members);
        //queue.Display();
        queue.QuickSort(0,members.length - 1);
        queue.ReportColor();
    }
}