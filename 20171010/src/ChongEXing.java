//衝軛形
public class ChongEXing implements Formation {
    @Override
    public void format(Queue queue) {
        Position[] copyPositions = queue.getPositions();
        for (int i=0; i<copyPositions.length; i++){
            copyPositions[i].setCoord(new Coord(i,(i+1)%2));
            copyPositions[i].getHolder().setPosition(copyPositions[i]);
        }
    }
}
