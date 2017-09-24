public class calabash{
    private  Name name ;
    private Color color;

    public calabash(int index){
        this.name = Name.values()[index-1];
        this.color = Color.values()[index-1];
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void printName() {
        System.out.println(this.name.getName());
    }

    public Name getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void printColor() {
        System.out.println(this.color.getColor());
    }
}