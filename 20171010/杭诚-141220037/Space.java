public class Space {
    private static final int N = 20;
    Position[][] positions = new Position[N][N];
    Space(){
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++){
                positions[i][j] = new Position();
            }
    }
    public void clear(){
        for(int i = 0; i < N; i++)
            for(int j= 0; j < N; j++){
                if(positions[i][j].occupied)
                    positions[i][j].reset();
            }
    }
    public void display(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(positions[i][j].occupied)
                    System.out.print(positions[i][j].holder.name);
                else
                    System.out.print("----");
            }
            System.out.println();
        }
    }
}
