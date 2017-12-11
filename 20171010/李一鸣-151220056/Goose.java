public class Goose implements Formation{
    @Override
    public void format(Queue queue){
        Position[] tmp = queue.getPositions();
        tmp[0].setX(6);
        tmp[0].setY(4);
        tmp[0].getHolder().setPosition(tmp[0]);
        for (int i=1; i<tmp.length; ++i) {
            tmp[i].setX(6+i);
            tmp[i].setY(4+i);
            tmp[i].getHolder().setPosition(tmp[i]);
        }
    }
}
