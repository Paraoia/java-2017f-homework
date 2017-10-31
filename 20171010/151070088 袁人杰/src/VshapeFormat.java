public class VshapeFormat implements Formation{
    private int x,y;
    private int queueLength;

    @Override
    public void format(Queue queue, Coordinate start, Planar planar) {
        System.out.println("鹤翼阵！");
        int planarSize=planar.getPlanarSize();
        queueLength=queue.getLength();
        x=start.getX();
        y=start.getY();

        for (int i=0;i<queueLength;i++){
            int curX=x+(int)((i+1)/2*(-1));
            int curY=y+(int)((i+1)/2*Math.pow(-1,i));
            planar.getGridOF(curX,curY).setHolder(queue.getGrid(i).getHolder());
        }
    }
}
