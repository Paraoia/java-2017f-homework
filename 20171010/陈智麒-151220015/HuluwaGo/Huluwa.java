package HuluwaGo;

public class Huluwa implements GoodMan, Comparable {

    private Color color;
    private Order order;
    private Position position;

    enum Color{
        红色,橙色,黄色,绿色,青色,蓝色,紫色;
    }

    enum Order {
        老大, 老二, 老三, 老四, 老五, 老六, 老七
    }

    Huluwa(Color color, Order order){
        this.color = color;
        this.order = order;
    }

    public Color getColor(){
        return color;
    }

    public Order getOrder(){
        return order;
    }

    public void sayOrderName() {
        System.out.print(order.toString());
    }

    public void sayColorName() {
        System.out.print(color.toString());
    }

    @Override
    public void report(){
        System.out.print(order.toString() + "\t\t");
    }

    @Override
    public void setPosition(Position position){
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean biggerThan(Comparable comparable){
        if(comparable instanceof Huluwa){
            return this.color.ordinal() > ((Huluwa) comparable).getColor().ordinal();
        }
        else{
            return false;
        }
    }
}
