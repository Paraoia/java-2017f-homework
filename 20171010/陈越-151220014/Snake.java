package huluwa;

public class Snake implements Creature {

    @Override
    public void print() {
        System.out.print("蛇精");
    }

    public void sit(Position position) {
        position.setHolder(this);
    }
}
