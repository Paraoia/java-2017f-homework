package huluwa;

public class Scorpion implements Creature{
    @Override
    public void print() {
        System.out.print("蝎子");
    }
    public void sit(Position position) {
        position.setHolder(this);
    }

}
