//方円形
public class FangYuanXing implements Formation{
    @Override
    public void format(Queue queue) {
        Position[] copyPositions = queue.getPositions();
        int refCoordY = (copyPositions.length+3)/4;
        for (int i=0; i<copyPositions.length; i++){
            int deltaY = Math.abs((i+1)/2 - refCoordY);
            if (i%2==0) {
                copyPositions[i].setCoord(new Coord((i+1)/2, 2*refCoordY-deltaY));
                copyPositions[i].getHolder().setPosition(copyPositions[i]);
            } else {
                copyPositions[i].setCoord(new Coord((i+1)/2, deltaY));
                copyPositions[i].getHolder().setPosition(copyPositions[i]);
            }
        }
    }
}
