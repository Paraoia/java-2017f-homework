//鋒矢形
public class FengShiXing implements Formation {
    @Override
    public void format(Queue queue) {
        Position[] copyPositions = queue.getPositions();
        if (copyPositions.length==0){ return; }
        int i=0;
        copyPositions[i].setCoord(new Coord(i,2));
        copyPositions[i].getHolder().setPosition(copyPositions[i]);
        for (i=1; i<copyPositions.length && i<3; i++){
            copyPositions[2*i-1].setCoord(new Coord(i,2-i));
            copyPositions[2*i-1].getHolder().setPosition(copyPositions[2*i-1]);
            copyPositions[2*i].setCoord(new Coord(i,2+i));
            copyPositions[2*i].getHolder().setPosition(copyPositions[2*i]);
        }
        for (i=5; i<copyPositions.length; i++){
            copyPositions[i].setCoord(new Coord(i-4,2));
            copyPositions[i].getHolder().setPosition(copyPositions[i]);
        }
    }
}
