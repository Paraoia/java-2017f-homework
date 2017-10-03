public class Huluwa {
    private int seniority;//like 1, 2, ……, 7
    private String name;//like "老大"
    private String color;//like "红色"

    public Huluwa(int seniority, String name, String color) {
        this.seniority = seniority;
        this.name = name;
        this.color = color;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void reportName(){
        System.out.println(name);
    }

    public void reportColor(){
        System.out.println(color);
    }

    public void reportPosition(int src, int dst){
        System.out.println(name + ":" + src + "->" + dst);
    }

}
