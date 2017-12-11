package HuluwaGo;

public class Map {
    private Position[][] positions;
    public Map(int N){
        positions = new Position[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                positions[i][j] = new Position(i, j);
            }
        }
    }

    public void putCreature(Creature creature, Position position){
        positions[position.getX()][position.getY()].setHolder(creature);
    }

    public void putQueue(Queue queue){
        for(Position p : queue.getPositions()){
            putCreature(p.getHolder(), p);
        }
    }

    public void dropAllQueue(){
        int N = positions.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                positions[i][j].setHolder(null);
            }
        }
    }

    public void show(){
        int N = positions.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(positions[i][j].getHolder() != null)
                    positions[i][j].getHolder().report();
                else
                    System.out.print("____\t");
            }
            System.out.println();
        }
    }
}
