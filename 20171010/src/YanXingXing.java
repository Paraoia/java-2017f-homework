//雁行形
public class YanXingXing implements Formation {
    @Override
    public void format(Queue queue) {
        Position[] copyPositions = queue.getPositions();
        for (int i=0; i<copyPositions.length; i++){
            copyPositions[i].setCoordX(copyPositions.length-1-i);
            copyPositions[i].getHolder().setPosition(copyPositions[i]);
        }
    }
}
