package HuluwaGo;

public class Xiezijing implements BadMan {

    Position position;

    @Override
    public void report(){
        System.out.print("蝎子精\t");
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
