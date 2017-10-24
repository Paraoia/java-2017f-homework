public class CraneWing implements Formation {
    @Override
    public void format(Queue queue){
        Position[] tmp = queue.getPositions();
        tmp[0].setX(8);
        tmp[0].setY(7);
        tmp[0].getHolder().setPosition(tmp[0]);
        for (int i=1; i<tmp.length; ++i) {
            if (i%2!=1) {
                tmp[i].setX(8 + i / 2);
                tmp[i].setY(7 + i / 2);
            }
            else {
                tmp[i].setX(8 + i / 2 + 1);
                tmp[i].setY(7 - i / 2 - 1);
            }
            tmp[i].getHolder().setPosition(tmp[i]);
        }
    }
}