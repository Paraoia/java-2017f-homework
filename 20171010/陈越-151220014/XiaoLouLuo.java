package huluwa;

public class XiaoLouLuo implements Creature{
    @Override
    public void print() {
        System.out.print("喽啰");
    }
    public void sit(Position position) {
        position.setHolder(this);
    }
}
