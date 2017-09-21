package HuluWaSort;

public class HuluWa {
    int value;
    String orderName;
    String colorName;
    HuluWa(int value, String orderName, String colorName){
        this.value = value;
        this.orderName = orderName;
        this.colorName = colorName;
    }
    public void sayOrderName(){
        System.out.print(orderName + " ");
    }
    public void sayColorName(){
        System.out.print(colorName + " ");
    }
    public void report(int h1, int h2){
        System.out.print(this.orderName + ":" + h1 + "->" + h2 + " ");
    }
}