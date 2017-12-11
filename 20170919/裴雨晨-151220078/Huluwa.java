public class Huluwa {
    public Order order;
    public Color color;

    public Huluwa(Order o, Color c){
        this.order = o;
        this.color = c;
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