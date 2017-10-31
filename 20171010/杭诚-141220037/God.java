public class God {
    public void hulu_shape(Creature[] hulus, Space space, int x, int y){
        for(int i = 0; i < hulus.length; i++){
            space.positions[x+i][y].set(hulus[i]);
        }
    }

    public void scorp_shape_goose(Creature scorp, Creature[] loluos, Space space, int x, int y) {
        space.positions[x][y].set(scorp);
        for(int i =0; i < 3; i++){
            space.positions[x-i-1][y-i-1].set(loluos[2*i]);
            space.positions[x-i-1][y+i+1].set(loluos[2*i+1]);
        }
    }

    public void scorp_shape_edge(Creature scorp, Creature[] loluos, Space space, int x, int y){
        space.positions[x][y].set(scorp);
        for(int i = 0; i < 2;i++){
            space.positions[x+i+1][y].set(loluos[3*i]);
            space.positions[x+i+1][y+i+1].set(loluos[3*i+1]);
            space.positions[x+i+1][y-i-1].set(loluos[3*i+2]);
        }
    }

    public void grandpa_snake(Creature pa, Creature snake, Space space, int x1, int y1, int x2, int y2){
        space.positions[x1][y1].set(pa);
        space.positions[x2][y2].set(snake);
    }
}
