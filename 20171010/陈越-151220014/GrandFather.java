package huluwa;

public class GrandFather implements Creature{

    @Override
    public void print() {
        System.out.print("爷爷");
    }

    @Override
    public void sit(Position position) {
        position.setHolder(this);
    }
}
