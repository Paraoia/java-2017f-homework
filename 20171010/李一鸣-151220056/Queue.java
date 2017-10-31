public class Queue {
    private Position[] positions;

    public Position[] getPositions() {
        return positions;
    }


    public Queue(int num) {
        this.positions = new Position[num];
        for (int i = 0; i < num; i++)
            this.positions[i] = new Position(0,i);
    }
    public void JoinIn(Creature creature){
        int index=0;
        while(positions[index].getHolder()!=null && index<positions.length)   //寻找一个空位
            index++;
        if (index!=positions.length){
            positions[index].setHolder(creature);
        }
        return;
    }
}
