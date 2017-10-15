//二维平面
public class Flat {
    private Position[][] positions;
    private int row_num;

    public Position[][] getPositions() {
        return positions;
    }

    public int getRownum(){ return row_num;}

    public Flat(int n) {//n为二维空间行数和列数，该函数初始化一个平面
        this.row_num=n;
        this.positions = new Position[n][n];
//        this.creatures=new Creature[n][n];
        for (int i = 0; i < n; i++) {
            for(int j=0;j<n;j++){
                this.positions[i][j] = new Position(i,j);
            }
        }
    }

    public void setCreature(Creature creature,int x,int y) {//把指定物种安排进来,x,y为坐标
        if(x>=row_num||y>=row_num||x<0||y<0){
            System.out.println("置位失败");
            return;
        }

        creature.setPosition(this.positions[x][y]);
    }

    public void Shexing_queue(Creature[] creatures,int x,int y) {//站成蛇形,x,y为蛇形最上方坐标
        if(x>=row_num||y>=row_num||x<0||y<0||x+creatures.length>this.row_num){
            System.out.println("蛇形站队失败");
            return;
        }

        for(int i=0;i<creatures.length;i++){
            creatures[i].setPosition(this.positions[x+i][y]);
        }
    }

    public void Yanhang_queue(Creature[] creatures,int x,int y) {//站成雁行,x,y为最左下坐标
        if(x>=row_num||y>=row_num||x<0||y<0||x-creatures.length+1<0||y+creatures.length>row_num){
            System.out.println("雁行站队失败");
            return;
        }

        for(int i=0;i<creatures.length;i++){
            creatures[i].setPosition(this.positions[x-i][y+i]);
        }
    }

    public void Heyi_queue(Creature[] creatures,int x,int y) {//站成鹤翼,x,y为鹤翼中点坐标
        if(x>=row_num||y>=row_num||x<0||y<0||x-(creatures.length)/2<0||y-(creatures.length)/2<0||y+(creatures.length)/2>row_num){
            System.out.println("鹤翼站队失败");
            return;
        }

        for(int i=0;i<creatures.length;i++){
            if(i%2==0)
                creatures[i].setPosition(this.positions[x-i/2][y+i/2]);
            else
                creatures[i].setPosition(this.positions[x-(i+1)/2][y-(i+1)/2]);
        }
    }

    public void rollCall() {
        for (int i=0;i<row_num;i++) {
            for(int j=0;j<row_num;j++){
                if(positions[i][j].getBeOccupied()) {
                    positions[i][j].getHolder().report();
                }
                else{
                    System.out.print(String.format("%-15s",("@"+i+","+j+";")));
                }
            }
            System.out.print("\n");
            System.out.flush();
        }
        System.out.print("\n");
        System.out.print("\n");
    }

    public void cleanFlat(){
        for (int i=0;i<row_num;i++) {
            for (int j = 0; j < row_num; j++) {
                positions[i][j].setHolder(null);
                positions[i][j].setBeOccupied(false);
            }
        }
    }
}
