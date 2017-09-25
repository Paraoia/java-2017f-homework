public class Huluwa{
    private int num;
    private String number;//like "老大"
    private String color;//like "红色"

    public Huluwa(int num, String number, String color) {
        this.num = num;
        this.number = number;
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void reportNumber(){
        System.out.println(number);
    }

    public void reportColor(){
        System.out.println(color);
    }

    public void reportPosition(int src, int dst){
        System.out.println(number + ":" + (src + 1) + "->" + (dst + 1));
    }

}

