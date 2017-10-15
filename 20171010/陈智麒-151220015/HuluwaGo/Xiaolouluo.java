package HuluwaGo;

public class Xiaolouluo implements BadMan {
    private Position position;

    @Override
    public void report() {
        System.out.print("小喽啰\t");
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
