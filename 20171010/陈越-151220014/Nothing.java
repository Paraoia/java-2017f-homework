package huluwa;

public class Nothing implements Creature{
    public void print() {
        System.out.print("    ");
    }
    public void sit(Position position) {
        position.setHolder(this);
    }
}
