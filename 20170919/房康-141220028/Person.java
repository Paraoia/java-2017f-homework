public class Person {

    public enum Color{RED,ORANGE,YELLOW,GREEN,CYAN,BLUE,PURPLE};
    public enum Order{ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN};

    private Order order;
    private Color color;

    public Person(Order index, Color color){
        this.order = index;
        this.color = color;
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

    public void talk(){
        String str = "I am brother " + this.order.name() + " and my color is " + this.color.name();
        System.out.println(str);
    }
}
