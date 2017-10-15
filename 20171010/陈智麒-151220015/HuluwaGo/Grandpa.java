package HuluwaGo;

public class Grandpa implements GoodMan {
    private Position position;

    @Override
    public void report() {
        System.out.print("老爷爷\t");
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
