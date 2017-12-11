import com.sun.org.apache.xpath.internal.operations.Or;

public class Huluwa extends Creature {

    public enum Order{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN}
    public enum Color{RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE}

    private Order order;
    private Color color;

    public Huluwa(Order order, Color color){
        super();
        this.order = order;
        this.color = color;
    }

    @Override
    public String speak() {
        return "Huluwa:"+this.order.name();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Huluwa){
            return this.order.ordinal() - ((Huluwa)o).order.ordinal();
        }else{
            return -1;
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
