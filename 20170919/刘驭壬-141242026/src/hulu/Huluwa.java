package hulu;

public class Huluwa {
    private String name;
    private String color;
    private int rank;

    Huluwa(String name, String color, int rank){
        this.name = name;
        this.color = color;
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getRank() {
        return rank;
    }
}
