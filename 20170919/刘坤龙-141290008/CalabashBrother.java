import java.util.*;


public class CalabashBrother{
    private String name;
    private String color;
    private int seniority;

    public CalabashBrother(String name,String color,int seniority){
        this.name = name;
        this.color = color;
        this.seniority = seniority;
    }

    public void getName() {
        System.out.println(this.name);
    }

    public void getColor() {
        System.out.println(this.color);
    }

    public int getSeniority() {
        return this.seniority;
    }

    public void moveTo(int from, int to){
        System.out.println(this.name + " : " + Integer.toString(from) + " -> " + Integer.toString(to));
    }
}
