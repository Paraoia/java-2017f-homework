public class Huluwa {
    public Order order;
    public Color color;
    public Huluwa(int i){
        switch (i){
            case 0:order = Order.老大; color = Color.红色; break;
            case 1:order = Order.老二; color = Color.橙色; break;
            case 2:order = Order.老三; color = Color.黄色; break;
            case 3:order = Order.老四; color = Color.绿色; break;
            case 4:order = Order.老五; color = Color.青色; break;
            case 5:order = Order.老六; color = Color.蓝色; break;
            case 6:order = Order.老七; color = Color.紫色; break;
        }
    }
    public void getOrder(){
        System.out.print(order+" ");
    }
    public void getColor(){
        System.out.print(color+" ");
    }
    public void changePos(int src, int des){
        System.out.println(":" + src +"->" + des);
    }
}