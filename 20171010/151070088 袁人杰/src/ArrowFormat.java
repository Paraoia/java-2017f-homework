public class ArrowFormat implements Formation{
    private int x,y;
    private int queueLength;

    @Override
    public void format(Queue queue, Coordinate start, Planar planar) {
        System.out.println("锋矢阵！");
        int planarSize=planar.getPlanarSize();
        queueLength=queue.getLength();
        x=start.getX();
        y=start.getY();

        for (int i=0;i<queueLength;i++){
            if (i==0){
                planar.getGridOF(x,y).setHolder(queue.getGrid(i).getHolder());
            }
            else if (i<10){
                if (i%3==1){planar.getGridOF(x-1-i/3,y+1+(i-1)/3).setHolder(queue.getGrid(i).getHolder()); }
                if (i%3==2){planar.getGridOF(x,y+1+(i-1)/3).setHolder(queue.getGrid(i).getHolder()); }
                if (i%3==0){planar.getGridOF(x+i/3,y+1+(i-1)/3).setHolder(queue.getGrid(i).getHolder()); }
            }
            else
                planar.getGridOF(x,y+i-6).setHolder(queue.getGrid(i).getHolder());
        }


    }
}
