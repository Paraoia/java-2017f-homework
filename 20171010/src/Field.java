public class Field {

    private Position[][] positions;

    public Field(int size){
        positions = new Position[size][size];
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                positions[i][j] = new Position(new Coord(i, j));
            }
        }
    }
    public void clearField(){
        for (int i=0; i<positions.length; i++){
            for (int j=0; j<positions.length; j++){
                positions[i][j].setHolder(null);
            }
        }
    }
    public void putCreatureIn(Creature creature, Coord coord){
        //檢查邊界，檢查holder衝突
        if (coord.isOutOfBound(positions.length, positions.length) || positions[coord.getX()][coord.getY()].holderOccupied()){ return; }
        creature.setPosition(new Position(coord));
        positions[coord.getX()][coord.getY()].setHolder(creature);
    }
    public void putQueueIn(Queue queue, Coord refCoord){
        Position[] copyPositions = queue.getPositions();
        for (int i=0; i<copyPositions.length; i++){
            Coord actualCoord = copyPositions[i].getCoord().plusRefCoord(refCoord);
            if (actualCoord.isOutOfBound(positions.length, positions.length) || positions[actualCoord.getX()][actualCoord.getY()].holderOccupied()){
                return;
            }
        }
        for (int i=0; i<copyPositions.length; i++){
            Coord actualCoord = copyPositions[i].getCoord().plusRefCoord(refCoord);
            copyPositions[i].getHolder().setPosition(positions[actualCoord.getX()][actualCoord.getY()]);
            positions[actualCoord.getX()][actualCoord.getY()].setHolder(copyPositions[i].getHolder());
        }
    }
    public void printSituation(){
        for (int i=0; i<positions.length; i++){
            for (int j=0; j<positions.length; j++){
                if (positions[i][j].getHolder()!=null){
                    positions[i][j].getHolder().repoName();
                } else {
                    System.out.print("      ");
                }
            }
            System.out.print("\n");
        }
    }

}
