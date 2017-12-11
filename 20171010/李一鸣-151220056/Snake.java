public class Snake implements Formation {
    @Override
    public void format(Queue queue){
        Position[] tmp = queue.getPositions();
        for (int i=0; i<tmp.length; ++i) {
            tmp[i].setX(0);
            tmp[i].setY(i + 4);
            tmp[i].getHolder().setPosition(tmp[i]);
        }
    }
}
