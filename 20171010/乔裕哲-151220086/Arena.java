public class Arena {
    final int N = 20;

    private Position [][]positions;

    Arena() {
        positions = new Position[N][N];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                this.positions[i][j] = new Position(i, j);
    }

    public void rollCall (){
        System.out.println("------------------------------------------");
        for(int i = 0; i < N; ++i) {
            String str = "|";
            for (int j = 0; j < N; ++j)
                if(positions[i][j].getHolder() == null)
                    str += "  ";
                else
                    str += positions[i][j].getHolder().report();
            str += "|";
            System.out.println(str);
        }
        System.out.println("------------------------------------------");
    }

    public void enter(Creature []creatures){
        for(Creature i : creatures){
            int x = i.getPosition().getX();
            int y = i.getPosition().getY();
            positions[y][x].setHolder(i);
        }
    }

    public void clear(){
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < N; ++j)
                positions[i][j].setHolder(null);
    }

    public void addCreature(Creature creature, Position pos){
        int x = pos.getX();
        int y = pos.getY();
        positions[y][x].setHolder(creature);
    }

    public Position[][] getPositions() {
        return positions;
    }
}
