public class Audience implements Formation{
    @Override
    public void format(Queue queue){
        Position[] tmp = queue.getPositions();
        tmp[0].setX(0);
        tmp[0].setY(0);
        tmp[0].getHolder().setPosition(tmp[0]);
        tmp[1].setX(14);
        tmp[1].setY(14);
        tmp[1].getHolder().setPosition(tmp[1]);
    }
}
