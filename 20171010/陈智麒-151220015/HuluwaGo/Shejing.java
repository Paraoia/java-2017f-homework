package HuluwaGo;

public class Shejing implements BadMan {
    private Position position;

    @Override
    public void report() {
        System.out.print("蛇精\t\t");
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
