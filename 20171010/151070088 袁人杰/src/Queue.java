public class Queue {
    private Grid[] queue;
    private int length;
    private int curIndex=0;

    public Queue(int length){
        this.length=length;
        queue = new Grid[length];
        for (int i=0;i<length;i++){
            queue[i]=new Grid(i,0);
        }
    }

    public int getLength() {
        return length;
    }

    public Grid getGrid(int index){
        return queue[index];
    }

    public void enQueue(Creature creature){
        if (curIndex>length-1){
            System.out.println("出界");
        }
        else {
            queue[curIndex].setHolder(creature);
            curIndex++;
        }
    }
}
