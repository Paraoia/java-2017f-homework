import java.util.*;

class Queue{

    private Position[] positions;
    final int defaultRow = 0;

    public Queue(int length){
        positions = new Position[length];
        for (int i=0; i<length; i++){
            this.positions[i] = new Position(new Coord(defaultRow, i));
        }
    }
    public Position[] getPositions() { return positions; }
    //單人入隊
    public void enqueue(Creature creature){
        int startPoint=0;
        while (positions[startPoint].getHolder()!=null && startPoint<positions.length) startPoint++;
        if (startPoint==positions.length){ return; }
        positions[startPoint].setHolder(creature);
        creature.setPosition(positions[startPoint]);
    }
    //多人随机入队
    public void randomEnqueue(Creature[] creatures) {
        if (creatures.length > this.positions.length) { return; }
        for (int i=0; i<positions.length; i++){
            int randomIndex = new Random().nextInt(positions.length);
            while (positions[randomIndex].getHolder() != null){
                randomIndex = new Random().nextInt(positions.length);
            }
            creatures[i].setPosition(this.positions[randomIndex]);
        }
    }
    public void clearQueue(){
        for (int i=0; i<positions.length; i++){ positions[i].setHolder(null); }
    }
    /*
    // test
    public void test(){
        for (int i=0; i<positions.length; i++){
            positions[i].getHolder().repoName();
            System.out.print(positions[i].getHolder().getPosition().getCoord().getX() + "," + positions[i].getHolder().getPosition().getCoord().getY());
        }
        System.out.print("\n");
    }
    */
}

