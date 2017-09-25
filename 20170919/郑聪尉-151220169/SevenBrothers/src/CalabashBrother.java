/**
 * This class defines CalabashBrother.
 *
 */
public class CalabashBrother {
    private String name;
    private String color;
    private int seniority;

    public CalabashBrother(String name, String color, int seniority){
        this.name = name;
        this.color = color;
        this.seniority = seniority;
    }
    public String getName(){
        return name;
    }
    public String getColor(){
        return color;
    }
    public int getSeniority(){
        return seniority;
    }
}
