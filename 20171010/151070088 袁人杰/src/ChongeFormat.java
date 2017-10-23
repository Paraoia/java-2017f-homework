public class ChongeFormat implements Formation {
    private int x,y;
    private int queueLength;

    @Override
    public void format(Queue queue, Coordinate start, Planar planar) {
        System.out.println("冲轭阵！");
        int planarSize=planar.getPlanarSize();
        queueLength=queue.getLength();
        x=start.getX();
        y=start.getY();

        for(int i=0;i<queueLength;i++){
            if (x-1>=0 && x<planarSize && y+i>=0 && y+i<planarSize){
                if(planar.getGridOF((int)(x+Math.pow(-1,i)),y+i).isOccupied()){
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
            int curX=(int) (x+Math.pow(-1,i));
            int curY=y+i;
            planar.getGridOF(curX,curY).setHolder(queue.getGrid(i).getHolder());
        }
    }
}
