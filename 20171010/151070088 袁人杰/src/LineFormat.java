
public class LineFormat implements Formation {
    private int x,y;
    private int queueLength;
    @Override
    public void format(Queue queue, Coordinate start, Planar planar) {
        System.out.println("长蛇阵！");
        int planarSize=planar.getPlanarSize();
        queueLength=queue.getLength();
        x=start.getX();
        y=start.getY();

        for(int i=0;i<queueLength;i++){
            if (x>=0 && x<planarSize && y+i>=0 && y+i<planarSize){
                if(planar.getGridOF(x,y+i).isOccupied()){
                    System.out.println("Overlapping!");
                    return;
                }
            }
            else{
                System.out.println("Out of bound!");
                return;
            }
        }

        for(int i=0;i<queueLength;i++){
            planar.getGridOF(x,y+i).setHolder(queue.getGrid(i).getHolder());
        }

    }
}
