/**
 * Created by joker on 17-9-26.
 */
public class Brother {
    private int num;
    Brother(int number){
        num = number;
        name = Name.values()[number];
        color = Color.values()[number];
    }
    public int getNum(){
        return num;
    }
    Color color;
    Name name;
    public enum Name{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN};
    public enum Color{RED, ORANGE,YELLOW, GREEN, CYAN, BLUE, PURPLE};
    public String getColor(){
        return color.name();
    }

    public String getName(){
        return name.name();
    }
}


