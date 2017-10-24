 //長蛇形
public class ChangSheXing implements Formation{
    @Override
    public void format(Queue queue){
        Position[] copyPositions = queue.getPositions();
        for (int i=0; i<copyPositions.length; i++){
            copyPositions[i].setCoord(new Coord(i,0));
            copyPositions[i].getHolder().setPosition(copyPositions[i]);
        }
    }
}
