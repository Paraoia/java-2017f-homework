//鶴翼形
public class HeYiXing implements Formation {
    @Override
    public void format(Queue queue){
        Position[] copyPositions = queue.getPositions();
        for (int i=0; i<copyPositions.length/2; i++){
            copyPositions[i].setCoordX(i);
            copyPositions[i].getHolder().setPosition(copyPositions[i]);
            copyPositions[copyPositions.length-1-i].setCoordX(i);
            copyPositions[copyPositions.length-1-i].getHolder().setPosition(copyPositions[copyPositions.length-1-i]);
        }
        copyPositions[copyPositions.length/2].setCoordX(copyPositions.length/2);
        copyPositions[copyPositions.length/2].getHolder().setPosition(copyPositions[copyPositions.length/2]);
    }
}
